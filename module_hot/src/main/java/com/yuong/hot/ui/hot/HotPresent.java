package com.yuong.hot.ui.hot;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.ComingBean;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.INetListener;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class HotPresent extends BasePresenter<HotContract.View, HotModel> implements HotContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public HotPresent() {
    }

    @Override
    public void getHotMovieData(int locationId) {
        mModel.getHotMovieData(locationId,  new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                HotMovieBean hotMovieBean = (HotMovieBean) o;
                ((HotFragment) mView).setHotData(hotMovieBean);
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
