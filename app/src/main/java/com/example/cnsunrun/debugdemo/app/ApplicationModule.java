package com.example.cnsunrun.debugdemo.app;

import android.content.Context;

import com.example.cnsunrun.debugdemo.DebugDemoApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {

        this.context = context;
    }

    @Provides
    @Singleton
    DebugDemoApp provideApplication() {

        return (DebugDemoApp) context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {

        return context;
    }
}
