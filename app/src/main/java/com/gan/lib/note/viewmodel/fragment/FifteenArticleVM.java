package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.FifteenArticleDoc;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.entiry.FifteenWordEntiry;
import com.gan.lib.note.ui.view.IFifteenArticle;

/**
 *
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleVM extends AbstractViewModel<IFifteenArticle> {

    private String toolImgUrl;
    private String toolTitle;
    private IFifteenArticle mView;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case BroadLauncher.SEND_FIFTEEN_ARTICLE:
                if(mView == null){
                    return;
                }

                //加载Html代码块
                FifteenArticleEntiry data = BroadLauncher.receiveFifteenArticle(intent);
                if(data != null && data.getArticle() != null){
                    mView.loadWebViewData(data.getArticle());
                }
                break;
        }
    }

    @Override
    public void onBindView(@NonNull IFifteenArticle view) {
        super.onBindView(view);
        mView = view;

        FifteenWordEntiry data = (FifteenWordEntiry) view.getInitData();

        //绑定数据
        setViewModelData(data);
        //加载网页数据
        new FifteenArticleDoc(data.getUrl()).post(view.getViewContext());
    }

    private void setViewModelData(FifteenWordEntiry data) {
        //添加图片
        toolImgUrl = data.getImgUrl();
        //添加标题
        toolTitle = data.getTitle();
    }

    /********** 绑定在UI上 *************/

    public String getToolImgUrl() {
        return toolImgUrl.replace("small","preface");
    }

    public String getToolTitle() {
        if(toolTitle.length() <= 11){
            return toolTitle;
        }
        return toolTitle.substring(0,11) + "...";
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_FIFTEEN_ARTICLE,
        };
    }

    @Override
    public void onDestroy() {
        if(mView != null){
            mView = null;
        }
        super.onDestroy();
    }
}
