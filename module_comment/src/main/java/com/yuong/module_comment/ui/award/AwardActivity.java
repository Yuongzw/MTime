package com.yuong.module_comment.ui.award;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.yuong.comment.R;
import com.yuong.comment.R2;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.bean.AwardItemBean;
import com.yuong.library_base.bean.AwardTitleBean;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.bean.MyMultiItemEntity;
import com.yuong.library_base.widget.PinnedHeaderItemDecoration;
import com.yuong.library_base.widget.PinnedHeaderRecyclerView;
import com.yuong.module_comment.ui.ActorsDetail.ActorsDetailActivity;
import com.yuong.module_comment.ui.adapter.AllPersonAdapter;
import com.yuong.module_comment.ui.adapter.AwardAdapter;
import com.yuong.module_comment.ui.all_person.AllPersonActivity;
import com.yuong.module_comment.ui.movie_detail.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AwardActivity extends BaseActivity {
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_award)
    TextView tvAward;
    @BindView(R2.id.rv_award)
    PinnedHeaderRecyclerView rvAward;

    private ActorsDetailBean actorsDetailBean;
    private AwardAdapter adapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public int inflateContentView() {
        return R.layout.activity_award;
    }

    @Override
    protected void initData() {
        adapter = new AwardAdapter(mContext);
        tvTitle.setText(getIntent().getStringExtra("title"));
        actorsDetailBean = (ActorsDetailBean) getIntent().getSerializableExtra("experience");
        highlightKeyword(tvAward, actorsDetailBean.getData().getBackground().getTotalWinAward() + "", actorsDetailBean.getData().getBackground().getTotalNominateAward() + "", "曾获奖" + actorsDetailBean.getData().getBackground().getTotalWinAward() + "次，提名" + actorsDetailBean.getData().getBackground().getTotalNominateAward() + "次");
        initRecyclerView();
        getData(actorsDetailBean);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvAward.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rvAward.addItemDecoration(new PinnedHeaderItemDecoration());
        rvAward.setAdapter(adapter);

        rvAward.setOnPinnedHeaderClickListener(new PinnedHeaderRecyclerView.OnPinnedHeaderClickListener() {
            @Override
            public void onPinnedHeaderClick(int adapterPosition) {
                adapter.switchExpand(adapterPosition);
                //标题栏被点击之后，滑动到指定位置
                mLayoutManager.scrollToPositionWithOffset(adapterPosition, 0);
            }
        });

        adapter.setOnItemClickListener(new AwardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id) {
                Intent intent = new Intent(AwardActivity.this, MovieDetailActivity.class);
                intent.putExtra("movieId", id);
                startActivity(intent);
            }
        });


    }

    /**
     * 高亮某个关键字，如果有多个则全部高亮
     */
    private void highlightKeyword(TextView textView, String key1, String key2,  String str) {

        SpannableString sp = new SpannableString(str);

        Pattern p1 = Pattern.compile(key1);
        Matcher m1 = p1.matcher(str);
        StyleSpan span = new StyleSpan(Typeface.BOLD_ITALIC);
        sp.setSpan(span, 3, 4 , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        while (m1.find()) {	//通过正则查找，逐个高亮
            int start = m1.start();
            int end = m1.end();
            sp.setSpan(new ForegroundColorSpan(Color.parseColor("#05337a")), start ,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        Pattern p2 = Pattern.compile(key2);
        Matcher m2 = p2.matcher(str);
        StyleSpan span2 = new StyleSpan(Typeface.BOLD_ITALIC);
        sp.setSpan(span2, str.length() - key2.length() - 1,str.length() - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        while (m2.find()) {	//通过正则查找，逐个高亮
            int start = m2.start();
            int end = m2.end();
            sp.setSpan(new ForegroundColorSpan(Color.parseColor("#05337a")), start ,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        textView.setText(sp);
    }

    private void getData(ActorsDetailBean actorsDetailBean) {
        List<MyMultiItemEntity<AwardTitleBean, AwardItemBean>> dataList = new ArrayList<>();
        for (int i = 0; i < actorsDetailBean.getData().getBackground().getFestivals().size(); i++) {
            MyMultiItemEntity<AwardTitleBean, AwardItemBean> itemEntity = new MyMultiItemEntity<>();
            itemEntity.setExpand(true);
            AwardTitleBean awardTitleBean = new AwardTitleBean();
            awardTitleBean.setFestivalId(actorsDetailBean.getData().getBackground().getFestivals().get(i).getFestivalId());
            awardTitleBean.setImg(actorsDetailBean.getData().getBackground().getFestivals().get(i).getImg());
            awardTitleBean.setNameCn(actorsDetailBean.getData().getBackground().getFestivals().get(i).getNameCn());
            awardTitleBean.setNameEn(actorsDetailBean.getData().getBackground().getFestivals().get(i).getNameEn());
            awardTitleBean.setNominateCount(actorsDetailBean.getData().getBackground().getTotalNominateAward());
            awardTitleBean.setWinCount(actorsDetailBean.getData().getBackground().getTotalWinAward());
            itemEntity.setmParent(awardTitleBean);
            List<AwardItemBean> childList = new ArrayList<>();
            if (actorsDetailBean.getData().getBackground().getAwards() != null && actorsDetailBean.getData().getBackground().getAwards().size() > 0) {
                if (actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards() != null && actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().size() > 0) {
                    for (int k = 0; k < actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().size(); k++) {
                        AwardItemBean awardItemBean = new AwardItemBean();
                        awardItemBean.setAwardName(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getAwardName());
                        awardItemBean.setAwardType("获奖");
                        awardItemBean.setFestivalEventYear(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getFestivalEventYear());
                        awardItemBean.setImage(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getImage());
                        awardItemBean.setMovieId(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getMovieId());
                        awardItemBean.setMovieTitle(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getMovieTitle());
                        awardItemBean.setMovieTitleEn(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getMovieTitleEn());
                        awardItemBean.setMovieYear(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getMovieYear());
                        awardItemBean.setRoleName(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getRoleName());
                        awardItemBean.setSequenceNumber(actorsDetailBean.getData().getBackground().getAwards().get(i).getWinAwards().get(k).getSequenceNumber());
                        awardItemBean.setIndex(k + 1);
                        childList.add(awardItemBean);
                    }
                }
            }

            if (actorsDetailBean.getData().getBackground().getAwards() != null && actorsDetailBean.getData().getBackground().getAwards().size() > 0) {
                if (actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards() != null && actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().size() > 0) {
                    for (int k = 0; k < actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().size(); k++) {
                        AwardItemBean awardItemBean = new AwardItemBean();
                        awardItemBean.setAwardName(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getAwardName());
                        awardItemBean.setAwardType("提名");
                        awardItemBean.setFestivalEventYear(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getFestivalEventYear());
                        awardItemBean.setImage(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getImage());
                        awardItemBean.setMovieId(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getMovieId());
                        awardItemBean.setMovieTitle(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getMovieTitle());
                        awardItemBean.setMovieTitleEn(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getMovieTitleEn());
                        awardItemBean.setMovieYear(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getMovieYear());
                        awardItemBean.setRoleName(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getRoleName());
                        awardItemBean.setSequenceNumber(actorsDetailBean.getData().getBackground().getAwards().get(i).getNominateAwards().get(k).getSequenceNumber());
                        awardItemBean.setIndex(k + 1);
                        childList.add(awardItemBean);
                    }
                }
            }
            itemEntity.setmChildList(childList);
            dataList.add(itemEntity);
        }

        adapter.setData(dataList);


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
