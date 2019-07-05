package com.yuong.ticketing;

import com.yuong.library_base.di.component.ApplicationComponent;
import com.yuong.library_base.di.component.FragmentComponent;
import com.yuong.library_base.di.module.FragmentModule;
import com.yuong.library_base.di.scope.PerFragment;
import com.yuong.ticketing.ui.ticket.TicketFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface TicketFragmentComponent extends FragmentComponent {

    void inject(TicketFragment hotFragment);
}
