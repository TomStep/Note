package com.gan.lib.note.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gan.lib.note.INewViewHolder;
import com.gan.lib.note.entiry.ToonsHotEntiry;
import com.gan.lib.note.factory.ViewHolderFactory;
import com.gan.lib.note.ui.holder.ToonsHotVH;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/12.
 */

public class ToonsHotAdapter extends RecyclerView.Adapter {

    private final INewViewHolder mFactory;
    private final ArrayList<ToonsHotEntiry> mList;

    public ToonsHotAdapter(ArrayList<ToonsHotEntiry> list) {
        mFactory = ViewHolderFactory.instance();
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mFactory.getToonsHotItemVH(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ToonsHotVH toonsHotVH = (ToonsHotVH) holder;
        toonsHotVH.setBinding(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateRecycler(ArrayList<ToonsHotEntiry> list) {
        if(mList == null) return;

        mList.clear();
        mList.addAll(list);
        this.notifyDataSetChanged();
    }
}
