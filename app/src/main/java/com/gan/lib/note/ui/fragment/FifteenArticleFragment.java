package com.gan.lib.note.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentFifteenArticleBinding;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.ui.view.IFifteenArticle;
import com.gan.lib.note.viewmodel.fragment.FifteenArticleVM;

/**
 *
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleFragment
        extends ViewModelBaseBindingFragment<IFifteenArticle,FifteenArticleVM,FragmentFifteenArticleBinding>
        implements IFifteenArticle{

    private static final String KEY_FIFTEEN_ARTICLE = "key_fifteen_article";

    public static FifteenArticleFragment instance(FifteenArticleEntiry entiry){
        FifteenArticleFragment fragment = new FifteenArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_FIFTEEN_ARTICLE,entiry);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LogUtils.d("执行了嘛");

        setModelView(this);
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_fifteen_article,getActivity());
    }
}
