package com.gan.lib.note.ui.view;

import android.os.Parcelable;
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
     *  加载html代码块
     */
    void loadWebViewData(String content);

    Parcelable getInitData();
}
