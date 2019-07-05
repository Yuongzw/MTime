package com.yuong.module_comment.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yuong.comment.R;
import com.yuong.library_base.bean.ImageAllBean;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private List<ImageAllBean.ImagesBean> data;//数据

    private Context context;//上下文

    private OnItemClickListener onItemClickListener;

    public GridViewAdapter(List<ImageAllBean.ImagesBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getImage();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            //加载子布局
            view = LayoutInflater.from(context).inflate(R.layout.photo_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.iv_photo);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context)
                .load(data.get(position).getImage())
                .into(viewHolder.imageView);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
        return view;

    }

    private class ViewHolder {
        ImageView imageView;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
