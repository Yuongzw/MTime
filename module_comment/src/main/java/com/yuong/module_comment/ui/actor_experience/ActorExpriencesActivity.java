package com.yuong.module_comment.ui.actor_experience;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.router.RouterActivityPath;
import com.yuong.module_comment.ui.adapter.ActorExperienceAdapter;

import butterknife.BindView;
import butterknife.OnClick;


@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class ActorExpriencesActivity extends BaseActivity {
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.rv_experience)
    RecyclerView rvExperience;

    private ActorExperienceAdapter adapter;

    private ActorsDetailBean actorsDetailBean;

    @Override
    public int inflateContentView() {
        return R.layout.activity_actors_expriences;
    }

    @Override
    protected void initData() {
        adapter = new ActorExperienceAdapter();
        tvTitle.setText(getIntent().getStringExtra("title"));
        actorsDetailBean = (ActorsDetailBean) getIntent().getSerializableExtra("experience");
        initRecyclerView();
        adapter.setNewData(actorsDetailBean.getData().getBackground().getExpriences());
    }


    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvExperience.setLayoutManager(linearLayoutManager);
        rvExperience.setAdapter(adapter);
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
}
