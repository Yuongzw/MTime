package com.yuong.library_base.di.component;

import android.content.Context;


import com.yuong.library_base.di.module.ApplicationModule;
import com.yuong.library_base.di.scope.ContextLife;
import com.yuong.library_base.di.scope.PerApp;

import dagger.Component;


/**
 *ApplicationComponent
 * @author yuong
 * @date 2017/1/19
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}