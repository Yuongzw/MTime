package com.yuong.module_comment.ui.photo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.module_comment.ui.DaggerMovieDetailActivityComponent;
import com.yuong.module_comment.ui.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoActivity extends BaseActivity<PhotoPresent> implements PhotoContract.View{
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R2.id.id_vp)
    ViewPager idVp;

    private MyPagerAdapter mAdapter;
    private ImageAllBean imageAllBean;
    private int type = -1;
    private boolean isLoad;

    @Override
    public int inflateContentView() {
        return R.layout.activity_photo;
    }

    @Override
    protected void initInjector() {
        DaggerMovieDetailActivityComponent.builder()
                .applicationComponent(((BaseApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        tvTitle.setText(getIntent().getStringExtra("title"));
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        idVp.setAdapter(mAdapter);
        idVp.setCurrentItem(0);
        tabLayout.setupWithViewPager(idVp);
        initListener();
        assert mPresenter != null;
        mPresenter.getImageAll(getIntent().getIntExtra("movieId", 0) + "");
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String title = (String) tab.getText();
                for (int i = 0; i < mAdapter.getTitles().size(); i++) {
                    assert title != null;
                    if (title.equals(mAdapter.getTitles().get(i).getTypeName())) {
                        type = mAdapter.getTitles().get(i).getType();
                    }
                }
                if (isLoad) {
                    ((PhotoFragment) mAdapter.getItem(tab.getPosition())).setType(type);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected boolean isNeedInject() {
        return false;
    }

    public ImageAllBean getImageAllBean() {
        return imageAllBean;
    }

    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    public void setImageData(ImageAllBean imageAllBean) {
        isLoad = true;
        this.imageAllBean = imageAllBean;
        if (imageAllBean.getImageTypes() != null && imageAllBean.getImageTypes().size() > 0) {
            if (imageAllBean.getImageTypes().size() > 4) {
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            } else {
                tabLayout.setTabMode(TabLayout.MODE_FIXED);
            }
            mAdapter.setTitles(imageAllBean.getImageTypes());
            List<BaseFragment> fragments = new ArrayList<>();
            for (int i = 0; i < imageAllBean.getImageTypes().size(); i++) {
                PhotoFragment photoFragment = new PhotoFragment();
                fragments.add(photoFragment);

            }
            mAdapter.setMfragmentList(fragments);
            ((PhotoFragment)mAdapter.getItem(tabLayout.getSelectedTabPosition())).setType(mAdapter.getTitles().get(tabLayout.getSelectedTabPosition()).getType());

//            for (int i = 0; i < mAdapter.getTitles().size(); i++) {
//                if (i == 0) {
//                    type = -1;
//                    ((PhotoFragment) mAdapter.getItem(i)).setImagesBeans(imageAllBean.getImages());
//                } else {
//                    type = mAdapter.getTitles().get(i).getType();
//                    List<ImageAllBean.ImagesBean> images = new ArrayList<>();
//                    for (int j = 0; j < imageAllBean.getImages().size(); j++) {
//                        if (imageAllBean.getImages().get(j).getType() == type) {
//                            images.add(imageAllBean.getImages().get(j));
//                        }
//                    }
//                    ((PhotoFragment) mAdapter.getItem(i)).setImagesBeans(images);
//                }
//            }
        }
    }
}
