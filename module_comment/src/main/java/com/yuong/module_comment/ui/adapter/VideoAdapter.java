package com.yuong.module_comment.ui.adapter;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.comment.R;
import com.yuong.library_base.bean.VideoBean;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class VideoAdapter extends BaseQuickAdapter<VideoBean.VideoListBean, BaseViewHolder> {

    @Inject
    public VideoAdapter() {
        super(R.layout.video_item, null);
    }

    public VideoAdapter(int layoutResId, @Nullable List<VideoBean.VideoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBean.VideoListBean item) {
        JzvdStd jzvdStd = helper.getView(R.id.video_player);
        jzvdStd.setUp(
                item.getUrl(),
                item.getTitle(), "", Jzvd.SCREEN_WINDOW_LIST);
        helper.setText(R.id.tv_video_title, item.getTitle());
        Glide.with(mContext)
                .load(item.getImage())
                .into(jzvdStd.thumbImageView);
    }

}
