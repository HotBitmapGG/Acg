package com.example.cnsunrun.debugdemo.mvp.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.model.bean.CopyInfo;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.base.AbsRecyclerViewAdapter;

/**
 * Created by cnsunrun on 2017/4/19.
 */

public class CopyAdapter extends AbsRecyclerViewAdapter<CopyInfo.ActivityoListBean> {

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            CopyInfo.ActivityoListBean activityoListBean = mDataSources.get(position);
            Glide.with(getContext())
                    .load(activityoListBean.getPicture())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .into(itemViewHolder.mCopyImage);
            itemViewHolder.mCopyName.setText("副本：" + activityoListBean.getName());
            itemViewHolder.mCopyFounder.setText("队长：" + activityoListBean.getUser_name());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_copy, parent, false));
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {
        ImageView mCopyImage;
        TextView mCopyName;
        TextView mCopyFounder;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mCopyImage = $(R.id.item_image);
            mCopyName = $(R.id.item_copy_name);
            mCopyFounder = $(R.id.item_copy_founder);
        }
    }
}
