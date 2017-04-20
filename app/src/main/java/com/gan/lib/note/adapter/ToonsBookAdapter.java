package com.gan.lib.note.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gan.lib.note.INewViewHolder;
import com.gan.lib.note.entiry.ToonsBookEntiry;
import com.gan.lib.note.entiry.ToonsHotEntiry;
import com.gan.lib.note.factory.ViewHolderFactory;
import com.gan.lib.note.ui.holder.ToonsBookVH;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/20.
 */

public class ToonsBookAdapter extends RecyclerView.Adapter {

    private ArrayList<ToonsBookEntiry> mList;
    private final INewViewHolder mFactory;


    public ToonsBookAdapter(ArrayList<ToonsBookEntiry> entiries) {
        mFactory = ViewHolderFactory.instance();

        mList = entiries;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mFactory.getToonsBookItemVH(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ToonsBookVH toonsBookVH = (ToonsBookVH) holder;
        toonsBookVH.setBinding(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void updateRecycler(ArrayList<ToonsBookEntiry> list) {
        if(mList == null) return;

        mList.clear();
        mList.addAll(list);
        this.notifyItemRangeChanged(0,list.size());
    }
}
