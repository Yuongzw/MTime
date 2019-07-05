package com.yuong.module_comment.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuong.comment.R;
import com.yuong.library_base.bean.DirctorActorBean;

import java.util.List;

import javax.inject.Inject;

public class DirectorActorAdapter extends BaseQuickAdapter<DirctorActorBean, BaseViewHolder> {

    @Inject
    public DirectorActorAdapter() {
        super(R.layout.rv_dir_act, null);
    }

    public DirectorActorAdapter(int layoutResId, @Nullable List<DirctorActorBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DirctorActorBean item) {
        helper
                .setText(R.id.tv_profession, item.getProfession())
                .setText(R.id.tv_zh_name, item.getName())
                .setText(R.id.tv_en_name, item.getNameEn());
        if (item.getRoleName().equals("")) {
            helper.setVisible(R.id.tv_play_name, false);
        } else {
            helper.setVisible(R.id.tv_play_name, true);
            helper.setText(R.id.tv_play_name, "饰:" + item.getRoleName());
        }
        if (helper.getPosition() > 1) {
            helper.setVisible(R.id.tv_profession, false);
        } else {
            helper.setVisible(R.id.tv_profession, true);
        }
        Glide.with(mContext)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_personal_photo));
    }
}
