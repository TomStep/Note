package com.gan.lib.note.ui.view;

import android.os.Parcelable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.gan.lib.frame.viewmodel.IView;

/**
 *
 * Created by tangjun on 2017/3/31.
 */

public interface IFifteenArticle extends IView{


    /**
     *  获取webView
     */
    WebView getWebView();

    /**
     *  获取CollapsingToolbarLayout
     */
    CollapsingToolbarLayout getCollapsingTool();

    /**
     *  获取NestedScrollView
     */
    NestedScrollView getNestedScrollView();

    /**
     *  获取Toolbar
     */
    Toolbar getToolbar();

    /**
     *  加载html代码块
     */
    void loadWebViewData(String content);

    /**
     * 传递数据给viewModel
     */
    Parcelable getInitData();

    /**
     * 清除webView的资源和引用
     */
    void clearWebViewResource();
}
