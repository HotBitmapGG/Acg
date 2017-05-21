package com.example.cnsunrun.debugdemo;

import android.app.Application;
import android.os.StrictMode;

import com.example.cnsunrun.debugdemo.app.ApplicationComponent;
import com.example.cnsunrun.debugdemo.app.ApplicationModule;
import com.example.cnsunrun.debugdemo.app.DaggerApplicationComponent;

/**
 * Created by cnsunrun on 2017/3/15.
 */

public class DebugDemoApp extends Application {

    private static DebugDemoApp mAppContext;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
        init();
    }

    private void init() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static DebugDemoApp getAppContext() {
        return mAppContext;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
