package com.example.cnsunrun.debugdemo.mvp.ui.activity.module;

import com.example.cnsunrun.debugdemo.mvp.contract.QuanziListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cnsunrun on 2017/3/17.
 */
@Module
public class QuanziListModule {

    private QuanziListContract.View view;

    public QuanziListModule(QuanziListContract.View view) {
        this.view = view;
    }

    @Provides
    QuanziListContract.View provideQuanziListContractView() {
        return view;
    }
}
