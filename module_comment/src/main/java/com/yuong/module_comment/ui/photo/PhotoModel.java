package com.yuong.module_comment.ui.photo;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PhotoModel extends BaseModel implements PhotoContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public PhotoModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }

    @Override
    public void getImageAll(String movieId, final INetListener<Object, Throwable, Object> listener) {
        api.getImageAll(movieId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<ImageAllBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ImageAllBean imageAllBean) {
                        listener.success(imageAllBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
