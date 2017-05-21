package com.example.cnsunrun.debugdemo.mvp.contract;

import com.example.cnsunrun.debugdemo.mvp.base.IBasePresenter;
import com.example.cnsunrun.debugdemo.mvp.base.IBaseView;
import com.example.cnsunrun.debugdemo.mvp.model.bean.CopyInfo;

import java.util.List;

/**
 * Created by cnsunrun on 2017/4/19.
 */

public interface CopyListContract {

    interface View extends IBaseView<Presenter> {
        void displayData(List<CopyInfo.ActivityoListBean> copyInfos);
    }

    interface Presenter extends IBasePresenter {
        void loadData();
    }

}
