package com.example.cnsunrun.debugdemo.mvp.contract;

import com.example.cnsunrun.debugdemo.mvp.base.IBasePresenter;
import com.example.cnsunrun.debugdemo.mvp.base.IBaseView;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziInfo;

import java.util.List;

/**
 * Created by cnsunrun on 2017/3/17.
 */

public interface QuanziListContract {

    interface View extends IBaseView<Presenter> {
        void displayData(List<QuanziInfo.BlogListBean> quanziInfos);
    }

    interface Presenter extends IBasePresenter {
        void loadData();
    }
}
