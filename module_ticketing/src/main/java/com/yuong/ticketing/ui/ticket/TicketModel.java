package com.yuong.ticketing.ui.ticket;


import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseModel;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.TicketBean;
import com.yuong.library_base.retrofit.GetData;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.retrofit.MyRetrofit;
import com.yuong.library_base.retrofit.PRSubscriber;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TicketModel extends BaseModel implements TicketContract.Model {

    private GetData api;

    /**
     * 注入到Presenter
     */
    @Inject
    public TicketModel() {
        api = MyRetrofit.getInstance(BaseApplication.getInstance()).getApi();
    }


    @Override
    public void getTicketMovieData(int locationId, final INetListener<Object, Throwable, Object> listener) {
        api.getTicketData(locationId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PRSubscriber<TicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(TicketBean ticketBean) {
                        listener.success(ticketBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        clearPool();
                    }

                });
    }
}
