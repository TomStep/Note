package com.gan.lib.note.ui.view;

import android.support.v7.widget.Toolbar;
import com.gan.lib.frame.viewmodel.IView;
import com.gan.lib.note.view.ProgressWebView;

/**
 *
 * Created by tangjun on 2017/4/20.
 */

public interface IToonsViewer extends IView{

    Toolbar getToolbar();

    ProgressWebView getWebView();

    void loadWebViewData(String url);

    String getSrcUrl();
}
