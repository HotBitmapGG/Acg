package com.example.cnsunrun.debugdemo.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.app.AppConstant;
import com.example.cnsunrun.debugdemo.mvp.model.bean.CopyDetailsInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.base.BaseResponseInfo;
import com.example.cnsunrun.debugdemo.mvp.model.network.RetrofitHelper;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.CopyDetailsAdapter;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.base.EndlessRecyclerOnScrollListener;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.base.HeaderViewRecyclerAdapter;
import com.example.cnsunrun.debugdemo.utils.DisplayUtil;
import com.example.cnsunrun.debugdemo.widget.CircleProgressView;
import com.example.cnsunrun.debugdemo.widget.MomentPicView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cnsunrun on 2017/4/20.
 * <p>
 * 副本详情界面
 */

public class CopyDetailsActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgress;

    ImageView mCover;
    TextView mType;
    TextView mNoticeMore;
    TextView mContent;
    TextView mTime;
    LinearLayout mPhotoAlbumLayout;
    LinearLayout mMessageBoardLayout;
    TextView mBlogHasNotice;
    TextView mAnnouncementText;
    TextView mPhotoCount;
    MomentPicView momentPicView;
    TextView mMessageCount;
    LinearLayout mMessageLayout;
    private String activityId;
    private CopyDetailsInfo.ResultBean copyDetailsResult;
    private List<QuanziInfo.BlogListBean> blogList = new ArrayList<>();
    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;
    private LinearLayout mNoticeLayout;
    private TagFlowLayout mTagFlowLayout;
    private RelativeLayout mTagsLayout;
    private RelativeLayout mTimeLayout;
    private CopyDetailsAdapter mAdapter;
    private View headView;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_details);
        activityId = getIntent().getStringExtra("activityId");
        ButterKnife.bind(this);
        loadData();
        initToolBar();
        initRecyclerView();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void loadData() {

        Disposable subscribe = RetrofitHelper.createCopyService()
                .getCopyDetails(activityId, "d89a68bddc0784e750f6f841eeb61647#")
                .doOnSubscribe(subscription -> {
                    mCircleProgress.setVisibility(View.VISIBLE);
                    mCircleProgress.spin();
                    mRecyclerView.setVisibility(View.GONE);
                })
                .filter(copyDetailsInfoBaseResponseInfo -> copyDetailsInfoBaseResponseInfo.getCode().equals(AppConstant.SUCCESS_CODE))
                .map(CopyDetailsInfo::getResult)
                .flatMap(new Function<CopyDetailsInfo.ResultBean, Publisher<BaseResponseInfo<QuanziInfo>>>() {
                    @Override
                    public Publisher<BaseResponseInfo<QuanziInfo>> apply(CopyDetailsInfo.ResultBean resultBean) throws Exception {
                        copyDetailsResult = resultBean;
                        return RetrofitHelper.createQuanziService()
                                .getQuanziInfos(-1, Long.valueOf(activityId), -1, 8, -1, -1, "dbe5b18fe665dbc25d22cdeb2d5cc436#");
                    }
                })
                .map(BaseResponseInfo::getBaseResult)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(quanziInfo -> {
                    blogList.addAll(quanziInfo.getBlogList());
                    mCircleProgress.setVisibility(View.GONE);
                    mCircleProgress.stopSpinning();
                    mRecyclerView.setVisibility(View.VISIBLE);
                    finishTask();
                }, throwable -> Log.e("tag", throwable.getMessage()));

        compositeDisposable.add(subscribe);
    }

    @SuppressLint("SetTextI18n")
    private void finishTask() {
        //设置副本详情数据
        mToolbar.setTitle(copyDetailsResult.getActivityDetail().getName());
        //设置类型
        mType.setText(copyDetailsResult.getActivityDetail().getForm());
        //设置时间
        if (TextUtils.isEmpty(copyDetailsResult.getActivityDetail().getTimestr())) {
            mTimeLayout.setVisibility(View.GONE);
        } else {
            mTimeLayout.setVisibility(View.VISIBLE);
            mTime.setText(copyDetailsResult.getActivityDetail().getTimestr());
        }
        //设置封面图片
        Glide.with(this)
                .load(copyDetailsResult.getActivityDetail().getPicture())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mCover);
        //设置公告
        if (TextUtils.isEmpty(copyDetailsResult.getActivityDetail().getAnnouncement())) {
            mNoticeLayout.setVisibility(View.GONE);
        } else {
            mNoticeLayout.setVisibility(View.VISIBLE);
            mAnnouncementText.setText(copyDetailsResult.getActivityDetail().getAnnouncement());
        }
        //设置简介
        mContent.setText(copyDetailsResult.getActivityDetail().getContent());
        //设置标签
        List<CopyDetailsInfo.ResultBean.ActivityDetailBean.TaglistBean> taglist = copyDetailsResult.getActivityDetail().getTaglist();
        if (taglist != null && taglist.size() > 0) {
            mTagsLayout.setVisibility(View.VISIBLE);
            mTagFlowLayout.setAdapter(new TagAdapter<CopyDetailsInfo.ResultBean.ActivityDetailBean.TaglistBean>(taglist) {

                @Override
                public View getView(FlowLayout parent, int position, CopyDetailsInfo.ResultBean.ActivityDetailBean.TaglistBean taglistBean) {
                    TextView mTextView = (TextView) LayoutInflater.from(CopyDetailsActivity.this).inflate(R.layout.layout_item_tag, parent, false);
                    mTextView.setText(taglist.get(position).getTag());

                    return mTextView;
                }
            });
        } else {
            mTagsLayout.setVisibility(View.GONE);
        }

        //设置相册
        mPhotoCount.setText("相册 " + copyDetailsResult.getActivityDetail().getPicturemodulecount());
        if (copyDetailsResult.getActivityDetail().getPicturemodules() != null) {
            mPhotoAlbumLayout.setVisibility(View.VISIBLE);
            momentPicView.setImageUrls(copyDetailsResult.getActivityDetail().getPicturemodules());
        } else {
            mPhotoAlbumLayout.setVisibility(View.GONE);
        }
        momentPicView.setOnClickItemListener((i, url) -> {
            Intent intent = new Intent(CopyDetailsActivity.this, ImageDetailsActivity.class);
            intent.putExtra("index", i);
            intent.putExtra("images_url", url);
            CopyDetailsActivity.this.startActivity(intent);
        });
        //设置留言板
        mMessageCount.setText("留言板 " + copyDetailsResult.getActivityDetail().getMessagemodulecount());
        if (copyDetailsResult.getActivityDetail().getMessagemodules() != null) {
            mMessageBoardLayout.setVisibility(View.VISIBLE);
            mMessageLayout.removeAllViews();
            mMessageLayout.setVisibility(copyDetailsResult.getActivityDetail().getMessagemodules().isEmpty() ? View.GONE : View.VISIBLE);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            LinearLayout.LayoutParams rowLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            for (int i = 0; i < copyDetailsResult.getActivityDetail().getMessagemodules().size(); i++) {
                CopyDetailsInfo.ResultBean.ActivityDetailBean.MessagemodulesBean messagemodulesBean = copyDetailsResult.getActivityDetail().getMessagemodules().get(i);
                LinearLayout row = new LinearLayout(this);
                rowLp.topMargin = i > 0 ? (int) DisplayUtil.dpToPx(6) : 0;
                row.setLayoutParams(rowLp);
                TextView tvMessage = new TextView(this);
                tvMessage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
                tvMessage.setMaxLines(2);
                tvMessage.setEllipsize(TextUtils.TruncateAt.END);
                tvMessage.setLayoutParams(lp);
                tvMessage.setText(messagemodulesBean.getUser_name() + "：" + messagemodulesBean.getContent());
                tvMessage.setTextColor(getResources().getColor(R.color.textColorPrimaryBlack));
                row.addView(tvMessage);

                TextView tvFloor = new TextView(this);
                tvFloor.setText(messagemodulesBean.getFloor() + "楼");
                tvFloor.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
                tvFloor.setTextColor(getResources().getColor(R.color.textColorPrimaryHint));
                tvFloor.setPadding((int) DisplayUtil.dpToPx(3), 0, 0, 0);
                row.addView(tvFloor);

                mMessageLayout.addView(row);
            }
        } else {
            mMessageBoardLayout.setVisibility(View.GONE);
        }
        //刷新列表数据
        mHeaderViewRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new CopyDetailsAdapter();
        mAdapter.setDataSources(blogList);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        createHeadView();
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {
            QuanziInfo.BlogListBean blogListBean = blogList.get(position);
            Intent intent = new Intent(CopyDetailsActivity.this, QuanziDetailsActivity.class);
            intent.putExtra("id", blogListBean.getBlog_id());
            intent.putExtra("title",blogList.get(position).getContent());
            CopyDetailsActivity.this.startActivity(intent);
        });

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });

    }

    private void createHeadView() {
        headView = LayoutInflater.from(this)
                .inflate(R.layout.layout_head_copy_details, mRecyclerView, false);
        mCover = (ImageView) headView.findViewById(R.id.iv_cover);
        mType = (TextView) headView.findViewById(R.id.tv_type);
        mNoticeMore = (TextView) headView.findViewById(R.id.notice_more);
        mContent = (TextView) headView.findViewById(R.id.tv_content);
        mTime = (TextView) headView.findViewById(R.id.tv_time);
        mTagFlowLayout = (TagFlowLayout) headView.findViewById(R.id.tag_flow_layout);
        mPhotoAlbumLayout = (LinearLayout) headView.findViewById(R.id.ll_photo_album);
        mMessageBoardLayout = (LinearLayout) headView.findViewById(R.id.ll_message_board);
        mBlogHasNotice = (TextView) headView.findViewById(R.id.blog_has_notice);
        mAnnouncementText = (TextView) headView.findViewById(R.id.announcement_text);
        mPhotoCount = (TextView) headView.findViewById(R.id.tv_photo_count);
        momentPicView = (MomentPicView) headView.findViewById(R.id.pwv_photos);
        mMessageCount = (TextView) headView.findViewById(R.id.tv_message_count);
        mMessageLayout = (LinearLayout) headView.findViewById(R.id.ll_messages);
        mNoticeLayout = (LinearLayout) headView.findViewById(R.id.event_notice_layout);
        mTagsLayout = (RelativeLayout) headView.findViewById(R.id.rl_tags);
        mTimeLayout = (RelativeLayout) headView.findViewById(R.id.rl_time);
    }

    public void loadMoreData() {
        long lastId = -1;
        long hotLastId = -1;
        int size = blogList.size();
        if (size >= 2) {
            lastId = Long.valueOf(blogList.get(blogList.size() - 2).getBlog_id());
            hotLastId = Long.valueOf(blogList.get(blogList.size() - 1).getBlog_id());
        }
        Disposable subscribe = RetrofitHelper.createQuanziService()
                .getQuanziInfos(lastId, Long.valueOf(activityId), hotLastId, 8, -1, -1,
                        "dbe5b18fe665dbc25d22cdeb2d5cc436#")
                .observeOn(AndroidSchedulers.mainThread())
                .filter(quanziInfoBaseResponseInfo -> {
                    switch (quanziInfoBaseResponseInfo.getMessage()) {
                        case "BlogList ok":
                            return true;
                        case "nomore":
                            Toast.makeText(CopyDetailsActivity.this, "没有更多了", Toast.LENGTH_SHORT).show();
                            return false;
                        default:
                            Toast.makeText(CopyDetailsActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                            return false;
                    }
                })
                .map(quanziInfoBaseResponseInfo -> quanziInfoBaseResponseInfo.getBaseResult().getBlogList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(blogListBeen -> {
                    blogList.addAll(blogListBeen);
                    mAdapter.setDataSources(blogList);
                    mAdapter.notifyDataSetChanged();

                }, throwable -> Log.e("tag", throwable.getMessage()));

        compositeDisposable.add(subscribe);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        compositeDisposable.clear();
        super.onDestroy();
    }
}
