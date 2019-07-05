package com.yuong.ticketing.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.TicketBean;
import com.yuong.ticketing.R;

import java.util.List;

import javax.inject.Inject;

public class TicketAdapter extends BaseQuickAdapter<TicketBean.MoviesBean, BaseViewHolder> {

    @Inject
    public TicketAdapter() {
        super(R.layout.ticket_item, null);
    }

    public TicketAdapter(int layoutResId, @Nullable List<TicketBean.MoviesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TicketBean.MoviesBean item) {
        helper.setText(R.id.tv_movie_title, item.getTitleCn())
                .setText(R.id.tv_commonSpecial, item.getCommonSpecial())
                .setText(R.id.tv_actors, item.getActorName1() + "、" + item.getActorName2())
                .setText(R.id.tv_score, item.getRatingFinal() + "");
        Glide.with(mContext)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_movie_img));
        if (item.getRatingFinal() < 0) {
            helper.setGone(R.id.tv_score, false);
            helper.setGone(R.id.tv_fen, false);
        } else {
            helper.setGone(R.id.tv_score, true);
            helper.setGone(R.id.tv_fen, true);
        }
    }
}
