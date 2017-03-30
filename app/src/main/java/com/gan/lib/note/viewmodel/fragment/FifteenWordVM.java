package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.adapter.FifteenWordRecyclerAdapter;
import com.gan.lib.note.data.FifteenDocument;
import com.gan.lib.note.entiry.FifteenWordEntiry;

import java.util.List;

/**
 *
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordVM extends RecyclerViewModel {

    private FifteenDocument document;
    private FifteenWordRecyclerAdapter adapter;

    @Override
    public void onReceive(Context context, Intent intent) {

    }


    @Override
    public void onBindView(@NonNull final IRecyclerView view) {
        super.onBindView(view);
        //获取document
        document = new FifteenDocument()
                .setOnDataListening(new FifteenDocument.OnDataBackListener() {
                    @Override
                    public void onDataListener(List<FifteenWordEntiry> list) {

                        //设置适配器
                        if(adapter == null) {
                            adapter = new FifteenWordRecyclerAdapter(list);
                            view.setRecyclerAdapter(adapter);
                        }else {
                            adapter.updateRecycler(list);
                        }
                        //停止刷新
                        view.setRefreshFinish();
                    }
                });


        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                document.post();
            }
        });

        //刷新
        document.post();
    }
}
