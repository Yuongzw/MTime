package com.yuong.module_comment.ui.all_person;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface AllPersonsContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {


        /**
         * 获取影片演职员列表
         * @param movieId
         */
        void getMovieCreditsWithTypes(String movieId);

    }

    interface Model extends BaseContract.BaseModel {


        /**
         * 获取影片演职员列表
         * @param movieId
         */
        void getMovieCreditsWithTypes(String movieId, INetListener<Object, Throwable, Object> listener);

    }

}
