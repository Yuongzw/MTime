package com.yuong.module_comment.ui.all_person;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AllPersonsModel extends BaseModel implements AllPersonsContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public AllPersonsModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }


    @Override
    public void getMovieCreditsWithTypes(String movieId, final INetListener<Object, Throwable, Object> listener) {
        api.getMovieCreditsWithTypes(movieId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<MovieCreditsWithTypeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(MovieCreditsWithTypeBean movieCreditsWithTypeBean) {
                        listener.success(movieCreditsWithTypeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
