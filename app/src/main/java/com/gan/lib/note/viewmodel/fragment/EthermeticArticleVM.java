package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.EthermeticArticleDoc;
import com.gan.lib.note.ui.view.IEthermeticArticle;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EthermeticArticleVM extends AbstractViewModel<IEthermeticArticle> {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadLauncher.SEND_ETEER_ARTICLE:
                if(getView() == null){
                    return;
                }

                getView().loadWebView(BroadLauncher.getEtherArticleStr(intent));

                break;
        }

    }


    @Override
    public void onBindView(@NonNull IEthermeticArticle view) {
        super.onBindView(view);

        //获取webview代码块
        new EthermeticArticleDoc().post(view.getViewContext(),view.getWebViewUrl());
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_ETEER_ARTICLE
        };
    }
}
