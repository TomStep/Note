package com.gan.lib.note.ui.holder;

import android.support.v7.widget.RecyclerView;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.databinding.HolderToonsHotItemBinding;
import com.gan.lib.note.entiry.ToonsHotEntiry;

/**
 *
 * Created by tangjun on 2017/4/12.
 */

public class ToonsHotVH extends RecyclerView.ViewHolder {

    private HolderToonsHotItemBinding mBinding;

    public ToonsHotVH(HolderToonsHotItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void setBinding(ToonsHotEntiry entiry){
        LogUtils.d("img:"+entiry.getImg());
        mBinding.setEntiry(entiry);
    }
}
