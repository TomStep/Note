package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.adapter.MainViewPagerAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.EtherItemEntiry;
import com.gan.lib.note.entiry.ToonsHotEntiry;
import com.gan.lib.note.factory.MainViewPagerFragmentFactory;
import com.gan.lib.note.ui.fragment.EthermeticArticleFragment;
import com.gan.lib.note.ui.fragment.FifteenArticleFragment;
import com.gan.lib.note.ui.fragment.ToonsBooksFragment;
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
            //开启十五言的fragment
            case BroadLauncher.SEND_FIFTEEN_ENTIRY:
                //开启FifteenArticleFragment
                getView().startInIView(FifteenArticleFragment
                        .newInstance(BroadLauncher.receiveFifteenWordToFragment(intent)));
                break;

            //开启EtherArticle的fragment
            case BroadLauncher.START_ETHER_ARTICLE_FRAGMENT:
                EtherItemEntiry entiry = BroadLauncher.receiveEtherArticleInfo(intent);
                if(entiry != null) {
                    getView().startInIView(EthermeticArticleFragment.newInstance(entiry.getTitle(),entiry.getUrl()));
                }
                break;

            case BroadLauncher.ONCLICK_TOONSHOT_ITEAM:
                ToonsHotEntiry toonsHotEntiry = BroadLauncher.receiveToonsHotListFromOnClickItems(intent);
                if(toonsHotEntiry != null){
                    getView().startInIView(ToonsBooksFragment.newInstance(toonsHotEntiry.getTitle(),toonsHotEntiry.getUrl()));
                }
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

            list.add(MainViewPagerFragmentFactory.MainFragments.ToonsHot);
            list.add(MainViewPagerFragmentFactory.MainFragments.FifteenWord);
//            list.add(MainViewPagerFragmentFactory.MainFragments.Ethermetic);

            mAdapter = new MainViewPagerAdapter(manager, list);
        }
        return mAdapter;
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_FIFTEEN_ENTIRY,
                BroadLauncher.START_ETHER_ARTICLE_FRAGMENT,
                BroadLauncher.ONCLICK_TOONSHOT_ITEAM,
        };
    }
}
