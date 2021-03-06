package com.udacity.animesh.baking;

import android.app.Application;
import android.content.Context;

import com.udacity.animesh.baking.di.AppComponent;
import com.udacity.animesh.baking.di.ContextModule;
import com.udacity.animesh.baking.di.DaggerAppComponent;

import timber.log.Timber;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }

    private AppComponent buildComponents() {
        return DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        appComponent = buildComponents();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
