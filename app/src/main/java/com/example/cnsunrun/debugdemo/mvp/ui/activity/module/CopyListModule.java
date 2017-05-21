package com.example.cnsunrun.debugdemo.mvp.ui.activity.module;

import com.example.cnsunrun.debugdemo.mvp.contract.CopyListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cnsunrun on 2017/4/19.
 */
@Module
public class CopyListModule {

    private CopyListContract.View view;

    public CopyListModule(CopyListContract.View view) {
        this.view = view;
    }

    @Provides
    CopyListContract.View provideCopyListContractView() {
        return view;
    }
}
