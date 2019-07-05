package com.yuong.module_comment.ui.ActorsDetail;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ActorsDetailModel extends BaseModel implements ActorsDetailContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public ActorsDetailModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }


    @Override
    public void getActorsDetail(String personId, String cityId, final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit retrofit = new MyRetrofit("https://ticket-api-m.mtime.cn/");
        retrofit.getApi()
                .getActorsDetail(personId, cityId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<ActorsDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ActorsDetailBean actorsDetailBean) {
                        listener.success(actorsDetailBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
