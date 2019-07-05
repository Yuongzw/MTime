package com.yuong.module_comment.ui.photo;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.module_comment.ui.movie_detail.MovieDetailActivity;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class PhotoPresent extends BasePresenter<PhotoContract.View, PhotoModel> implements PhotoContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public PhotoPresent() {
    }

    @Override
    public void getImageAll(String movieId) {
        mModel.getImageAll(movieId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                ImageAllBean imageAllBean = (ImageAllBean) o;
                ((PhotoActivity)mView).setImageData(imageAllBean);
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
