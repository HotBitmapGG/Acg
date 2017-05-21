package com.example.cnsunrun.debugdemo.mvp.ui.adapter.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;


public abstract class AbsRecyclerViewAdapter<T>
        extends RecyclerView.Adapter<AbsRecyclerViewAdapter.ClickableViewHolder> {

    private Context context;

    public List<T> mDataSources;

    private OnItemClickListener itemClickListener;

    private OnItemLongClickListener itemLongClickListener;


    public void setOnItemClickListener(OnItemClickListener listener) {

        this.itemClickListener = listener;
    }


    public void setOnItemLongClickListener(OnItemLongClickListener listener) {

        this.itemLongClickListener = listener;
    }


    /**
     * 设置RecyclerView数据源
     */
    public void setDataSources(List<T> dataSources) {

        this.mDataSources = dataSources;
    }


    /**
     * 设置RecyclerView的count
     */
    @Override
    public int getItemCount() {

        return mDataSources == null ? 0 : mDataSources.size();
    }


    /**
     * 设置Context
     */
    public void bindContext(Context context) {

        this.context = context;
    }


    /**
     * 获取Context
     */
    public Context getContext() {

        return this.context;
    }


    /**
     * 重写onBindViewHolder设置item的点击和长按事件的监听
     */
    @Override
    public void onBindViewHolder(final ClickableViewHolder holder, final int position) {

        holder.getParentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position, holder);
                }
            }
        });
    }


    /**
     * Item点击事件接口
     */
    public interface OnItemClickListener {

        void onItemClick(int position, ClickableViewHolder holder);
    }

    /**
     * Item长按事件接口
     */
    public interface OnItemLongClickListener {

        boolean onItemLongClick(int position, ClickableViewHolder holder);
    }

    public static class ClickableViewHolder extends RecyclerView.ViewHolder {

        private View parentView;


        public ClickableViewHolder(View itemView) {

            super(itemView);
            this.parentView = itemView;
        }


        public View getParentView() {

            return parentView;
        }


        @SuppressWarnings("unchecked")
        public <T extends View> T $(@IdRes int id) {

            return (T) parentView.findViewById(id);
        }
    }
}
