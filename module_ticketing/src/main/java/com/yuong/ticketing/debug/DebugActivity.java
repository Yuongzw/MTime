package com.yuong.ticketing.debug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yuong.library_base.ContainerActivity;
import com.yuong.ticketing.ui.ticket.TicketFragment;


/**
 * 组件单独运行时的调试界面，不会被编译进release里
 * Created by goldze on 2018/6/21
 */

public class DebugActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra("fragment", TicketFragment.class.getCanonicalName());
        this.startActivity(intent);
        finish();
    }
}
