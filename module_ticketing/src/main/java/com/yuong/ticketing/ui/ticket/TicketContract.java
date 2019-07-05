package com.yuong.ticketing.ui.ticket;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface TicketContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        /**
         * 获取正在售票影片
         */
        void getTicketMovieData(int locationId);


    }

    interface Model extends BaseContract.BaseModel {

        /**
         * 获取正在售票影片
         */
        void getTicketMovieData(int locationId, INetListener<Object, Throwable, Object> listener);


    }

}
