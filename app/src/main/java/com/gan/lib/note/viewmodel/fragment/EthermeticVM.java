package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.View;

import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.note.adapter.EthermeticRecyclerAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.EtherItemDoc;
import com.gan.lib.note.entiry.EtherItemEntiry;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EthermeticVM extends RecyclerViewModel {

    private EthermeticRecyclerAdapter mAdapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadLauncher.SEND_ETHER_ITEM_ENTIRY:
                if(getView() == null){
                    return;
                }

                ArrayList<EtherItemEntiry> list = BroadLauncher.receiveEtherItemsEntiry(intent);

                if(list != null && mAdapter == null){   //初始化adapter
                    mAdapter = new EthermeticRecyclerAdapter(list);
                    getView().setRecyclerAdapter(mAdapter);

                }else { //刷新数据
                    mAdapter.updateRecycler(list);
                }
                //停止刷新
                getView().setRefreshFinish();
                break;
        }
    }

    @Override
    public void onBindView(@NonNull final IRecyclerView view) {
        super.onBindView(view);
        final EtherItemDoc document = new EtherItemDoc();
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载第一页的数据
                document.post(view.getViewContext(),1);
            }
        });

        //第一次加载数据：加载第一页的数据
        document.post(view.getViewContext(), 1);
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_ETHER_ITEM_ENTIRY,
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter = null;
    }

    /**
     * items的点击事件
     * @param view view
     */
    @BindingAdapter({"etherClick"})
    public static void setOnClickItems(final CardView view, final EtherItemEntiry entiry){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadLauncher.sendToStartEtherArticle(v.getContext(),entiry);
            }
        });
    }
}
