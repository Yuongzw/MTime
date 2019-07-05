package com.yuong.library_base.widget;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import com.yuong.library_base.bean.ExpandGroupIndexEntity;
import com.yuong.library_base.bean.MyMultiItemEntity;

import java.util.List;

public abstract class RecyclerExpandBaseAdapter<P, C, VH extends RecyclerView.ViewHolder> extends PinnedHeaderAdapter<VH> {

    protected static final int VIEW_TYPE_ITEM_TIME    = 0;
    protected static final int VIEW_TYPE_ITEM_CONTENT = 1;

    protected List<MyMultiItemEntity<P, C>> mDataList;
    protected SparseArray<ExpandGroupIndexEntity> mIndexMap;

    public RecyclerExpandBaseAdapter() {
        this(null);
    }

    public RecyclerExpandBaseAdapter(List<MyMultiItemEntity<P, C>> dataList) {
        mDataList = dataList;
        mIndexMap = new SparseArray<>();
    }

    public void setData(List<MyMultiItemEntity<P, C>> dataList) {
        mDataList = dataList;
        mIndexMap.clear();
        notifyDataSetChanged();
    }

    public List<MyMultiItemEntity<P, C>> getData() {
        return mDataList;
    }

    @Override
    public boolean isPinnedPosition(int position) {
        return getItemViewType(position) == VIEW_TYPE_ITEM_TIME;
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;
        for (MyMultiItemEntity<P, C> item : mDataList) {
            count = count + 1;

            if (position == count - 1) {
                return VIEW_TYPE_ITEM_TIME;
            }
            if (item.getChildList() != null && item.isExpand()) {
                count = count + item.getChildList().size();
            }
            if (position < count) {
                return VIEW_TYPE_ITEM_CONTENT;
            }
        }
        throw new IllegalArgumentException("getItemViewType exception");
    }

    @Override
    public int getItemCount() {
        if (mDataList == null || mDataList.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int group = 0; group < mDataList.size(); group++) {
            MyMultiItemEntity<P, C> item = mDataList.get(group);
            //标题
            count = count + 1;

            mIndexMap.put(count - 1, new ExpandGroupIndexEntity(group, -1, item.getChildList() == null ? 0 : item.getChildList().size()));
            int childStartPosition = count;
            if (item.getChildList() != null && item.isExpand()) {
                //sub
                count = count + item.getChildList().size();
            }
            int childEndPosition = count;
            for (int loop = childStartPosition; loop < childEndPosition; loop++) {
                mIndexMap.put(loop, new ExpandGroupIndexEntity(group, loop - childStartPosition,
                        item.getChildList() == null ? 0 : item.getChildList().size()));
            }
        }
        return count;
    }

}
