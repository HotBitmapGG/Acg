package com.example.cnsunrun.debugdemo.mvp.presenter.base;

import com.example.cnsunrun.debugdemo.app.ApplicationModule;
import com.example.cnsunrun.debugdemo.mvp.presenter.CopyListPresenter;
import com.example.cnsunrun.debugdemo.mvp.presenter.QuanziListPresenter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class})
public interface PresenterComponent {

    void inject(QuanziListPresenter presenter);

    void inject(CopyListPresenter presenter);

}
 