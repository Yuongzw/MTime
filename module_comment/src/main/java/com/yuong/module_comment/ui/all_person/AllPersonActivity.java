package com.yuong.module_comment.ui.all_person;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.bean.MyMultiItemEntity;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.library_base.widget.PinnedHeaderItemDecoration;
import com.yuong.library_base.widget.PinnedHeaderRecyclerView;
import com.yuong.module_comment.ui.ActorsDetail.ActorsDetailActivity;
import com.yuong.module_comment.ui.DaggerMovieDetailActivityComponent;
import com.yuong.module_comment.ui.adapter.AllPersonAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class AllPersonActivity extends BaseActivity<AllPersonsPresent> implements AllPersonsContract.View {


    @Inject
    AllPersonAdapter adapter;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.rv_persons)
    PinnedHeaderRecyclerView rvPersons;

    private LinearLayoutManager mLayoutManager;
    /**
     * hotMovie : {"isTiket":true,"movieCover":"http://img5.mtime.cn/mt/2019/02/27/164533.80435476_1280X720X2.jpg","movieId":212573,"movieTitleCn":"乐高大电影2","movieTitleEn":"The Lego Movie 2: The Second Part","ratingFinal":-1,"roleName":"Emmet Brickowski /              Rex Dangervest       (voice)","ticketPrice":2100,"type":"动画 / 动作 / 冒险"}
     */

    @Override
    protected void initInjector() {
        DaggerMovieDetailActivityComponent.builder()
                .applicationComponent(((BaseApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int inflateContentView() {
        return R.layout.activity_persons;
    }

    @Override
    protected void initData() {
        tvTitle.setText("演职员");
        initRecycerView();
        assert mPresenter != null;
        mPresenter.getMovieCreditsWithTypes(getIntent().getIntExtra("movieId", 0) + "");
    }

    private void initRecycerView() {
        adapter.setContext(mContext);
        mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvPersons.setLayoutManager(mLayoutManager);
        rvPersons.addItemDecoration(new PinnedHeaderItemDecoration());
        rvPersons.setAdapter(adapter);

        rvPersons.setOnPinnedHeaderClickListener(new PinnedHeaderRecyclerView.OnPinnedHeaderClickListener() {
            @Override
            public void onPinnedHeaderClick(int adapterPosition) {
                adapter.switchExpand(adapterPosition);
                //标题栏被点击之后，滑动到指定位置
                mLayoutManager.scrollToPositionWithOffset(adapterPosition, 0);
            }
        });

        adapter.setItemClickListener(new AllPersonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id) {
                Intent intent = new Intent(AllPersonActivity.this, ActorsDetailActivity.class);
                intent.putExtra("personId", id);
                startActivity(intent);
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

    public void setMovieCreditsWithTypeBean(MovieCreditsWithTypeBean movieCreditsWithTypeBean) {
        List<MyMultiItemEntity<String, MovieCreditsWithTypeBean.TypesBean.PersonsBean>> dataList = new ArrayList<>();
        if (movieCreditsWithTypeBean.getTypes() != null && movieCreditsWithTypeBean.getTypes().size() > 0) {
            for (int i = 0; i < movieCreditsWithTypeBean.getTypes().size(); i++) {
                MyMultiItemEntity<String, MovieCreditsWithTypeBean.TypesBean.PersonsBean> itemEntity = new MyMultiItemEntity<>();
                itemEntity.setExpand(true);
                itemEntity.setmParent( movieCreditsWithTypeBean.getTypes().get(i).getTypeName() + "/" +  movieCreditsWithTypeBean.getTypes().get(i).getTypeNameEn());
                List<MovieCreditsWithTypeBean.TypesBean.PersonsBean> childList = new ArrayList<>();
                if (movieCreditsWithTypeBean.getTypes().get(i).getPersons() != null && movieCreditsWithTypeBean.getTypes().get(i).getPersons().size() > 0){
                    for (int j = 0; j < movieCreditsWithTypeBean.getTypes().get(i).getPersons().size(); j++) {
                        MovieCreditsWithTypeBean.TypesBean.PersonsBean personsBean = new MovieCreditsWithTypeBean.TypesBean.PersonsBean();
                        personsBean.setId(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getId());
                        personsBean.setImage(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getImage());
                        personsBean.setName(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getName());
                        personsBean.setNameEn(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getNameEn());
                        if (movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonate() != null && movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonate().length() > 0){
                            personsBean.setPersonate(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonate());
                        } else {
                            personsBean.setPersonate("");
                        }
                        if (movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonateEn() != null && movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonateEn().length() > 0){
                            personsBean.setPersonateEn(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonateEn());
                        } else {
                            personsBean.setPersonateEn("");
                        }
                        if (movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonateCn() != null && movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonateCn().length() > 0){
                            personsBean.setPersonateCn(movieCreditsWithTypeBean.getTypes().get(i).getPersons().get(j).getPersonateCn());
                        } else {
                            personsBean.setPersonateCn("");
                        }
                        childList.add(personsBean);
                    }
                }
                itemEntity.setmChildList(childList);
                dataList.add(itemEntity);
            }
        }
        adapter.setData(dataList);

    }

    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }

}
