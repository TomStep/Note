package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;

import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.frame.view.recycler.AutoLoadRecyclerView;
import com.gan.lib.note.adapter.ToonsBookAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.ToonsBookDoc;
import com.gan.lib.note.entiry.ToonsBookEntiry;
import com.gan.lib.note.entiry.ToonsHotEntiry;
import com.gan.lib.note.ui.fragment.ToonsViewerFragment;
import com.gan.lib.note.ui.view.IToonsBookRecycler;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookRecyclerVM extends RecyclerViewModel<IToonsBookRecycler>{

    private int mPage;
    private ToonsBookAdapter mAdapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(null == getView()){
            return;
        }

        switch (intent.getAction()){
            case BroadLauncher.SEND_TOONS_BOOKS_ENTIRY:
                ArrayList<ToonsBookEntiry> entiries = BroadLauncher.receiveToonsBooksList(intent);
                if(entiries != null){
                    if(mAdapter == null) {
                        mAdapter = new ToonsBookAdapter(entiries);
                        getView().setRecyclerAdapter(mAdapter);
                    }else if(1 == mPage){//刷新
                        mAdapter.updateRecycler(entiries);
                    }else {//上拉加载更多
                        mAdapter.addDate(entiries);
                        //允许继续上拉加载
                        getView().setLoadMoreContinue();
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

        //下拉刷新
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载第一页的数据
                mPage = 1;
                bookDoc.post(view.getViewContext(),view.getUrl(mPage));
            }
        });

        view.setLoadingMoreListener(new AutoLoadRecyclerView.onLoadMoreListener() {
            @Override
            public void loadMore() {
                mPage += 1;
                bookDoc.post(view.getViewContext(),view.getUrl(mPage));
            }
        });


        mPage = 1;
        bookDoc.post(view.getViewContext(),view.getUrl(mPage));
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_TOONS_BOOKS_ENTIRY,
        };
    }


}
