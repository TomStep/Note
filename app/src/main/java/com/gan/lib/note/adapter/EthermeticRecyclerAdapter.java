package com.gan.lib.note.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.INewViewHolder;
import com.gan.lib.note.entiry.EtherItemEntiry;
import com.gan.lib.note.factory.ViewHolderFactory;
import com.gan.lib.note.ui.holder.EthermeticItemVH;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EthermeticRecyclerAdapter extends RecyclerView.Adapter {

    private final INewViewHolder mFactory;
    private ArrayList<EtherItemEntiry> mList;

    public EthermeticRecyclerAdapter(ArrayList<EtherItemEntiry> mList) {
        mFactory = ViewHolderFactory.instance();
        this.mList = mList;

        LogUtils.d("list大小："+mList.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mFactory.getEthermeticItemVH(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((EthermeticItemVH) holder).bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 刷新所有数据
     * @param list list
     */
    public void updateRecycler(ArrayList<EtherItemEntiry> list){
        if(mList == null) return;

        mList.clear();
        mList.addAll(list);
        this.notifyItemRangeChanged(0,list.size());
    }

    /**
     * 添加新数据
     * @param list list
     */
    public void addDataRecycler(List<EtherItemEntiry> list){
        if(mList == null) return;

        this.mList.addAll(list);
        this.notifyItemRangeChanged(list.size()-1,mList.size());
    }
}
