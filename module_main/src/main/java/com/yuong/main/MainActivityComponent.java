package com.yuong.main;

import android.app.Activity;
import android.content.Context;

import com.yuong.library_base.di.component.ActivityComponent;
import com.yuong.library_base.di.component.ApplicationComponent;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.library_base.di.scope.ContextLife;
import com.yuong.library_base.di.scope.PerActivity;

import dagger.Component;

/**
 * ActivityComponent
 * @author yuong
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface MainActivityComponent extends ActivityComponent {

    @Override
    @ContextLife("Activity")
    Context getActivityContext();

    @Override
    @ContextLife("Application")
    Context getApplicationContext();

    @Override
    Activity getActivity();

}
