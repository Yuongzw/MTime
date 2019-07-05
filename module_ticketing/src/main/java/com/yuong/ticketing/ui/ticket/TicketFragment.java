package com.yuong.ticketing.ui.ticket;

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
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.TicketBean;
import com.yuong.library_base.di.module.FragmentModule;
import com.yuong.library_base.router.RouterFragmentPath;
import com.yuong.library_base.widget.EmptyLayout;
import com.yuong.module_comment.ui.movie_detail.MovieDetailActivity;
import com.yuong.ticketing.DaggerTicketFragmentComponent;
import com.yuong.ticketing.R;
import com.yuong.ticketing.R2;
import com.yuong.ticketing.ui.adapter.TicketAdapter;

import javax.inject.Inject;

import butterknife.BindView;

@Route(path = RouterFragmentPath.Ticket.PAGER_TICKET)
public class TicketFragment extends BaseFragment<TicketPresent> implements TicketContract.View {

    @BindView(R2.id.emptyLayout)
    EmptyLayout emptyLayout;
    @BindView(R2.id.rv_ticket_movie)
    RecyclerView rvTicketMovie;
    @BindView(R2.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @Inject
    TicketAdapter adapter;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ticket;
    }

    @Override
    protected void initInjector() {
        DaggerTicketFragmentComponent.builder()
                .applicationComponent(((BaseApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    protected void loadData() {
        initRecyclerView();
        smartRefreshLayout.setEnableLoadMore(false);
        emptyLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
        assert mPresenter != null;
        mPresenter.getTicketMovieData(368);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                emptyLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
                emptyLayout.setVisibility(View.VISIBLE);
                smartRefreshLayout.setVisibility(View.GONE);
                mPresenter.getTicketMovieData(368);
            }
        });
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvTicketMovie.setLayoutManager(linearLayoutManager);
        rvTicketMovie.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rvTicketMovie.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TicketBean.MoviesBean moviesBean = (TicketBean.MoviesBean) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra("movieId", moviesBean.getMovieId());
                startActivity(intent);
            }
        });
    }

    public void setTicketData(TicketBean ticketBean) {
        if (ticketBean.getMovies() != null && ticketBean.getMovies().size() > 0) {
            emptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            smartRefreshLayout.setVisibility(View.VISIBLE);
            smartRefreshLayout.finishRefresh();
            emptyLayout.setVisibility(View.GONE);
            if (adapter.getData().size() > 0) {
                adapter.getData().clear();
            }
            adapter.setNewData(ticketBean.getMovies());
        } else {
            emptyLayout.setErrorType(EmptyLayout.NODATA);
        }
    }

}
