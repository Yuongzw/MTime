package com.yuong.ticketing.ui.ticket;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.TicketBean;
import com.yuong.library_base.retrofit.INetListener;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class TicketPresent extends BasePresenter<TicketContract.View, TicketModel> implements TicketContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public TicketPresent() {
    }

    @Override
    public void getTicketMovieData(int locationId) {
        mModel.getTicketMovieData(locationId,  new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                TicketBean ticketBean = (TicketBean) o;
                ((TicketFragment) mView).setTicketData(ticketBean);
            }

            @Override
            public void failed(Throwable throwable) {

            }

            @Override
            public void loading(Object o) {

            }
        });
    }
}
