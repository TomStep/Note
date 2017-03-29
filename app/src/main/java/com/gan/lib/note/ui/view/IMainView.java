package com.gan.lib.note.ui.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.gan.lib.frame.viewmodel.IView;
import android.support.v4.app.FragmentManager;

/**
 *
 * Created by tangjun on 2017/3/29.
 */

public interface IMainView extends IView{


    /**
     * 获取TabLayout的实例
     */
    TabLayout getTabLayout();

    /**
     * 获取viewPager的实例
     */
    ViewPager getViewPager();

    /**
     * 获取fragment Manager
     */
    FragmentManager getManager();

    /**
     *  ViewPager和TabLayout一站式管理Tab
     */
    void setTabLayoutViewPager();


    /**
     *  配置viewPager Adapter
     */
    void setViewPagerAdapter(FragmentStatePagerAdapter adapter);
}
