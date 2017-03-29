package com.gan.lib.note.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.factory.MainViewPagerFragmentFactory;

import java.util.List;

/**
 * 建立main viewpager的adapter
 *
 * Created by tangjun on 2017/3/29.
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<MainViewPagerFragmentFactory.MainFragments> mListEnum;

    public MainViewPagerAdapter(FragmentManager fm, List<MainViewPagerFragmentFactory.MainFragments> listEnum) {
        super(fm);
        this.mListEnum = listEnum;
    }

    @Override
    public Fragment getItem(int position) {
        return MainViewPagerFragmentFactory.getInstance().getFragment(mListEnum.get(position));
    }

    @Override
    public int getCount() {
        return mListEnum.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListEnum.get(position).getTitle();
    }


    /**
     * 更新fragment排布顺序
     * @param mListEnum list
     */
    public void updateFragmentOrder(List<MainViewPagerFragmentFactory.MainFragments> mListEnum) {
        this.mListEnum = mListEnum;
        this.notifyDataSetChanged();
    }
}
