package com.yuong.hot.ui.hot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yuong.hot.DaggerHotFragmentComponent;
import com.yuong.hot.R;
import com.yuong.hot.R2;
import com.yuong.hot.ui.adapter.HotAdapter;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.di.module.FragmentModule;
import com.yuong.library_base.router.RouterFragmentPath;
import com.yuong.library_base.widget.EmptyLayout;
import com.yuong.module_comment.ui.movie_detail.MovieDetailActivity;

import javax.inject.Inject;

import butterknife.BindView;

@Route(path = RouterFragmentPath.Hot.PAGER_HOT)
public class HotFragment extends BaseFragment<HotPresent> implements HotContract.View {
    @BindView(R2.id.emptyLayout)
    EmptyLayout emptyLayout;
    @BindView(R2.id.rv_hot_movie)
    RecyclerView rvHotMovie;
    @BindView(R2.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @Inject
    HotAdapter adapter;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initInjector() {
        DaggerHotFragmentComponent.builder()
                .applicationComponent(((BaseApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initView() {

    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvHotMovie.setLayoutManager(linearLayoutManager);
        rvHotMovie.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rvHotMovie.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HotMovieBean.MsBean msBean = (HotMovieBean.MsBean) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra("movieId", msBean.getMovieId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        initRecyclerView();
        smartRefreshLayout.setEnableLoadMore(false);
        emptyLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
        assert mPresenter != null;
        mPresenter.getHotMovieData(368);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                emptyLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
                emptyLayout.setVisibility(View.VISIBLE);
                smartRefreshLayout.setVisibility(View.GONE);
                mPresenter.getHotMovieData(368);
            }
        });
    }

    public void setHotData(HotMovieBean hotMovieBean) {
        if (hotMovieBean.getMs() != null && hotMovieBean.getMs().size() > 0) {
            emptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            smartRefreshLayout.setVisibility(View.VISIBLE);
            smartRefreshLayout.finishRefresh();
            emptyLayout.setVisibility(View.GONE);
            if (adapter.getData().size() > 0) {
                adapter.getData().clear();
            }
            adapter.setNewData(hotMovieBean.getMs());
        } else {
            emptyLayout.setErrorType(EmptyLayout.NODATA);
        }
    }

}
