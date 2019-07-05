package com.yuong.module_comment.ui.photo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.bean.ImageAllBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends BaseActivity {
    @BindView(R2.id.vp_image)
    ViewPager vpImage;
    @BindView(R2.id.tv_position)
    TextView tv_position;

    private MyViewPagerAdapter adapter;

    @Override
    public int inflateContentView() {
        return R.layout.activity_image;
    }

    @Override
    protected void initData() {
        adapter = new MyViewPagerAdapter((List<ImageAllBean.ImagesBean>) getIntent().getSerializableExtra("imagesBeans"));
        tv_position.setText((getIntent().getIntExtra("position", 0) + 1) + "/" + adapter.getCount());
        vpImage.setAdapter(adapter);
        vpImage.setCurrentItem(getIntent().getIntExtra("position", 0));
        vpImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_position.setText((position + 1) + "/" + adapter.getCount());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

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

    class MyViewPagerAdapter extends PagerAdapter {
        private List<ImageAllBean.ImagesBean> mData;

        public MyViewPagerAdapter(List<ImageAllBean.ImagesBean> mData) {
            this.mData = mData;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(mContext, R.layout.image_item, null);
            ImageView iv_Image = view.findViewById(R.id.iv_Image);
            Glide.with(mContext)
                    .load(mData.get(position).getImage())
                    .into(iv_Image);
            container.addView(view);
            return view;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container,position,object); 这一句要删除，否则报错
//            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

}
