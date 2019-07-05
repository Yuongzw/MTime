package com.yuong.module_comment.ui.all_person;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.retrofit.INetListener;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class AllPersonsPresent extends BasePresenter<AllPersonsContract.View, AllPersonsModel> implements AllPersonsContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public AllPersonsPresent() {
    }


    @Override
    public void getMovieCreditsWithTypes(final String movieId) {
        mModel.getMovieCreditsWithTypes(movieId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                MovieCreditsWithTypeBean movieCreditsWithTypeBean = (MovieCreditsWithTypeBean) o;
                ((AllPersonActivity)mView).setMovieCreditsWithTypeBean(movieCreditsWithTypeBean);
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
