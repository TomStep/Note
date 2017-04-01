package com.gan.lib.note.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.note.databinding.FragmentMainBinding;
import com.gan.lib.note.ui.view.IMainFragment;
import com.gan.lib.note.viewmodel.fragment.MainFragmentVM;

/**
 * Created by tangjun on 2017/4/1.
 */

public class MainFragment extends ViewModelBaseBindingFragment<IMainFragment,MainFragmentVM,FragmentMainBinding> implements IMainFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setModelView(this);
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
        return this.getFragmentManager();
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
