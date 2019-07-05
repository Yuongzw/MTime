package com.yuong.library_base.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class MyMultiItemEntity<P, C> implements MultiItemEntity {
    public static final int TYPE_PARENT = 1;
    public static final int TYPE_CHILD = 2;

    /**
     * 分组对应的标题栏
     */
    private P mParent;
    /**
     * 分组里面的子项
     */
    private List<C> mChildList;
    private int itemType;

    /**
     * 分组展开还是收起
     */
    private boolean mExpand;

    @Override
    public int getItemType() {
        return itemType;
    }

    public P getmParent() {
        return mParent;
    }

    public void setmParent(P mParent) {
        this.mParent = mParent;
    }

    public List<C> getChildList() {
        return mChildList;
    }

    public void setmChildList(List<C> mChildList) {
        this.mChildList = mChildList;
    }

    public boolean isExpand() {
        return mExpand;
    }

    public void setExpand(boolean mExpand) {
        this.mExpand = mExpand;
    }
}
