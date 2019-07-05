package com.yuong.module_comment.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuong.comment.R;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.bean.MyMultiItemEntity;
import com.yuong.library_base.widget.RecyclerExpandBaseAdapter;

import javax.inject.Inject;


public class AllPersonAdapter extends RecyclerExpandBaseAdapter<String, MovieCreditsWithTypeBean.TypesBean.PersonsBean, RecyclerView.ViewHolder> {

    private Context context;
    private OnItemClickListener itemClickListener;

    @Inject
    public AllPersonAdapter() {
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

    public void setContext(Context context) {
        this.context = context;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM_TIME) {
            TitleItemHolder holder = new TitleItemHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.header_title_item, parent, false));
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
            return new SubItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.persons_item, parent, false));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreatePinnedViewHolder(ViewGroup parent, int viewType) {
        TitleItemHolder holder = (TitleItemHolder) super.onCreatePinnedViewHolder(parent, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM_TIME) {
            int groupIndex = mIndexMap.get(position).getGroupIndex();
            TitleItemHolder itemHolder = (TitleItemHolder) holder;
            itemHolder.itemView.setTag(mDataList.get(groupIndex));
            itemHolder.tv_type.setText(mDataList.get(groupIndex).getmParent());
            itemHolder.iv_fold.setRotation(mDataList.get(groupIndex).isExpand() ? 90 : -90);

        } else {
            SubItemHolder subHolder = (SubItemHolder) holder;
            int groupIndex = mIndexMap.get(position).getGroupIndex();
            int childIndex = mIndexMap.get(position).getChildIndex();
            final MovieCreditsWithTypeBean.TypesBean.PersonsBean personsBean = mDataList.get(groupIndex).getChildList().get(childIndex);
            subHolder.itemView.setTag(personsBean);
            subHolder.tv_zh_name.setText(personsBean.getName());
            subHolder.tv_en_name.setText(personsBean.getNameEn());
            Glide.with(context)
                    .load(personsBean.getImage())
                    .into(subHolder.iv_img);
            if (personsBean.getPersonate() != null && personsBean.getPersonate().length() > 0) {
                subHolder.tv_play_name.setText("饰：" + personsBean.getPersonate());
                subHolder.tv_play_name.setVisibility(View.VISIBLE);

            } else {
                subHolder.tv_play_name.setVisibility(View.GONE);
            }
            if (childIndex == mIndexMap.get(position).getChildCount()) {
                subHolder.view_part.setVisibility(View.GONE);
            } else {
                subHolder.view_part.setVisibility(View.VISIBLE);
            }
//
            subHolder.ll_person.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(personsBean.getId());
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

        TextView tv_type;
        ImageView iv_fold;

        TitleItemHolder(View itemView) {
            super(itemView);
            tv_type = itemView.findViewById(R.id.tv_type);
            iv_fold = itemView.findViewById(R.id.iv_fold);
        }
    }

    static class SubItemHolder extends RecyclerView.ViewHolder {

        View ll_person;
        ImageView iv_img;
        TextView tv_zh_name;
        TextView tv_en_name;
        TextView tv_play_name;
        View view_part;

        SubItemHolder(View itemView) {
            super(itemView);
            ll_person = itemView;
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_zh_name = itemView.findViewById(R.id.tv_zh_name);
            tv_en_name = itemView.findViewById(R.id.tv_en_name);
            tv_play_name = itemView.findViewById(R.id.tv_play_name);
            view_part = itemView.findViewById(R.id.view_part);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
    }
}

