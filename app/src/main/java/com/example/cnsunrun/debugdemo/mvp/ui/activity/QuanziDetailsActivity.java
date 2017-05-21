package com.example.cnsunrun.debugdemo.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziDetailsInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.base.BaseResponseInfo;
import com.example.cnsunrun.debugdemo.mvp.model.network.RetrofitHelper;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.CommentAdapter;
import com.example.cnsunrun.debugdemo.widget.CircleImageView;
import com.example.cnsunrun.debugdemo.widget.CircleProgressView;
import com.example.cnsunrun.debugdemo.widget.MomentPicView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QuanziDetailsActivity extends AppCompatActivity {

    @Bind(R.id.multi_image)
    MomentPicView momentPicView;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.iv_head_image)
    CircleImageView mHeadImage;
    @Bind(R.id.tv_user_name)
    TextView mUserName;
    @Bind(R.id.tv_date)
    TextView mDate;
    @Bind(R.id.tv_content)
    TextView mContent;
    @Bind(R.id.tv_tags)
    TextView mTags;
    @Bind(R.id.tv_like_num)
    TextView mLikeNum;
    @Bind(R.id.tv_comments)
    TextView mComments;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;
    @Bind(R.id.root_layout)
    LinearLayout mRootLayout;
    @Bind(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;
    @Bind(R.id.single_image)
    ImageView mSingleImage;

    private String id;
    private QuanziDetailsInfo mQuanziDetailsInfo;
    private Disposable subscribe;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanzi_details);
        ButterKnife.bind(this);
        mNestedScrollView.setNestedScrollingEnabled(true);
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            title = intent.getStringExtra("title");
        }
        initToolBar();
        loadData();
    }

    private void initToolBar() {
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadData() {
        subscribe = RetrofitHelper.createQuanziService()
                .getQuanziDetailsInfo(id, "dbe5b18fe665dbc25d22cdeb2d5cc436#")
                .doOnSubscribe(subscription -> {
                    mRootLayout.setVisibility(View.GONE);
                    mCircleProgressView.setVisibility(View.VISIBLE);
                    mCircleProgressView.spin();
                })
                .filter(quanziDetailsInfoBaseResponseInfo -> quanziDetailsInfoBaseResponseInfo.getCode().equals("10000"))
                .map(BaseResponseInfo::getBaseResult)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> {
                    mRootLayout.setVisibility(View.VISIBLE);
                    mCircleProgressView.setVisibility(View.GONE);
                    mCircleProgressView.stopSpinning();
                })
                .subscribe(quanziDetailsInfo -> {
                    mQuanziDetailsInfo = quanziDetailsInfo;
                    finishTask();
                }, throwable -> Log.e("tag", throwable.getMessage()));

    }

    @SuppressLint("SetTextI18n")
    private void finishTask() {
        //设置详情数据
        QuanziDetailsInfo.BlogBean blog = mQuanziDetailsInfo.getBlog();
        QuanziDetailsInfo.UserBean user = mQuanziDetailsInfo.getUser();
        List<QuanziDetailsInfo.CommentListBean> commentList = mQuanziDetailsInfo.getCommentList();
        //设置用户信息
        Glide.with(this)
                .load(user.getHeadpic())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(mHeadImage);
        mUserName.setText(user.getNicename());
        mDate.setText(blog.getJointime());
        //设置内容
        mContent.setText(blog.getContent());
        //设置图片
        List<String> picturelist = blog.getPicturelist();
        if (picturelist != null && picturelist.size() > 0) {
            if (picturelist.size() > 1) {
                //设置多张图片展示
                mSingleImage.setVisibility(View.GONE);
                momentPicView.setImageUrls(picturelist);
                momentPicView.setOnClickItemListener((i, url) -> {
                    Intent intent = new Intent(QuanziDetailsActivity.this, ImageDetailsActivity.class);
                    intent.putExtra("index", i);
                    intent.putExtra("images_url", url);
                    QuanziDetailsActivity.this.startActivity(intent);
                });
            } else {
                //单张图片展示
                mSingleImage.setVisibility(View.VISIBLE);
                Glide.with(this)
                        .load(picturelist.get(0))
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .crossFade(0)
                        .into(mSingleImage);
                mSingleImage.setOnClickListener(v -> {
                    ArrayList<String> urls = new ArrayList<>();
                    urls.add(picturelist.get(0));
                    Intent intent = new Intent(QuanziDetailsActivity.this, ImageDetailsActivity.class);
                    intent.putExtra("index", 0);
                    intent.putExtra("images_url", urls);
                    QuanziDetailsActivity.this.startActivity(intent);
                });
            }

        }
        //设置标签
        List<QuanziDetailsInfo.BlogBean.TagnamesBean> tagnames = blog.getTagnames();
        tagnames.forEach(tagnamesBean -> mTags.append(tagnamesBean.getName() + ","));
        //设置喜欢数量
        mLikeNum.setText(blog.getFavour_counter());
        //设置评论数量
        mComments.setText("评论 " + blog.getComment_counter());
        //设置评论列表
        if (commentList != null && commentList.size() > 0) {
            mComments.setVisibility(View.VISIBLE);
            mRecyclerView.setHasFixedSize(false);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setNestedScrollingEnabled(false);
            CommentAdapter mAdapter = new CommentAdapter();
            mAdapter.setDataSources(commentList);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mComments.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        if (subscribe != null && !subscribe.isDisposed()) {
            subscribe.dispose();
        }
        super.onDestroy();
    }
}
