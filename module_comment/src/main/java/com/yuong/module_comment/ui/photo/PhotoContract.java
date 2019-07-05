package com.yuong.module_comment.ui.photo;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface PhotoContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        /**
         * 获取影片剧照
         * @param movieId
         */
        void getImageAll(String movieId);

    }

    interface Model extends BaseContract.BaseModel {

        /**
         * 获取影片剧照
         * @param movieId
         */
        void getImageAll(String movieId, INetListener<Object, Throwable, Object> listener);

    }

}
