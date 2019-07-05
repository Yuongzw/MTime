package com.yuong.module_comment.ui.ActorsDetail;

import com.yuong.library_base.base.BaseContract;
import com.yuong.library_base.retrofit.INetListener;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface ActorsDetailContract {


    interface View extends BaseContract.BaseView {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        /**
         * 获取演员详细资料
         */
        void getActorsDetail(String personId, String cityId);

    }

    interface Model extends BaseContract.BaseModel {

        /**
         * 获取演员详细资料
         */
        void getActorsDetail(String personId, String cityId, INetListener<Object, Throwable, Object> listener);

    }

}
