package com.gan.lib.note.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.transition.Fade;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentMainBinding;
import com.gan.lib.note.ui.view.IMainFragment;
import com.gan.lib.note.viewmodel.fragment.MainFragmentVM;

import me.yokeyword.fragmentation.SupportFragment;

/**
 *
 * Created by tangjun on 2017/4/1.
 */

public class MainFragment extends ViewModelBaseBindingFragment<IMainFragment,MainFragmentVM,FragmentMainBinding> implements IMainFragment {

    public static MainFragment instance(){
        return new MainFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setTabLayoutViewPager();
        setModelView(this);
    }


    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_main,_mActivity);
    }

    @Override
    public TabLayout getTabLayout() {
        return getBinding().tabLayout;
    }


    @Override
    public ViewPager getViewPager() {
        return getBinding().viewpager;
    }


    @Override
    public FragmentManager getManager() {
        return this.getChildFragmentManager();
    }

    @Override
    public void setTabLayoutViewPager() {
        getViewPager().addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(getTabLayout()));
    }

    @Override
    public void setViewPagerAdapter(FragmentStatePagerAdapter adapter) {
        getViewPager().setAdapter(adapter);
        getTabLayout().setupWithViewPager(getViewPager());
    }

}
