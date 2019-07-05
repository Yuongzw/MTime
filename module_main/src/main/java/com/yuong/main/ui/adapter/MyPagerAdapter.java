package com.yuong.main.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.yuong.library_base.base.BaseFragment;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mfragmentList;

    public MyPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.mfragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
    }
}
