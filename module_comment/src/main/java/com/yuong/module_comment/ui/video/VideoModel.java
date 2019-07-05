package com.yuong.module_comment.ui.video;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.library_base.bean.VideoBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoModel extends BaseModel implements VideoContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public VideoModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }

    @Override
    public void getVideo(int pageIndex, int movieId, final INetListener<Object, Throwable, Object> listener) {
        api.getVideo(pageIndex, movieId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(VideoBean videoBean) {
                        listener.success(videoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
