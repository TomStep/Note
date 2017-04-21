package com.gan.lib.note.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.databinding.HolderToonsBookItemBinding;
import com.gan.lib.note.entiry.ToonsBookEntiry;

/**
 *
 * Created by tangjun on 2017/4/20.
 */

public class ToonsBookVH extends RecyclerView.ViewHolder {

    private final HolderToonsBookItemBinding mBinding;

    public ToonsBookVH(HolderToonsBookItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void setBinding(final ToonsBookEntiry entiry){
        mBinding.setEntiry(entiry);
        mBinding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadLauncher.OnclickToonsBookItem(v.getContext(),entiry);
            }
        });
    }
}
