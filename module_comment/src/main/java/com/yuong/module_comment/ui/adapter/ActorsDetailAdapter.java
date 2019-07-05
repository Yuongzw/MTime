package com.yuong.module_comment.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.comment.R;

import java.util.List;

import javax.inject.Inject;

public class ActorsDetailAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    @Inject
    public ActorsDetailAdapter() {
        super(R.layout.img_item, null);
    }

    public ActorsDetailAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        Glide.with(mContext)
                .load(item)
                .into((ImageView) helper.getView(R.id.iv_actor_img));

    }
}
