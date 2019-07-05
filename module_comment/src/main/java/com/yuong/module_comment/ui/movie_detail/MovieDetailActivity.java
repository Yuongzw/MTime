package com.yuong.module_comment.ui.movie_detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.bean.DirctorActorBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.library_base.widget.FoldableTextView;
import com.yuong.module_comment.ui.ActorsDetail.ActorsDetailActivity;
import com.yuong.module_comment.ui.DaggerMovieDetailActivityComponent;
import com.yuong.module_comment.ui.adapter.DirectorActorAdapter;
import com.yuong.module_comment.ui.all_person.AllPersonActivity;
import com.yuong.module_comment.ui.photo.PhotoActivity;
import com.yuong.module_comment.ui.video.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class MovieDetailActivity extends BaseActivity<MovieDetailPresent> implements MovieDetailContract.View {

    @BindView(R2.id.title_bar)
    ConstraintLayout titleBar;
    @BindView(R2.id.tv_movie_min)
    TextView tvMovieMin;
    @BindView(R2.id.tv_movie_type)
    TextView tvMovieType;
    @BindView(R2.id.tv_release_date)
    TextView tvReleaseDate;
    @BindView(R2.id.tv_story)
    FoldableTextView tvStory;
    @BindView(R2.id.rv_director_actor)
    RecyclerView rvDirectorActor;
    @BindView(R2.id.tv_video_num)
    TextView tvVideoNum;
    @BindView(R2.id.iv_video)
    ImageView ivVideo;
    @BindView(R2.id.tv_photo_num)
    TextView tvPhotoNum;
    @BindView(R2.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R2.id.iv_img)
    ImageView ivImg;
    @BindView(R2.id.tv_zh_name)
    TextView tvZhName;
    @BindView(R2.id.tv_en_name)
    TextView tvEnName;
    @BindView(R2.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R2.id.iv_bg)
    ImageView ivBg;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.iv_play1)
    ImageView ivPlay1;
    @BindView(R2.id.iv_play2)
    ImageView ivPlay2;

    @Inject
    DirectorActorAdapter adapter;
    private List<DirctorActorBean> dirctorActorBeans = new ArrayList<>();
    private float alpha;
    private int movieId;

    @Override
    public int inflateContentView() {
        return R.layout.activity_movie_detail;
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
        titleBar.setAlpha(0);
        movieId = getIntent().getIntExtra("movieId", 0);
        initRecycerView();
        assert mPresenter != null;
        mPresenter.getMovieDetail("386", movieId + "");

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY <= titleBar.getHeight() * 3) {
                    alpha = (float) scrollY / (titleBar.getHeight() * 3);
                    // 随着滑动距离改变透明度
                    Log.e("al=", "=" + alpha + "scrollY=" + scrollY + " getHeight=" + titleBar.getHeight() * 4);
                    titleBar.setAlpha(alpha);
                } else {
                    // 防止频繁重复设置相同的值影响性能
                    titleBar.setAlpha(1);
                }
            }
        });
    }

    private void initRecycerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rvDirectorActor.setLayoutManager(linearLayoutManager);
        rvDirectorActor.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ActorsDetailActivity.class);
                intent.putExtra("personId", dirctorActorBeans.get(position).getActorId());
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

    @OnClick({R2.id.iv_back, R2.id.tv_all, R2.id.ll_video, R2.id.ll_photo, R2.id.iv_img})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.iv_back) {
            finish();
        } else if (i == R.id.tv_all) {
            Intent intent = new Intent(this, AllPersonActivity.class);
            intent.putExtra("movieId", movieId);
            startActivity(intent);
        } else if (i == R.id.ll_video|| i == R.id.iv_img) {
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("movieId", movieId);
            intent.putExtra("title", tvTitle.getText().toString());
            startActivity(intent);
        } else if (i == R.id.ll_photo ) {
            Intent intent = new Intent(this, PhotoActivity.class);
            intent.putExtra("movieId", movieId);
            intent.putExtra("title", tvTitle.getText().toString());
            startActivity(intent);
        }
    }

    @SuppressLint("SetTextI18n")
    public void setComingData(MovieDetailBean movieDetailBean) {
        if (movieDetailBean.getData() != null) {
            Glide.with(mContext)
                    .load(movieDetailBean.getData().getBasic().getImg())
                    .into(ivImg);
            Glide.with(mContext)
                    .load(movieDetailBean.getData().getBasic().getImg())
                    .bitmapTransform(new BlurTransformation(this, 25, 8))
                    .into(ivBg);
            tvTitle.setText(movieDetailBean.getData().getBasic().getName());
            tvZhName.setText(movieDetailBean.getData().getBasic().getName());
            tvEnName.setText(movieDetailBean.getData().getBasic().getNameEn());
            tvMovieMin.setText(movieDetailBean.getData().getBasic().getMins());
            tvMovieType.setText(movieDetailBean.getData().getBasic().getType().get(0));
            tvReleaseDate.setText(movieDetailBean.getData().getBasic().getReleaseDate() + movieDetailBean.getData().getBasic().getReleaseArea() + "上映");
            tvStory.setText(movieDetailBean.getData().getBasic().getStory());
            MovieDetailBean.DataBean.BasicBean.DirectorBean director = movieDetailBean.getData().getBasic().getDirector();
            DirctorActorBean dirctorActorBean = new DirctorActorBean();
            dirctorActorBean.setProfession("导演");
            dirctorActorBean.setActorId(director.getDirectorId());
            dirctorActorBean.setImg(director.getImg());
            dirctorActorBean.setName(director.getName());
            dirctorActorBean.setNameEn(director.getNameEn());
            dirctorActorBean.setRoleImg("");
            dirctorActorBean.setRoleName("");
            dirctorActorBeans.add(dirctorActorBean);
            if (movieDetailBean.getData().getBasic().getActors() != null && movieDetailBean.getData().getBasic().getActors().size() > 0) {
                for (MovieDetailBean.DataBean.BasicBean.ActorsBean actorsBean : movieDetailBean.getData().getBasic().getActors()) {
                    DirctorActorBean dirctorActorBean1 = new DirctorActorBean();
                    dirctorActorBean1.setProfession("全部演员");
                    dirctorActorBean1.setActorId(actorsBean.getActorId());
                    dirctorActorBean1.setImg(actorsBean.getImg());
                    dirctorActorBean1.setName(actorsBean.getName());
                    dirctorActorBean1.setNameEn(actorsBean.getNameEn());
                    dirctorActorBean1.setRoleImg(actorsBean.getRoleImg());
                    dirctorActorBean1.setRoleName(actorsBean.getRoleName());
                    dirctorActorBeans.add(dirctorActorBean1);
                }
            }
            adapter.setNewData(dirctorActorBeans);
            if (movieDetailBean.getData().getBasic().getVideo().getCount() > 0) {
                tvVideoNum.setVisibility(View.VISIBLE);
                ivPlay1.setVisibility(View.VISIBLE);
                ivPlay2.setVisibility(View.VISIBLE);
                tvVideoNum.setText(movieDetailBean.getData().getBasic().getVideo().getCount() + " >");
                Glide.with(mContext)
                        .load(movieDetailBean.getData().getBasic().getVideo().getImg())
                        .into(ivVideo);
            } else {
                tvVideoNum.setVisibility(View.GONE);
                ivPlay1.setVisibility(View.GONE);
                ivPlay2.setVisibility(View.GONE);
                ivVideo.setImageDrawable(getResources().getDrawable(R.drawable.page_icon_empty));
            }
            if (movieDetailBean.getData().getBasic().getStageImg().getCount() > 0) {
                tvPhotoNum.setVisibility(View.VISIBLE);
                tvPhotoNum.setText(movieDetailBean.getData().getBasic().getStageImg().getCount() + " >");
                Glide.with(mContext)
                        .load(movieDetailBean.getData().getBasic().getStageImg().getList().get(0).getImgUrl())
                        .into(ivPhoto);
            } else {
                tvPhotoNum.setVisibility(View.GONE);
            }
        }
    }
}
