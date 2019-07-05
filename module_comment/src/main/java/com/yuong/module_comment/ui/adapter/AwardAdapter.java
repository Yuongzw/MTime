package com.yuong.module_comment.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuong.comment.R;
import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.bean.AwardItemBean;
import com.yuong.library_base.bean.AwardTitleBean;
import com.yuong.library_base.bean.MyMultiItemEntity;
import com.yuong.library_base.widget.RecyclerExpandBaseAdapter;

public class AwardAdapter extends RecyclerExpandBaseAdapter<AwardTitleBean, AwardItemBean, RecyclerView.ViewHolder> {

    private Context context;

    private OnItemClickListener onItemClickListener;

    public AwardAdapter(Context context) {
        this.context = context;
    }

    /**
     * 悬浮标题栏被点击的时候，展开收起切换功能
     */
    public void switchExpand(int adapterPosition) {
        int groupIndex = mIndexMap.get(adapterPosition).getGroupIndex();
        MyMultiItemEntity entity = mDataList.get(groupIndex);
        entity.setExpand(!entity.isExpand());
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == VIEW_TYPE_ITEM_TIME) {
            TitleItemHolder holder = new TitleItemHolder(
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_award_item, viewGroup, false));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyMultiItemEntity entity = (MyMultiItemEntity) v.getTag();
                    entity.setExpand(!entity.isExpand());
                    notifyDataSetChanged();
                }
            });
            return holder;
        } else {
            return new SubItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.award_item, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM_TIME) {
            int groupIndex = mIndexMap.get(position).getGroupIndex();
            TitleItemHolder itemHolder = (TitleItemHolder) viewHolder;
            itemHolder.itemView.setTag(mDataList.get(groupIndex));
            Glide.with(context)
                    .load(mDataList.get(groupIndex).getmParent().getImg())
                    .into(itemHolder.iv_award_img);
            itemHolder.tv_award_title.setText(mDataList.get(groupIndex).getmParent().getNameCn());
            itemHolder.tv_award_en_name.setText(mDataList.get(groupIndex).getmParent().getNameEn());
            itemHolder.tv_award_num.setText("获奖" + mDataList.get(groupIndex).getmParent().getWinCount() + "次，提名" + mDataList.get(groupIndex).getmParent().getNominateCount() + "次");
            itemHolder.iv_fold.setRotation(mDataList.get(groupIndex).isExpand() ? 180 : 0);
        } else {
            SubItemHolder subHolder = (SubItemHolder) viewHolder;
            int groupIndex = mIndexMap.get(position).getGroupIndex();
            int childIndex = mIndexMap.get(position).getChildIndex();
            final AwardItemBean awardItemBean = mDataList.get(groupIndex).getChildList().get(childIndex);
            subHolder.tv_award_type.setText(awardItemBean.getAwardType());
            subHolder.tv_award_sequenceNumber.setText("第" + awardItemBean.getSequenceNumber() + "届(" + awardItemBean.getFestivalEventYear() + ") - " +
                    awardItemBean.getAwardName());
            subHolder.tv_award_movie.setText("获奖影片：《" + awardItemBean.getMovieTitle() + "》");
            subHolder.tv_play_name.setText("饰演角色：" + awardItemBean.getRoleName());
            Glide.with(context)
                    .load(awardItemBean.getImage())
                    .into(subHolder.iv_movie_img);
            if (awardItemBean.getIndex() > 1) {
                subHolder.tv_award_type.setVisibility(View.GONE);
            } else {
                subHolder.tv_award_type.setVisibility(View.VISIBLE);
            }
            if (childIndex == mIndexMap.get(position).getChildCount()) {
                subHolder.view_part.setVisibility(View.GONE);
            } else {
                subHolder.view_part.setVisibility(View.VISIBLE);
            }
            subHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(awardItemBean.getMovieId());
                    }
                }
            });

        }
    }

    @Override
    public void onBindPinnedViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindPinnedViewHolder(holder, position);
    }




    static class TitleItemHolder extends RecyclerView.ViewHolder {

        TextView tv_award_title;
        TextView tv_award_en_name;
        TextView tv_award_num;
        ImageView iv_fold;
        ImageView iv_award_img;

        TitleItemHolder(View itemView) {
            super(itemView);
            tv_award_title = itemView.findViewById(R.id.tv_award_title);
            tv_award_en_name = itemView.findViewById(R.id.tv_award_en_name);
            tv_award_num = itemView.findViewById(R.id.tv_award_num);
            iv_fold = itemView.findViewById(R.id.iv_fold);
            iv_award_img = itemView.findViewById(R.id.iv_award_img);
        }
    }

    static class SubItemHolder extends RecyclerView.ViewHolder {

        View ll_person;
        ImageView iv_movie_img;
        TextView tv_award_type;
        TextView tv_award_sequenceNumber;
        TextView tv_award_movie;
        TextView tv_play_name;
        View view_part;

        SubItemHolder(View itemView) {
            super(itemView);
            ll_person = itemView;
            iv_movie_img = itemView.findViewById(R.id.iv_movie_img);
            tv_award_type = itemView.findViewById(R.id.tv_award_type);
            tv_award_sequenceNumber = itemView.findViewById(R.id.tv_award_sequenceNumber);
            tv_award_movie = itemView.findViewById(R.id.tv_award_movie);
            tv_play_name = itemView.findViewById(R.id.tv_play_name);
            view_part = itemView.findViewById(R.id.view_part);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

}
