package com.yuong.module_comment.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.comment.R;
import com.yuong.library_base.bean.ActorsDetailBean;

import java.util.List;

import javax.inject.Inject;

public class ActorExperienceAdapter extends BaseQuickAdapter<ActorsDetailBean.DataBean.BackgroundBean.ExpriencesBean, BaseViewHolder> {
    @Inject
    public ActorExperienceAdapter() {
        super(R.layout.experience_item, null);
    }

    public ActorExperienceAdapter(int layoutResId, @Nullable List<ActorsDetailBean.DataBean.BackgroundBean.ExpriencesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ActorsDetailBean.DataBean.BackgroundBean.ExpriencesBean item) {
        helper.setText(R.id.tv_year, item.getYear() + "")
                .setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, "        " + item.getContent());
        Glide.with(mContext)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_img));
    }
}
