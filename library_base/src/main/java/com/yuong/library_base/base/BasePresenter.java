package com.yuong.library_base.base;

import javax.inject.Inject;

/**
 * author: OnexZgj .
 * date: 2018/4/2 .
 */

public class BasePresenter<T extends BaseContract.BaseView, M extends BaseModel> implements BaseContract.BasePresenter<T> {

    protected T mView;

    /**
     * 泛型注入每个继承BasePresenter的子Presenter中
     */
    @Inject
    protected M mModel;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
        if (mModel != null) {
            mModel.clearPool();
            mModel = null;
        }
    }

}