package com.yuong.module_comment.ui.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.bean.VideoBean;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.library_base.widget.PinnedHeaderItemDecoration;
import com.yuong.module_comment.ui.DaggerMovieDetailActivityComponent;
import com.yuong.module_comment.ui.adapter.VideoAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.Jzvd;

public class VideoActivity extends BaseActivity<VideoPresent> implements VideoContract.View {


    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.rv_video)
    RecyclerView rvVideo;
    @BindView(R2.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @Inject
    VideoAdapter adapter;

    private int pageIndex = 1;
    private int movieId;
    private boolean isRefresh;

    @Override
    public int inflateContentView() {
        return R.layout.activity_video;
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
        initRecycerView();
        smartRefreshLayout.autoRefresh();
        initListener();
        movieId = getIntent().getIntExtra("movieId", 0);

    }

    private void initListener() {
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                isRefresh = true;
                pageIndex = 1;
                assert mPresenter != null;
                mPresenter.getVideo(pageIndex, movieId);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                isRefresh = false;
                assert mPresenter != null;
                mPresenter.getVideo(++pageIndex, movieId);
            }
        });
    }

    private void initRecycerView() {
        rvVideo.setLayoutManager(new LinearLayoutManager(mContext));
        rvVideo.addItemDecoration(new PinnedHeaderItemDecoration());
        rvVideo.setAdapter(adapter);
    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected boolean isNeedInject() {
        return false;
    }


    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    public void setVideoData(VideoBean videoBean) {
        if (isRefresh) {
            smartRefreshLayout.finishRefresh();
        } else {
            smartRefreshLayout.finishLoadMore();
        }
        if (videoBean.getVideoList() != null && videoBean.getVideoList().size() > 0) {
            adapter.setNewData(videoBean.getVideoList());
        } else {
            smartRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Jzvd.releaseAllVideos();

    }

}
