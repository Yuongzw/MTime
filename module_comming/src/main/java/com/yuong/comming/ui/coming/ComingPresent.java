package com.yuong.comming.ui.coming;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.ComingBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.INetListener;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class ComingPresent extends BasePresenter<ComingContract.View, ComingModel> implements ComingContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public ComingPresent() {
    }

    @Override
    public void getComingData(String locationId) {
        mModel.getComingData(locationId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                ComingBean comingBean = (ComingBean) o;
                ((ComingFragment) mView).setComingData(comingBean);
            }

            @Override
            public void failed(Throwable throwable) {

            }

            @Override
            public void loading(Object o) {

            }
        });
    }

    @Override
    public void getMovieDetail(String locationId, String movieId) {
        mModel.getMovieDetail(locationId, movieId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                MovieDetailBean movieDetailBean = (MovieDetailBean) o;
//                ((MovieDetailActivity) mView).setComingData(movieDetailBean);
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
