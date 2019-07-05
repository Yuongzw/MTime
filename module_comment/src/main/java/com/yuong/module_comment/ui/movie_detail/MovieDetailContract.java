package com.yuong.module_comment.ui.movie_detail;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface MovieDetailContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {


        /**
         * 获取影片详情
         * @param locationId
         * @param movieId
         */
        void getMovieDetail(String locationId, String movieId);

    }

    interface Model extends BaseContract.BaseModel {


        /**
         * 获取影片详情
         * @param locationId
         * @param movieId
         */
        void getMovieDetail(String locationId, String movieId, INetListener<Object, Throwable, Object> listener);

    }

}
