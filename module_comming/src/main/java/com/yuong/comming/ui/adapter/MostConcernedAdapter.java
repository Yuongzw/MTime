package com.yuong.comming.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.comming.R;
import com.yuong.library_base.bean.ComingBean;

import java.util.List;

import javax.inject.Inject;

public class MostConcernedAdapter extends BaseQuickAdapter<ComingBean.AttentionBean, BaseViewHolder> {

    @Inject
    public MostConcernedAdapter() {
        super(R.layout.movie_most_concerned, null);
    }

    public MostConcernedAdapter(int layoutResId, @Nullable List<ComingBean.AttentionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ComingBean.AttentionBean item) {
        helper
                .setText(R.id.tv_movie_title, item.getTitle())
                .setText(R.id.tv_Release_Date, item.getReleaseDate() + "——————")
                .setText(R.id.tv_favorite, item.getWantedCount() + "人想看");
        Glide.with(mContext)
                .load(item.getImage())
                .into((ImageView) helper.getView(R.id.iv_movie_bg));
    }
}
