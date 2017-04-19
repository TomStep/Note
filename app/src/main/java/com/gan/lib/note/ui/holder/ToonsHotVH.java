package com.gan.lib.note.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.broad.BroadLauncher;
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

    public void setBinding(final ToonsHotEntiry entiry){
        mBinding.setEntiry(entiry);

        //设置点击事件
        mBinding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadLauncher.OnclickToonsHotItems(v.getContext(),entiry);
            }
        });
    }
}
