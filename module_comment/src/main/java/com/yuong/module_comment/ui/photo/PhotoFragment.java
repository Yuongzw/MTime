package com.yuong.module_comment.ui.photo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.module_comment.ui.adapter.GridViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PhotoFragment extends BaseFragment {
    @BindView(R2.id.gridView)
    GridView gridview;

    private GridViewAdapter adapter;
    private int type = -1;
    private List<ImageAllBean.ImagesBean> imagesBeans = new ArrayList<>();


    public void setType(int type) {
        this.type = type;
        getImages(type);
    }

    private void getImages(int type) {
        if (context == null) {
            return;
        }
        ImageAllBean imageAllBean = ((PhotoActivity)context).getImageAllBean();
        imagesBeans.clear();
        if (this.type == -1) {
            imagesBeans.addAll(imageAllBean.getImages());
        } else {
            for (int j = 0; j < imageAllBean.getImages().size(); j++) {
                if (imageAllBean.getImages().get(j).getType() == type) {
                    imagesBeans.add(imageAllBean.getImages().get(j));
                }
            }
        }
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photo;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView() {

    }

    @Override
    protected void loadData() {
        adapter = new GridViewAdapter(imagesBeans, context);
        gridview.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("imagesBeans", (Serializable) imagesBeans);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        getImages(type);
    }

}
