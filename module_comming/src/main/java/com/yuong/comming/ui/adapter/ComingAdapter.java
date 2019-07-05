package com.yuong.comming.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.comming.R;
import com.yuong.library_base.bean.ComingBean;

import java.util.List;

import javax.inject.Inject;

public class ComingAdapter extends BaseQuickAdapter<ComingBean.MoviecomingsBean, BaseViewHolder> {
    @Inject
    public ComingAdapter() {
        super(R.layout.movie_comings, null);
    }

    public ComingAdapter(int layoutResId, @Nullable List<ComingBean.MoviecomingsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ComingBean.MoviecomingsBean item) {
        helper
                .setText(R.id.tv_movie_title, item.getTitle())
                .setText(R.id.tv_movie_category, item.getType())
                .setText(R.id.tv_movie_directors, item.getDirector())
                .setText(R.id.tv_movie_casts, item.getActor1() + "、" + item.getActor2())
                .setText(R.id.tv_movie_releaseDate, item.getReleaseDate())
                .setText(R.id.tv_movie_num, item.getWantedCount() + "")
                .setText(R.id.tv_movie_area, item.getLocationName());
        Glide.with(mContext)
                .load(item.getImage())
                .into((ImageView) helper.getView(R.id.iv_movie_bg));

    }
}
