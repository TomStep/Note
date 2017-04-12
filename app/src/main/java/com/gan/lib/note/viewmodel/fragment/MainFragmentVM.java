package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.adapter.MainViewPagerAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.EtherItemEntiry;
import com.gan.lib.note.factory.MainViewPagerFragmentFactory;
import com.gan.lib.note.ui.fragment.EthermeticArticleFragment;
import com.gan.lib.note.ui.fragment.FifteenArticleFragment;
import com.gan.lib.note.ui.view.IMainFragment;
import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/1.
 */

public class MainFragmentVM extends AbstractViewModel<IMainFragment> {

    private MainViewPagerAdapter mAdapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(getView() == null) return;

        switch (intent.getAction()){
            case BroadLauncher.SEND_FIFTEEN_ENTIRY:
                //开启FifteenArticleFragment
                getView().startFragment(FifteenArticleFragment
                        .newInstance(BroadLauncher.receiveFifteenWordToFragment(intent)));
                break;

            case BroadLauncher.START_ETHER_ARTICLE_FRAGMENT:
                EtherItemEntiry entiry = BroadLauncher.receiveEtherArticleInfo(intent);
                if(entiry != null) {
                    getView().startFragment(EthermeticArticleFragment.newInstance(entiry.getTitle(),entiry.getUrl()));
                }
                break;
        }
    }

    @Override
    public void onBindView(@NonNull IMainFragment view) {
        super.onBindView(view);
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
//            list.add(MainViewPagerFragmentFactory.MainFragments.Ethermetic);
            list.add(MainViewPagerFragmentFactory.MainFragments.ToonsHot);

            mAdapter = new MainViewPagerAdapter(manager, list);
        }
        return mAdapter;
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_FIFTEEN_ENTIRY,
                BroadLauncher.START_ETHER_ARTICLE_FRAGMENT,
        };
    }


}
