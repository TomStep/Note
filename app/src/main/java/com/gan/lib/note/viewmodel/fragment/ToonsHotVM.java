package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;

import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.note.adapter.ToonsHotAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.ToonsHotDoc;
import com.gan.lib.note.entiry.ToonsHotEntiry;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/12.
 */

public class ToonsHotVM extends RecyclerViewModel {

    private ToonsHotAdapter adapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadLauncher.SEND_TOONS_HOT_ITEMS:
                ArrayList<ToonsHotEntiry> list = BroadLauncher.receiveToonsHotList(intent);
                if(getView() == null){
                    return;
                }

                if(adapter == null) {
                    adapter = new ToonsHotAdapter(list);
                    getView().setRecyclerAdapter(adapter);
                }else {
                    adapter.updateRecycler(list);
                }

                //停止刷新
                getView().setRefreshFinish();
                break;
        }
    }

    @Override
    public void onBindView(@NonNull final IRecyclerView view) {
        super.onBindView(view);

        final ToonsHotDoc toonsHotDoc = new ToonsHotDoc();
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载第一页的数据
                toonsHotDoc.post(view.getViewContext());
            }
        });

        //第一次加载数据：加载第一页的数据
        toonsHotDoc.post(view.getViewContext());
    }


    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_TOONS_HOT_ITEMS,
        };
    }
}
