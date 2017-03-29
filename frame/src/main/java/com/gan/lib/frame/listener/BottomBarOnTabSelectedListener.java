package com.gan.lib.frame.listener;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 *  适配Fragmentation框架使用的底部导航栏监听器
 *      ->  BottomNavigationBar
 *
 * Created by tangjun on 2017/2/23.
 */

public abstract class BottomBarOnTabSelectedListener implements BottomNavigationBar.OnTabSelectedListener {

    private int newPosition;

    @Override
    public void onTabSelected(int position) {
        newPosition = position;
    }

    @Override
    public void onTabUnselected(int position) {
        hasTabSelected(newPosition,position);
        hasTabUnselected(position);
    }

    @Override
    public void onTabReselected(int position) {
        hasTabReselected(position);
    }

    /**
     * 点击按钮
     * @param newPosition   新点击的按钮
     * @param oldPosition   上一个点击的按钮
     */
    public abstract void hasTabSelected(int newPosition,int oldPosition);

    /**
     * 重复点击
     * @param position position
     */
    public abstract void hasTabReselected(int position);


    /**
     * 上一个点击的按钮
     * @param oldPosition oldPosition
     */
    public void hasTabUnselected(int oldPosition){}

}
