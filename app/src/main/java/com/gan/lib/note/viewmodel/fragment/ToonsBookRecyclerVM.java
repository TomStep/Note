package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;

import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.note.adapter.ToonsBookAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.ToonsBookDoc;
import com.gan.lib.note.entiry.ToonsBookEntiry;
import com.gan.lib.note.entiry.ToonsHotEntiry;
import com.gan.lib.note.ui.view.IToonsBookRecycler;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookRecyclerVM extends RecyclerViewModel<IToonsBookRecycler>{

    private int mPage = 1;
    private ToonsBookAdapter mAdapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadLauncher.SEND_TOONS_BOOKS_ENTIRY:
                ArrayList<ToonsBookEntiry> entiries = BroadLauncher.receiveToonsBooksList(intent);
                if(entiries != null & getView() != null){
                    if(mAdapter == null) {
                        mAdapter = new ToonsBookAdapter(entiries);
                        getView().setRecyclerAdapter(mAdapter);
                    }else {
                        mAdapter.updateRecycler(entiries);
                    }
                    //停止刷新
                    getView().setRefreshFinish();
                }

                break;
        }

    }

    @Override
    public void onBindView(@NonNull final IToonsBookRecycler view) {
        super.onBindView(view);

        final ToonsBookDoc bookDoc = new ToonsBookDoc();

        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载第一页的数据
                bookDoc.post(view.getViewContext(),view.getUrl(mPage));
            }
        });

        bookDoc.post(view.getViewContext(),view.getUrl(1));
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_TOONS_BOOKS_ENTIRY,
        };
    }


}
