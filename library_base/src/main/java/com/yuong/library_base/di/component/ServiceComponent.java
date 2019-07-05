package com.yuong.library_base.di.component;

import android.content.Context;

import com.yuong.library_base.di.module.ServiceModule;
import com.yuong.library_base.di.scope.ContextLife;
import com.yuong.library_base.di.scope.PerService;

import dagger.Component;


/**
 * ServiceComponent 暂时没有用到
 * Created yuong
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
    @ContextLife("Service")
    Context getServiceContext();

    @ContextLife("Application")
    Context getApplicationContext();
}
