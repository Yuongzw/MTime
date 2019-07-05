package com.yuong.library_base.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.yuong.library_base.di.component.DaggerFragmentComponent;
import com.yuong.library_base.di.component.FragmentComponent;
import com.yuong.library_base.di.module.FragmentModule;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BaseContract.BasePresenter> extends Fragment implements BaseContract.BaseView {

    protected Context context;

    protected View mFragmentView;
    protected Unbinder unbinder;

    public boolean isUIVisible;
    public boolean isViewCreated;
    public boolean isFirstLoad;
    /**
     * 泛型注入每个继承BaseFragment的子Fragment中
     */
    @Nullable
    @Inject
    protected P mPresenter;
    protected FragmentComponent mFragmentComponent;
//    public M mFragmentComponent;


    /**
     * 该类呗系统创建的时候调用
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initFragmentComponent();
        context = getActivity();
        if (isRegisterEventBus()) {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
        initInjector();
        attachView();
    }

    protected FragmentComponent getFragmentyComponent() {
        return DaggerFragmentComponent
                .builder()
                .applicationComponent(((BaseApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    /**
     * 初始化FragmentComponent
     */
    private void initFragmentComponent() {
        mFragmentComponent =  DaggerFragmentComponent.builder()
                .applicationComponent(((BaseApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            initView();
        }
        unbinder = ButterKnife.bind(this, mFragmentView);
        return mFragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        if (!isFirstLoad) {
            loadData();
            lazyLoad();
            isFirstLoad = true;
        }
    }

    protected abstract boolean isRegisterEventBus();

    public abstract int getLayoutId();

    protected abstract void initInjector();

    public abstract void initView();

    protected abstract void loadData();

    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            loadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }

    /**
     * 贴上view
     */
    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 分离view
     */
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);
            }
        }
        context = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        detachView();
        mPresenter = null;
        mFragmentComponent = null;
        mFragmentView = null;
    }

    public boolean isBackPressed(){
        return false;
    }
}
