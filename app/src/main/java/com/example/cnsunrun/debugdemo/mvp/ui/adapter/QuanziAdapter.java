package com.example.cnsunrun.debugdemo.mvp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziInfo;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.base.AbsRecyclerViewAdapter;
import com.example.cnsunrun.debugdemo.widget.CircleImageView;

/**
 * Created by cnsunrun on 2017/3/11.
 */

public class QuanziAdapter extends AbsRecyclerViewAdapter<QuanziInfo.BlogListBean> {

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_quanzi, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            QuanziInfo.BlogListBean blogListBean = mDataSources.get(position);
            Glide.with(getContext())
                    .load(blogListBean.getPicture())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemViewHolder.mCoverImage);
            Glide.with(getContext())
                    .load(blogListBean.getHeadpic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(itemViewHolder.mHeadImage);
            itemViewHolder.mContent.setText(blogListBean.getContent());
            itemViewHolder.mUserName.setText(blogListBean.getNicename());
            itemViewHolder.mDate.setText(blogListBean.getJointime());
            itemViewHolder.mForwardingNum.setText(blogListBean.getZhuanfa_counter());
            itemViewHolder.mCommentNum.setText(blogListBean.getComment_counter());
            itemViewHolder.mLikeNum.setText(blogListBean.getFavour_counter());
        }
        super.onBindViewHolder(holder, position);
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mCoverImage;
        CircleImageView mHeadImage;
        TextView mUserName;
        TextView mDate;
        TextView mContent;
        TextView mForwardingNum;
        TextView mCommentNum;
        TextView mLikeNum;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mCoverImage = $(R.id.item_image);
            mContent = $(R.id.item_text);
            mHeadImage = $(R.id.item_head_image);
            mUserName = $(R.id.item_user_name);
            mDate = $(R.id.item_date);
            mForwardingNum = $(R.id.item_forwarding);
            mCommentNum = $(R.id.item_comment);
            mLikeNum = $(R.id.item_like);

        }
    }
}
