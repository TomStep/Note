package com.gan.lib.note;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.gan.lib.frame.base.ViewModelBaseActivity;
import com.gan.lib.note.ui.view.IMainView;
import com.gan.lib.note.viewmodel.activity.MainActivityVM;

public class MainActivity extends ViewModelBaseActivity<IMainView,MainActivityVM> implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //viewpager和tabLayout结合
        setTabLayoutViewPager();
        //把IMainView传给ViewModel
        setModelView(this);
    }

    @Override
    public TabLayout getTabLayout() {
        return (TabLayout)findViewById(R.id.tab_layout);
    }


    @Override
    public ViewPager getViewPager() {
        return (ViewPager)findViewById(R.id.viewpager);
    }


    @Override
    public android.support.v4.app.FragmentManager getManager() {
        return this.getSupportFragmentManager();
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
