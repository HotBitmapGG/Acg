package com.example.cnsunrun.debugdemo.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.example.cnsunrun.debugdemo.app.AppConstant;
import com.example.cnsunrun.debugdemo.app.ApplicationModule;
import com.example.cnsunrun.debugdemo.mvp.contract.CopyListContract;
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
 * Created by cnsunrun on 2017/4/19.
 */
@ActivityScoped
public class CopyListPresenter implements CopyListContract.Presenter {

    private CopyListContract.View view;

    private CompositeDisposable compositeDisposable;

    @Inject
    CopyListPresenter(Context context, CopyListContract.View view) {
        this.view = view;
        view.setPresenter(this);
        compositeDisposable = new CompositeDisposable();

        DaggerPresenterComponent.builder()
                .applicationModule(new ApplicationModule(context))
                .build().inject(this);
    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unSubscribe() {
        compositeDisposable.clear();
    }

    @Override
    public void loadData() {

        Disposable subscribe = RetrofitHelper.createCopyService()
                .getCopys(1, 1, "d89a68bddc0784e750f6f841eeb61647#")
                .delay(1000, TimeUnit.MILLISECONDS)
                .filter(copyInfoBaseResponseInfo -> copyInfoBaseResponseInfo.getCode().equals(AppConstant.SUCCESS_CODE))
                .map(copyInfoBaseResponseInfo -> copyInfoBaseResponseInfo.getBaseResult().getActivityoListBeans())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(activityoListBeen -> view.displayData(activityoListBeen),
                        throwable -> Log.e("tag", throwable.getMessage()));

        compositeDisposable.add(subscribe);
    }

    public void loadMoreData(int page) {
        Disposable subscribe = RetrofitHelper.createCopyService()
                .getCopys(page, 1, "d89a68bddc0784e750f6f841eeb61647#")
                .delay(1000, TimeUnit.MILLISECONDS)
                .filter(copyInfoBaseResponseInfo -> copyInfoBaseResponseInfo.getCode().equals(AppConstant.SUCCESS_CODE))
                .map(copyInfoBaseResponseInfo -> copyInfoBaseResponseInfo.getBaseResult().getActivityoListBeans())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(activityoListBeen -> view.displayData(activityoListBeen),
                        throwable -> Log.e("tag", throwable.getMessage()));

        compositeDisposable.add(subscribe);
    }

}
