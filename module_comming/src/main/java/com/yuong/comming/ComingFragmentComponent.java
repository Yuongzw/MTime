package com.yuong.comming;

import com.yuong.comming.ui.coming.ComingFragment;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.di.component.ApplicationComponent;
import com.yuong.library_base.di.component.FragmentComponent;
import com.yuong.library_base.di.module.FragmentModule;
import com.yuong.library_base.di.scope.PerFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface ComingFragmentComponent extends FragmentComponent {

    void inject(ComingFragment fragment);
}
