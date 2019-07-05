package com.yuong.library_base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yuong.library_base.base.BaseFragment;

import java.lang.ref.WeakReference;

public class ContainerActivity extends RxAppCompatActivity {
    public static final String FRAGMENT = "fragment";
    public static final String BUNDLE = "bundle";
    protected WeakReference<Fragment> mFragment;
    private ViewGroup mianLayout;

    public ContainerActivity() {
    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(32);
        super.onCreate(savedInstanceState);
        this.mianLayout = new LinearLayout(this);
        this.mianLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mianLayout.setId(View.generateViewId());
        this.setContentView(this.mianLayout);
        FragmentManager fm = this.getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(this.mianLayout.getId());
        if (fragment == null) {
            this.initFromIntent(this.getIntent());
        }

    }

    protected void initFromIntent(Intent data) {
        if (data == null) {
            throw new RuntimeException("you must provide a page info to display");
        } else {
            try {
                String fragmentName = data.getStringExtra("fragment");
                if (fragmentName == null || "".equals(fragmentName)) {
                    throw new IllegalArgumentException("can not find page fragmentName");
                }

                Class<?> fragmentClass = Class.forName(fragmentName);
                BaseFragment fragment = (BaseFragment)fragmentClass.newInstance();
                Bundle args = data.getBundleExtra("bundle");
                if (args != null) {
                    fragment.setArguments(args);
                }

                FragmentTransaction trans = this.getSupportFragmentManager().beginTransaction();
                trans.replace(this.mianLayout.getId(), fragment);
                trans.commitAllowingStateLoss();
                this.mFragment = new WeakReference(fragment);
            } catch (ClassNotFoundException var7) {
                var7.printStackTrace();
            } catch (InstantiationException var8) {
                var8.printStackTrace();
            } catch (IllegalAccessException var9) {
                var9.printStackTrace();
            }

        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(this.mianLayout.getId());
        if (fragment instanceof BaseFragment) {
            if (!((BaseFragment)fragment).isBackPressed()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }

    }
}