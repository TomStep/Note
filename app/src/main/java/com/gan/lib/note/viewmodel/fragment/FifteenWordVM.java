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
import com.gan.lib.note.adapter.FifteenWordRecyclerAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.FifteenItemDoc;
import com.gan.lib.note.entiry.FifteenWordEntiry;
import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordVM extends RecyclerViewModel<IRecyclerView> {

    private FifteenWordRecyclerAdapter adapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(getView() == null) return;

        switch (intent.getAction()){
            case BroadLauncher.SEND_FIFTEEN_ITEMS: //获取items的数据，初始化
                ArrayList<FifteenWordEntiry> list = BroadLauncher.receiveFifteenItems(intent);
                //设置适配器
                if(adapter == null) {
                    adapter = new FifteenWordRecyclerAdapter(list);
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
        //获取document
        final FifteenItemDoc document = new FifteenItemDoc();
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                document.post(view.getViewContext());
            }
        });
        //刷新
        document.post(view.getViewContext());
    }

    /**
     * 输入监听广播的actions
     */
    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_FIFTEEN_ITEMS,
        };
    }

}
