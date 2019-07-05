package com.yuong.module_comment.ui.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.module_comment.ui.photo.PhotoFragment;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mfragmentList = new ArrayList<>();
    private List<ImageAllBean.ImageTypesBean> titles = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    /**
     * 标题数据列表
     *
     * @param datas
     */
    public void setTitles(List<ImageAllBean.ImageTypesBean> datas) {
        this.titles.clear();
        this.titles.addAll(datas);
    }

    public void setMfragmentList(List<BaseFragment> mfragmentList) {
        this.mfragmentList.clear();
        this.mfragmentList.addAll(mfragmentList);
        notifyDataSetChanged();
    }

    public List<ImageAllBean.ImageTypesBean> getTitles() {
        return titles;
    }

//    @Override
//    public Fragment getItem(int position) {
//        return new PhotoFragment();
//    }


    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = titles.get(position).getTypeName();
        if (title == null) {
            title = "";
        }
        return title;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
    }
}
