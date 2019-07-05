package com.yuong.comming.ui.coming;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yuong.comming.DaggerComingFragmentComponent;
import com.yuong.comming.R;
import com.yuong.comming.R2;
import com.yuong.comming.dagger.FragmentModule;
import com.yuong.comming.ui.adapter.ComingAdapter;
import com.yuong.comming.ui.adapter.MostConcernedAdapter;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.bean.ComingBean;
import com.yuong.library_base.router.RouterFragmentPath;
import com.yuong.library_base.widget.EmptyLayout;
import com.yuong.module_comment.ui.movie_detail.MovieDetailActivity;

import javax.inject.Inject;

import butterknife.BindView;

@Route(path = RouterFragmentPath.Coming.PAGER_COMING)
public class ComingFragment extends BaseFragment<ComingPresent> implements ComingContract.View {

    @BindView(R2.id.coming_EmptyLayout)
    EmptyLayout comingEmptyLayout;
    @BindView(R2.id.coming_rv_MostConcerned)
    RecyclerView comingRvMostConcerned;
    @BindView(R2.id.coming_rv)
    RecyclerView comingRv;
    @BindView(R2.id.coming_SmartRefreshLayout)
    SmartRefreshLayout comingSmartRefreshLayout;

    @Inject
    ComingAdapter adapter;
    @Inject
    MostConcernedAdapter concernedAdapter;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.coming_fragment;
    }

    @Override
    protected void initInjector() {
        DaggerComingFragmentComponent.builder()
                .applicationComponent(((BaseApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initView() {

    }

    private void initRecycerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        comingRv.setLayoutManager(linearLayoutManager);
        comingRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        comingRv.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        comingRvMostConcerned.setLayoutManager(linearLayoutManager2);
        comingRvMostConcerned.setAdapter(concernedAdapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ComingBean.MoviecomingsBean moviecomingsBean = (ComingBean.MoviecomingsBean) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra("movieId", moviecomingsBean.getId());
                startActivity(intent);
            }
        });

        concernedAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ComingBean.AttentionBean attentionBean = (ComingBean.AttentionBean) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra("movieId", attentionBean.getId());
                startActivity(intent);
            }
        });
    }


    @Override
    protected void loadData() {
        initRecycerView();
        comingEmptyLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
        assert mPresenter != null;
        mPresenter.getComingData("368");
    }

    public void setComingData(ComingBean comingBean) {
        if (comingBean != null) {
            comingSmartRefreshLayout.setVisibility(View.VISIBLE);
            comingEmptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            comingEmptyLayout.setVisibility(View.GONE);

            adapter.setNewData(comingBean.getMoviecomings());
            concernedAdapter.setNewData(comingBean.getAttention());
        } else {
            comingEmptyLayout.setErrorType(EmptyLayout.NODATA);
        }
    }

}
