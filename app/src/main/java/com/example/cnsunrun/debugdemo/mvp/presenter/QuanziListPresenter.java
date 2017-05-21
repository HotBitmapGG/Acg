package com.example.cnsunrun.debugdemo.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.example.cnsunrun.debugdemo.app.AppConstant;
import com.example.cnsunrun.debugdemo.app.ApplicationModule;
import com.example.cnsunrun.debugdemo.mvp.contract.QuanziListContract;
import com.example.cnsunrun.debugdemo.mvp.model.network.RetrofitHelper;
import com.example.cnsunrun.debugdemo.mvp.presenter.base.DaggerPresenterComponent;
import com.example.cnsunrun.debugdemo.utils.ActivityScoped;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cnsunrun on 2017/3/17.
 */
@ActivityScoped
public class QuanziListPresenter implements QuanziListContract.Presenter {

    private QuanziListContract.View view;

    private CompositeDisposable subscription;

    @Inject
    QuanziListPresenter(Context context, QuanziListContract.View view) {
        this.view = view;
        view.setPresenter(this);
        subscription = new CompositeDisposable();

        DaggerPresenterComponent.builder()
                .applicationModule(new ApplicationModule(context))
                .build().inject(this);
    }

    @Override
    public void subscribe() {
        Log.e("tag","加载数据  subscribe");
        loadData();
    }

    @Override
    public void unSubscribe() {
        subscription.clear();
    }

    @Override
    public void loadData() {
        Log.e("tag","加载数据  loadData");
        Disposable subscribe = RetrofitHelper.createQuanziService()
                .getQuanziInfos(-1, -1, -1, 1, -1, 1111, "dbe5b18fe665dbc25d22cdeb2d5cc436#")
                .delay(1000, TimeUnit.MILLISECONDS)
                .filter(quanziInfoBaseResponseInfo -> quanziInfoBaseResponseInfo.getCode().equals(AppConstant.SUCCESS_CODE))
                .map(quanziInfoBaseResponseInfo -> quanziInfoBaseResponseInfo.getBaseResult().getBlogList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(blogListBeen -> view.displayData(blogListBeen),
                        throwable -> Log.e("tag", throwable.getMessage()));

        subscription.add(subscribe);
    }

    public void loadMoreData(long lastId, long hotLastId) {
        Log.e("tag","加载数据  loadMoreData");
        Disposable subscribe = RetrofitHelper.createQuanziService()
                .getQuanziInfos(lastId, -1, hotLastId, 1, -1, 1111, "dbe5b18fe665dbc25d22cdeb2d5cc436#")
                .delay(1000, TimeUnit.MILLISECONDS)
                .filter(quanziInfoBaseResponseInfo -> quanziInfoBaseResponseInfo.getCode().equals(AppConstant.SUCCESS_CODE))
                .map(quanziInfoBaseResponseInfo -> quanziInfoBaseResponseInfo.getBaseResult().getBlogList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(blogListBeen -> view.displayData(blogListBeen),
                        throwable -> Log.e("tag", throwable.getMessage()));

        subscription.add(subscribe);

    }

}
