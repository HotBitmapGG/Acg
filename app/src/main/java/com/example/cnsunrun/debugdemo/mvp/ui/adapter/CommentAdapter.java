package com.example.cnsunrun.debugdemo.mvp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziDetailsInfo;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.base.AbsRecyclerViewAdapter;
import com.example.cnsunrun.debugdemo.widget.CircleImageView;

/**
 * Created by cnsunrun on 2017/4/20.
 */

public class CommentAdapter extends AbsRecyclerViewAdapter<QuanziDetailsInfo.CommentListBean> {

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            QuanziDetailsInfo.CommentListBean commentListBean = mDataSources.get(position);
            Glide.with(getContext())
                    .load(commentListBean.getHeadpic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(itemViewHolder.mHeadImage);
            itemViewHolder.mUserName.setText(commentListBean.getNicename());
            itemViewHolder.mDate.setText(commentListBean.getJointime());
            itemViewHolder.mContent.setText(commentListBean.getContent());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_comment, parent, false));
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {
        CircleImageView mHeadImage;
        TextView mUserName;
        TextView mDate;
        TextView mContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mHeadImage = $(R.id.item_head_image);
            mUserName = $(R.id.item_user_name);
            mDate = $(R.id.item_date);
            mContent = $(R.id.item_content);
        }
    }
}
