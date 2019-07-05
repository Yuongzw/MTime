package com.yuong.comming.ui.coming;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.library_base.widget.EmptyLayout;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface ComingContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        /**
         * 获取即将上映影片
         */
        void getComingData(String locationId);

        /**
         * 获取影片详情
         * @param locationId
         * @param movieId
         */
        void getMovieDetail(String locationId, String movieId);

    }

    interface Model extends BaseContract.BaseModel {

        /**
         * 获取即将上映影片
         */
        void getComingData(String locationId, INetListener<Object, Throwable, Object> listener);

        /**
         * 获取影片详情
         * @param locationId
         * @param movieId
         */
        void getMovieDetail(String locationId, String movieId, INetListener<Object, Throwable, Object> listener);

    }

}
