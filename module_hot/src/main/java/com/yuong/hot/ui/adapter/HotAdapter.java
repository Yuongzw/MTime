package com.yuong.hot.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.hot.R;
import com.yuong.library_base.bean.HotMovieBean;

import java.util.List;

import javax.inject.Inject;

public class HotAdapter extends BaseQuickAdapter<HotMovieBean.MsBean, BaseViewHolder> {

    @Inject
    public HotAdapter() {
        super(R.layout.hot_item, null);
    }

    public HotAdapter(int layoutResId, @Nullable List<HotMovieBean.MsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotMovieBean.MsBean item) {
        helper.setText(R.id.tv_movie_title, item.getTCn())
                .setText(R.id.tv_commonSpecial, item.getCommonSpecial())
                .setText(R.id.tv_actors, item.getActors())
                .setText(R.id.tv_score, item.getR() + "");
        Glide.with(mContext)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_movie_img));
        if (item.getR() < 0) {
            helper.setGone(R.id.tv_score, false);
            helper.setGone(R.id.tv_fen, false);
        } else {
            helper.setGone(R.id.tv_score, true);
            helper.setGone(R.id.tv_fen, true);
        }
    }
}
