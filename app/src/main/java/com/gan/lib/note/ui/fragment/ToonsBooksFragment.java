package com.gan.lib.note.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentToonsBooksBinding;
import com.gan.lib.note.ui.view.IToonsBooks;
import com.gan.lib.note.viewmodel.fragment.ToonsBooksVM;

import me.yokeyword.fragmentation.SupportFragment;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBooksFragment extends ViewModelBaseBindingFragment<IToonsBooks,ToonsBooksVM,FragmentToonsBooksBinding>
    implements IToonsBooks{

    private final static String TITLE = "title";
    private final static String URL   = "url";


    public static ToonsBooksFragment newInstance(String title,String url) {
        ToonsBooksFragment fragment = new ToonsBooksFragment();
        Bundle args = new Bundle();
        args.putString(TITLE,title);
        args.putString(URL,url);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_toons_books,_mActivity);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initTitle();
        setToolbarTitle(getArguments().getString(TITLE));
        //添加fragment
        addFragmentInFrame(ToonsBookRecyclerFragment.newInstance(getArguments().getString(URL)));
        setModelView(this);
    }

    private void initTitle(){
        getToolbar().setNavigationIcon(com.gan.lib.frame.R.drawable.ic_arrow_back_white_24dp);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
    }

    @Override
    public Toolbar getToolbar() {
        return getBinding().toolBar;
    }

    @Override
    public FrameLayout getFrameLayout() {
        return getBinding().fragmentLayout;
    }

    @Override
    public void setToolbarTitle(String title) {
        getToolbar().setTitle(title);
        getToolbar().setTitleTextColor(Color.WHITE);
    }

    @Override
    public void addFragmentInFrame(SupportFragment fragment) {
        loadRootFragment(getFrameLayout().getId(),fragment);
    }

}
