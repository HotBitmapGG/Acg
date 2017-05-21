package com.example.cnsunrun.debugdemo.mvp.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziInfo;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.ImageDetailsActivity;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.base.AbsRecyclerViewAdapter;
import com.example.cnsunrun.debugdemo.widget.CircleImageView;
import com.example.cnsunrun.debugdemo.widget.MomentPicView;

import java.util.List;

/**
 * Created by cnsunrun on 2017/4/24.
 */

public class CopyDetailsAdapter extends AbsRecyclerViewAdapter<QuanziInfo.BlogListBean> {

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            QuanziInfo.BlogListBean blogListBean = mDataSources.get(position);
            Glide.with(getContext())
                    .load(blogListBean.getHeadpic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(itemViewHolder.mUserPhoto);
            itemViewHolder.mUserName.setText(blogListBean.getNicename());
            itemViewHolder.mTime.setText(blogListBean.getJointime());
            itemViewHolder.mContent.setText(blogListBean.getContent());
            List<QuanziInfo.BlogListBean.TagnamesBean> tagnames = blogListBean.getTagnames();
            if (!tagnames.isEmpty())
                itemViewHolder.mTags.setText(tagnames.get(0).getName());
            if (blogListBean.getPicturelist() != null && blogListBean.getPicturelist().size() > 0) {
                itemViewHolder.momentPicView.setImageUrls(blogListBean.getPicturelist());
                itemViewHolder.momentPicView.setOnClickItemListener((i, url) -> {
                    Intent intent = new Intent(getContext(), ImageDetailsActivity.class);
                    intent.putExtra("index", i);
                    intent.putExtra("images_url", url);
                    getContext().startActivity(intent);
                });
            }
            itemViewHolder.mForwardedNum.setText(blogListBean.getZhuanfa_counter().equals("0") ? "转发" : blogListBean.getZhuanfa_counter());
            itemViewHolder.mCommentNum.setText(blogListBean.getComment_counter().equals("0") ? "评论" : blogListBean.getComment_counter());
            itemViewHolder.mLikeNum.setText(blogListBean.getFavour_counter().equals("0") ? "喜欢" : blogListBean.getFavour_counter());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_copy_details, parent, false));
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {
        CircleImageView mUserPhoto;
        TextView mUserName;
        TextView mTime;
        TextView mContent;
        MomentPicView momentPicView;
        TextView mTags;
        TextView mForwardedNum;
        TextView mCommentNum;
        TextView mLikeNum;


        public ItemViewHolder(View itemView) {
            super(itemView);
            mUserPhoto = $(R.id.item_author_avatar);
            mUserName = $(R.id.item_author_name);
            mTime = $(R.id.item_time);
            mContent = $(R.id.item_content);
            momentPicView = $(R.id.item_multi_image);
            mTags = $(R.id.item_tag);
            mForwardedNum = $(R.id.tv_forwarded);
            mCommentNum = $(R.id.tv_comment_count);
            mLikeNum = $(R.id.tv_favour_count);
        }
    }
}
