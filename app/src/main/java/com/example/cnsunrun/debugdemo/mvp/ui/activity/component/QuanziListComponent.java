package com.example.cnsunrun.debugdemo.mvp.ui.activity.component;

import com.example.cnsunrun.debugdemo.app.ApplicationComponent;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.module.QuanziListModule;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.QuanziListFragment;
import com.example.cnsunrun.debugdemo.utils.ActivityScoped;

import dagger.Component;

/**
 * Created by cnsunrun on 2017/3/17.
 */
@ActivityScoped
@Component(modules = QuanziListModule.class, dependencies = ApplicationComponent.class)
public interface QuanziListComponent {

    void inject(QuanziListFragment quanziListFragment);
}
