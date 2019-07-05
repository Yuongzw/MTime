package com.yuong.hot.ui.hot;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface HotContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        /**
         * 获取正在上映影片
         */
        void getHotMovieData(int locationId);


    }

    interface Model extends BaseContract.BaseModel {

        /**
         * 获取正在上映影片
         */
        void getHotMovieData(int locationId, INetListener<Object, Throwable, Object> listener);


    }

}
