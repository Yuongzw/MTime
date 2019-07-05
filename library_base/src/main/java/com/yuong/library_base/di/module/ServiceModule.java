package com.yuong.library_base.di.module;

import android.app.Service;
import android.content.Context;

import com.yuong.library_base.di.scope.ContextLife;
import com.yuong.library_base.di.scope.PerService;

import dagger.Module;
import dagger.Provides;

/**
 * ServiceModule
 * Created yuong
 */
@Module
public class ServiceModule {
    private Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

    @Provides
    @PerService
    @ContextLife("Service")
    public Context ProvideServiceContext() {
        return mService;
    }
}
