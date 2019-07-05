package com.yuong.module_comment.ui.video;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface VideoContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        /**
         * 获取影片视频
         * @param movieId
         */
        void getVideo(int pageIndex, int movieId);

    }

    interface Model extends BaseContract.BaseModel {

        /**
         * 获取影片视频
         * @param movieId
         */
        void getVideo(int pageIndex, int movieId, INetListener<Object, Throwable, Object> listener);

    }

}
