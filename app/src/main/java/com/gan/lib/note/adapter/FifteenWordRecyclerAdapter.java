package com.gan.lib.note.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.INewViewHolder;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.entiry.FifteenWordEntiry;
import com.gan.lib.note.factory.ViewHolderFactory;
import com.gan.lib.note.ui.holder.FifteenWordVH;

import java.util.ArrayList;
import java.util.List;


/**
 * 创建FifteenWord适配器
 * Created by tangjun on 2017/3/30.
 */

public class FifteenWordRecyclerAdapter extends RecyclerView.Adapter {

    private final INewViewHolder mFactory;

    private List<FifteenWordEntiry> mList;

    public FifteenWordRecyclerAdapter(ArrayList<FifteenWordEntiry> list) {
        mFactory = ViewHolderFactory.instance();
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mFactory.getFifteenVH(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FifteenWordVH) holder).bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 刷新所有数据
     * @param list list
     */
    public void updateRecycler(ArrayList<FifteenWordEntiry> list){
        if(mList == null) return;

        mList.clear();
        mList.addAll(list);
        this.notifyDataSetChanged();
    }

    /**
     * 添加新数据
     * @param list list
     */
    public void addDataRecycler(List<FifteenWordEntiry> list){
        if(mList == null) return;

        this.mList.addAll(list);
        this.notifyItemRangeChanged(list.size()-1,mList.size());
    }

}
