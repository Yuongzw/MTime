package com.yuong.module_comment.ui.movie_detail;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailModel extends BaseModel implements MovieDetailContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public MovieDetailModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }


    @Override
    public void getMovieDetail(String locationId, String movieId, final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit retrofit = new MyRetrofit("https://ticket-api-m.mtime.cn/");
        retrofit.getApi().getMovieDetailData(locationId, movieId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<MovieDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(MovieDetailBean movieDetailBean) {
                        listener.success(movieDetailBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
