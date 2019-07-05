package com.yuong.library_base.di.module;

import android.content.Context;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.di.scope.ContextLife;
import com.yuong.library_base.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;


/**
 * ApplicationModule
 * Created yuong
 */
@Module
public class ApplicationModule {
    private BaseApplication mApplication;

    public ApplicationModule(BaseApplication application) {
        mApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
