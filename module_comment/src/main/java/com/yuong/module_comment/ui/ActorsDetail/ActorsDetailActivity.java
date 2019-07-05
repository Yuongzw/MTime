package com.yuong.module_comment.ui.ActorsDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.base.BaseApplication;
import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.library_base.widget.FoldableTextView;
import com.yuong.module_comment.ui.DaggerMovieDetailActivityComponent;
import com.yuong.module_comment.ui.actor_experience.ActorExpriencesActivity;
import com.yuong.module_comment.ui.adapter.ActorsDetailAdapter;
import com.yuong.module_comment.ui.award.AwardActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class ActorsDetailActivity extends BaseActivity<ActorsDetailPresent> implements ActorsDetailContract.View {
    @BindView(R2.id.iv_bg)
    ImageView ivBg;
    @BindView(R2.id.tv_profession)
    TextView tvProfession;
    @BindView(R2.id.tv_birthDay)
    TextView tvBirthDay;
    @BindView(R2.id.tv_address)
    TextView tvAddress;
    @BindView(R2.id.tv_story)
    FoldableTextView tvStory;
    @BindView(R2.id.iv_movie_img)
    ImageView ivMovieImg;
    @BindView(R2.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R2.id.tv_movie_type)
    TextView tvMovieType;
    @BindView(R2.id.tv_play_name)
    TextView tvPlayName;
    @BindView(R2.id.rv_actor_photo)
    RecyclerView rvActorPhoto;
    @BindView(R2.id.tv_all_photo)
    TextView tvAllPhoto;
    @BindView(R2.id.tv_award)
    TextView tvAward;
    @BindView(R2.id.iv_start_img)
    ImageView ivStartImg;
    @BindView(R2.id.tv_start)
    TextView tvStart;
    @BindView(R2.id.tv_content)
    TextView tvContent;
    @BindView(R2.id.iv_img)
    ImageView ivImg;
    @BindView(R2.id.tv_zh_name)
    TextView tvZhName;
    @BindView(R2.id.tv_en_name)
    TextView tvEnName;
    @BindView(R2.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.ll_movie)
    LinearLayout llMovie;
    @BindView(R2.id.ll_experience)
    LinearLayout llExperience;
    @BindView(R2.id.title_bar)
    ConstraintLayout titleBar;
    @BindView(R2.id.view_part2)
    View view_part2;
    @BindView(R2.id.view_part3)
    View view_part3;
    @BindView(R2.id.view_part4)
    View view_part4;
    @BindView(R2.id.rl_photo)
    RelativeLayout rlPhoto;
    @BindView(R2.id.ll_award)
    LinearLayout llAward;

    private float alpha;
    private ActorsDetailBean actorsDetailBean;

    @Inject
    ActorsDetailAdapter adapter;

    @Override
    public int inflateContentView() {
        return R.layout.activity_actors_detail;
    }

    @Override
    protected void initData() {
        titleBar.setAlpha(0);
        int personId = getIntent().getIntExtra("personId", 0);
        initRecyclerView();
        assert mPresenter != null;
        mPresenter.getActorsDetail(personId + "", "368");
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

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rvActorPhoto.setLayoutManager(linearLayoutManager);
        rvActorPhoto.setAdapter(adapter);
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
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected boolean isNeedInject() {
        return false;
    }


    @OnClick({R2.id.ll_movie, R2.id.ll_award, R2.id.ll_experience, R2.id.iv_back})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.iv_back) {
            finish();
        } else if (i == R.id.ll_experience) {
            Intent intent = new Intent(this, ActorExpriencesActivity.class);
            intent.putExtra("title", tvTitle.getText().toString());
            intent.putExtra("experience", actorsDetailBean);
            startActivity(intent);
        }else if (i == R.id.ll_award) {
            Intent intent = new Intent(this, AwardActivity.class);
            intent.putExtra("title", tvTitle.getText().toString());
            intent.putExtra("experience", actorsDetailBean);
            startActivity(intent);
        }
    }

    public void setActorsDetailBean(ActorsDetailBean actorsDetailBean) {
        if (actorsDetailBean != null) {
            this.actorsDetailBean = actorsDetailBean;
            ActorsDetailBean.DataBean.BackgroundBean background = actorsDetailBean.getData().getBackground();
            tvTitle.setText(background.getNameCn());
            tvZhName.setText(background.getNameCn());
            tvEnName.setText(background.getNameEn());
            tvProfession.setText(background.getProfession());
            StringBuilder builder = new StringBuilder();
            builder.append(background.getBirthYear()).append("-");
            if (background.getBirthMonth() < 10) {
                builder.append(0).append(background.getBirthMonth()).append("-");
            } else {
                builder.append(background.getBirthMonth()).append("-");
            }
            if (background.getBirthDay() < 10) {
                builder.append(0).append(background.getBirthDay());
            } else {
                builder.append(background.getBirthDay());
            }
            tvBirthDay.setText(builder.toString());
            tvAddress.setText(background.getAddress());
            Glide.with(mContext)
                    .load(background.getImage())
                    .into(ivImg);
            Glide.with(mContext)
                    .load(background.getImage())
                    .bitmapTransform(new BlurTransformation(this, 25, 8))
                    .into(ivBg);
            Glide.with(mContext)
                    .load(background.getHotMovie().getMovieCover())
                    .into(ivMovieImg);
            tvMovieName.setText(background.getHotMovie().getMovieTitleCn());
            tvMovieType.setText(background.getHotMovie().getType());
            tvPlayName.setText("饰：" + background.getHotMovie().getRoleName());
            if (!background.getHotMovie().isIsTiket()) {
                llMovie.setVisibility(View.GONE);
                view_part2.setVisibility(View.GONE);
            } else {
                llMovie.setVisibility(View.VISIBLE);
                view_part2.setVisibility(View.VISIBLE);
            }
            tvStory.setText(background.getContent());
            String award;
            if (background.getTotalWinAward() > 0 && background.getTotalNominateAward() > 0) {
                award = "共获奖" + background.getTotalWinAward() + "次，提名" + background.getTotalNominateAward() + "次";
            } else if (background.getTotalWinAward() > 0 && background.getTotalNominateAward() == 0) {
                award = "共获奖" + background.getTotalWinAward() + "次";
            } else if (background.getTotalWinAward() == 0 && background.getTotalNominateAward() > 0) {
                award = "共提名" + background.getTotalWinAward() + "次";
            } else {
                llAward.setVisibility(View.GONE);
                view_part4.setVisibility(View.GONE);
                award = "未曾获得任何奖项";
            }
            tvAward.setText(award);
            if (background.getExpriences() != null && background.getExpriences().size() > 0) {
                llExperience.setVisibility(View.VISIBLE);
                Glide.with(mContext)
                        .load(background.getExpriences().get(0).getImg())
                        .into(ivStartImg);
                tvStart.setText(background.getExpriences().get(0).getYear() + " " + background.getExpriences().get(0).getTitle());
                tvContent.setText(background.getExpriences().get(0).getContent());
            } else {
                llExperience.setVisibility(View.GONE);
                view_part4.setVisibility(View.GONE);
            }
            if (background.getImages() != null && background.getImages().size() > 0) {
                rlPhoto.setVisibility(View.VISIBLE);
                view_part3.setVisibility(View.VISIBLE);
                List<String> imgs = new ArrayList<>();
                for (ActorsDetailBean.DataBean.BackgroundBean.ImagesBean img : background.getImages()) {
                    imgs.add(img.getImage());
                }
                adapter.setNewData(imgs);
            } else {
                rlPhoto.setVisibility(View.GONE);
                view_part3.setVisibility(View.GONE);
            }

        }
    }

}
