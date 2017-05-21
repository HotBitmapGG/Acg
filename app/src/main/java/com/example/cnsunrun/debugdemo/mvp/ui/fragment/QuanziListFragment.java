package com.example.cnsunrun.debugdemo.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cnsunrun.debugdemo.DebugDemoApp;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.contract.QuanziListContract;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziInfo;
import com.example.cnsunrun.debugdemo.mvp.presenter.QuanziListPresenter;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.QuanziDetailsActivity;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.component.DaggerQuanziListComponent;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.module.QuanziListModule;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.QuanziAdapter;
import com.github.nukc.LoadMoreWrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnsunrun on 2017/4/18.
 */

public class QuanziListFragment extends Fragment implements QuanziListContract.View {


    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    QuanziListPresenter quanziListPresenter;

    private QuanziAdapter mAdapter;
    private List<QuanziInfo.BlogListBean> blogList = new ArrayList<>();

    public static QuanziListFragment newInstance() {
        return new QuanziListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerQuanziListComponent.builder()
                .applicationComponent(DebugDemoApp.getAppContext().getApplicationComponent())
                .quanziListModule(new QuanziListModule(this))
                .build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quanzi_list, container, false);
        ButterKnife.bind(this, view);
        initSwipeRefreshLayout();
        initRecyclerView();
        quanziListPresenter.subscribe();
        return view;
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorControlNormal);
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            blogList.clear();
            quanziListPresenter.loadData();
        });
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new QuanziAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {
            Intent intent = new Intent(getActivity(), QuanziDetailsActivity.class);
            intent.putExtra("id", blogList.get(position).getBlog_id());
            intent.putExtra("title",blogList.get(position).getContent());
            getActivity().startActivity(intent);
        });
        LoadMoreWrapper.with(mAdapter)
                .setFooterView(R.layout.layout_load_more)
                .setLoadMoreEnabled(true)
                .setListener(enabled -> {
                    long lastId = -1;
                    long hotLastId = -1;
                    int size = blogList.size();
                    if (size >= 2) {
                        lastId = Long.valueOf(blogList.get(blogList.size() - 2).getBlog_id());
                        hotLastId = Long.valueOf(blogList.get(blogList.size() - 1).getBlog_id());
                        quanziListPresenter.loadMoreData(lastId, hotLastId);
                    }
                })
                .into(mRecyclerView);
    }

    @Override
    public void setPresenter(QuanziListContract.Presenter presenter) {
    }


    @Override
    public void displayData(List<QuanziInfo.BlogListBean> quanziInfos) {
        mSwipeRefreshLayout.setRefreshing(false);
        blogList.addAll(quanziInfos);
        mAdapter.setDataSources(blogList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        quanziListPresenter.unSubscribe();
    }
}
