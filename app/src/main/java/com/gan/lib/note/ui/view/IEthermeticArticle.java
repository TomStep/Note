package com.gan.lib.note.ui.view;

import android.support.v7.widget.Toolbar;
import android.webkit.WebView;


import com.gan.lib.frame.viewmodel.IView;

public interface IEthermeticArticle extends IView {

    /**
     * 获取web view控件
     */
    WebView getWebView();


    /**
     * 获取Toolbar
     */
    Toolbar getToolbar();


    /**
     * 加载webview代码块
     */
    void loadWebView(String url);

    /**
     * 设置toolbar标题
     */
    void setToolbarTitle(String title);

    /**
     * 获取加载代码块的Url
     */
    String getWebViewUrl();
}
