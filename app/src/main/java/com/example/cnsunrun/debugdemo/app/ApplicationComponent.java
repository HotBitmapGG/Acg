package com.example.cnsunrun.debugdemo.app;

import android.content.Context;

import com.example.cnsunrun.debugdemo.DebugDemoApp;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    DebugDemoApp getApplication();

    Context getContext();
}
