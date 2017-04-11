package com.gan.lib.note.ui.holder;

import android.support.v7.widget.RecyclerView;

import com.gan.lib.note.databinding.HolderEthermeticItemBinding;
import com.gan.lib.note.entiry.EtherItemEntiry;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EthermeticItemVH extends RecyclerView.ViewHolder {

    private final HolderEthermeticItemBinding mBinding;

    public EthermeticItemVH(HolderEthermeticItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(EtherItemEntiry entiry) {
        mBinding.setEntiry(entiry);
    }
}
