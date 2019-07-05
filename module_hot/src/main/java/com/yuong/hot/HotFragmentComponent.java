package com.yuong.hot;

import com.yuong.hot.ui.hot.HotFragment;
import com.yuong.library_base.di.component.ApplicationComponent;
import com.yuong.library_base.di.component.FragmentComponent;
import com.yuong.library_base.di.module.FragmentModule;
import com.yuong.library_base.di.scope.PerFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface HotFragmentComponent extends FragmentComponent {

    void inject(HotFragment hotFragment);
}
