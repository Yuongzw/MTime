package com.yuong.library_base.retrofit;

import com.blankj.utilcode.util.ToastUtils;
import com.yuong.library_base.exception.ApiExceptionFactory;
import com.yuong.library_base.widget.EmptyLayout;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PRSubscriber<T> implements Observer<T> {
    private EmptyLayout emptyLayout;

    protected PRSubscriber() {
        this(null);
    }

    protected PRSubscriber(Object view) {
        if (view instanceof EmptyLayout) {
            this.emptyLayout = (EmptyLayout) view;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if (emptyLayout != null) {
            emptyLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
        }
        ToastUtils.showShort(ApiExceptionFactory.getApiException(e).getDisplayMessage());
    }

    @Override
    public void onComplete() {
        if (emptyLayout != null) {
            emptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
        }
    }
}
