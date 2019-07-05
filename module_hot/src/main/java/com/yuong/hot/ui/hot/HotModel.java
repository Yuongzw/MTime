package com.yuong.hot.ui.hot;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.ComingBean;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotModel extends BaseModel implements HotContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public HotModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }


    @Override
    public void getHotMovieData(int locationId, final INetListener<Object, Throwable, Object> listener) {
        api.getHotMovieData(locationId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<HotMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(HotMovieBean hotMovieBean) {
                        listener.success(hotMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
