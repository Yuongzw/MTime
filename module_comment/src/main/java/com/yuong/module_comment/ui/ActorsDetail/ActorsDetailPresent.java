package com.yuong.module_comment.ui.ActorsDetail;

import com.google.gson.Gson;
import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.module_comment.ui.all_person.AllPersonActivity;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class ActorsDetailPresent extends BasePresenter<ActorsDetailContract.View, ActorsDetailModel> implements ActorsDetailContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public ActorsDetailPresent() {
    }


    @Override
    public void getActorsDetail(String personId, String cityId) {
        mModel.getActorsDetail(personId, cityId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                ActorsDetailBean actorsDetailBean = (ActorsDetailBean) o;
                ((ActorsDetailActivity)mView).setActorsDetailBean(actorsDetailBean);
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
