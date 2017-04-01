package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.note.adapter.FifteenWordRecyclerAdapter;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.FifteenArticleDoc;
import com.gan.lib.note.data.FifteenItemDoc;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.entiry.FifteenWordEntiry;
import com.gan.lib.note.ui.fragment.FifteenArticleFragment;

import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordVM extends RecyclerViewModel {

    private FifteenItemDoc document;
    private FifteenWordRecyclerAdapter adapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(getView() == null) return;

        switch (intent.getAction()){
            case BroadLauncher.SEND_FIFTEEN_ITEMS: //获取items的数据，初始化
                ArrayList<FifteenWordEntiry> list = BroadLauncher.receiveFifteenItems(context, intent);
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
            case BroadLauncher.SEND_FIFTEEN_ARTICLE: //获取单个数据，并跳转新页面
                FifteenArticleEntiry entiry = BroadLauncher.receiveFifteenArticle(context, intent);

//                getView().startFragment(TestFragment.newInstance());

                break;
        }

    }


    @Override
    public void onBindView(@NonNull final IRecyclerView view) {
        super.onBindView(view);
        //获取document
        document = new FifteenItemDoc();
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
                BroadLauncher.SEND_FIFTEEN_ARTICLE
        };
    }

    /**
     * items的点击事件
     * @param view view
     */
    @BindingAdapter({"fifteenClick"})
    public static void setOnClickItems(final CardView view, final String url){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FifteenArticleDoc(url).post(view.getContext());
            }
        });
    }
}
