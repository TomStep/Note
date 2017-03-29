package com.gan.lib.note.viewmodel.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.adapter.MainViewPagerAdapter;
import com.gan.lib.note.factory.MainViewPagerFragmentFactory;
import com.gan.lib.note.ui.view.IMainView;

import java.util.ArrayList;

/**
 * main Activity View Model
 * Created by tangjun on 2017/3/29.
 */

public class MainActivityVM extends AbstractViewModel<IMainView> {

    private MainViewPagerAdapter mAdapter;

    @Override
    public void onReceive(Context context, Intent intent) {

    }

    @Override
    public void onBindView(@NonNull IMainView view) {
        super.onBindView(view);

        LogUtils.d("执行了嘛？");

        //设置适配器
        view.setViewPagerAdapter(getAdapter(view.getManager()));
    }


    /**
     * 获取适配器实例
     * @param manager FragmentManager
     * @return FragmentPagerAdapter
     */
    private FragmentStatePagerAdapter getAdapter(FragmentManager manager){
        if(mAdapter == null) {
            ArrayList<MainViewPagerFragmentFactory.MainFragments> list = new ArrayList<>();

            list.add(MainViewPagerFragmentFactory.MainFragments.FifteenWord);

            mAdapter = new MainViewPagerAdapter(manager, list);
        }
        return mAdapter;
    }
}
