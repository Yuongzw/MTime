package com.yuong.module_comment.ui.movie_detail;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.INetListener;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class MovieDetailPresent extends BasePresenter<MovieDetailContract.View, MovieDetailModel> implements MovieDetailContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public MovieDetailPresent() {
    }

    @Override
    public void getMovieDetail(String locationId, String movieId) {
        mModel.getMovieDetail(locationId, movieId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                MovieDetailBean movieDetailBean = (MovieDetailBean) o;
                ((MovieDetailActivity) mView).setComingData(movieDetailBean);
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
