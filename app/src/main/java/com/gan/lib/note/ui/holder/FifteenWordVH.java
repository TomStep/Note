package com.gan.lib.note.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.databinding.HolderFifteenWordArticleBinding;
import com.gan.lib.note.entiry.FifteenWordEntiry;

/**
 * 创建FifiteenWord ViewHolder
 * Created by tangjun on 2017/3/30.
 */

public class FifteenWordVH extends RecyclerView.ViewHolder {

    private final HolderFifteenWordArticleBinding mBinding;

    public FifteenWordVH(HolderFifteenWordArticleBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public void bind(final FifteenWordEntiry entiry){
        mBinding.setEntiry(entiry);

        //设置点击事件
        mBinding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadLauncher.sendFifteenWordToFragment(v.getContext(),entiry);
            }
        });
    }

}
