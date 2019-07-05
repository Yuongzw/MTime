package com.yuong.comming.dagger;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.yuong.library_base.di.scope.ContextLife;
import com.yuong.library_base.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * FragmentModule
 * Created yuong
 */
@Module
public class FragmentModule extends com.yuong.library_base.di.module.FragmentModule {

    public FragmentModule(Fragment fragment) {
        super(fragment);
    }
}
