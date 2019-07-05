package com.yuong.module_comment.ui.video;

import com.yuong.library_base.base.BasePresenter;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.library_base.bean.VideoBean;
import com.yuong.library_base.retrofit.INetListener;
import com.yuong.module_comment.ui.photo.PhotoActivity;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class VideoPresent extends BasePresenter<VideoContract.View, VideoModel> implements VideoContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public VideoPresent() {
    }

    @Override
    public void getVideo(int pageIndex, int movieId) {
        mModel.getVideo(pageIndex, movieId, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                VideoBean videoBean = (VideoBean) o;
                ((VideoActivity)mView).setVideoData(videoBean);
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
