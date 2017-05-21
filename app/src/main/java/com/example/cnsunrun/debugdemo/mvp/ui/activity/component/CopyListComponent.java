package com.example.cnsunrun.debugdemo.mvp.ui.activity.component;

import com.example.cnsunrun.debugdemo.app.ApplicationComponent;
import com.example.cnsunrun.debugdemo.mvp.ui.activity.module.CopyListModule;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.CopyListFragment;
import com.example.cnsunrun.debugdemo.utils.ActivityScoped;

import dagger.Component;

/**
 * Created by cnsunrun on 2017/4/19.
 */
@ActivityScoped
@Component(modules = CopyListModule.class, dependencies = ApplicationComponent.class)
public interface CopyListComponent {

    void inject(CopyListFragment copyListFragment);
}
