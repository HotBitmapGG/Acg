package com.example.cnsunrun.debugdemo.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cnsunrun.debugdemo.DebugDemoApp;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.contract.CopyListContract;
import com.example.cnsunrun.debugdemo.mvp.model.bean.CopyInfo;
import com.example.cnsunrun.debugdemo.mvp.presenter.CopyListPresenter;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.CopyDetailsActivity;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.component.DaggerCopyListComponent;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.module.CopyListModule;
import com.example.cnsunrun.debugdemo.mvp.ui.adapter.CopyAdapter;
import com.github.nukc.LoadMoreWrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnsunrun on 2017/4/19.
 */

public class CopyListFragment extends Fragment implements CopyListContract.View {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    CopyListPresenter copyListPresenter;

    private List<CopyInfo.ActivityoListBean> datas = new ArrayList<>();
    private CopyAdapter mAdapter;
    private int page = 1;

    public static CopyListFragment newInstance() {
        return new CopyListFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerCopyListComponent.builder()
                .applicationComponent(DebugDemoApp.getAppContext().getApplicationComponent())
                .copyListModule(new CopyListModule(this))
                .build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_copy_list, container, false);
        ButterKnife.bind(this, view);
        initSwipeRefreshLayout();
        initRecyclerView();
        copyListPresenter.subscribe();
        return view;
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorControlNormal);
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            datas.clear();
            copyListPresenter.loadData();
        });
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new CopyAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {
            CopyInfo.ActivityoListBean activityoListBean = datas.get(position);
            Intent intent = new Intent(getActivity(), CopyDetailsActivity.class);
            intent.putExtra("activityId",activityoListBean.getActivityid());
            getActivity().startActivity(intent);
        });
        LoadMoreWrapper.with(mAdapter)
                .setFooterView(R.layout.layout_load_more)
                .setShowNoMoreEnabled(true)
                .setListener(enabled -> {
                    page++;
                    copyListPresenter.loadMoreData(page);
                }).into(mRecyclerView);
    }

    @Override
    public void setPresenter(CopyListContract.Presenter presenter) {
    }

    @Override
    public void displayData(List<CopyInfo.ActivityoListBean> copyInfos) {
        mSwipeRefreshLayout.setRefreshing(false);
        datas.addAll(copyInfos);
        mAdapter.setDataSources(datas);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        copyListPresenter.unSubscribe();
    }
}
