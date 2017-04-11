package com.gan.lib.note.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentEthermeticArticleBinding;
import com.gan.lib.note.ui.view.IEthermeticArticle;
import com.gan.lib.note.view.ProgressWebView;
import com.gan.lib.note.viewmodel.fragment.EthermeticArticleVM;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EthermeticArticleFragment
        extends ViewModelBaseBindingFragment<IEthermeticArticle,EthermeticArticleVM,FragmentEthermeticArticleBinding>
    implements  IEthermeticArticle{

    private final static String TOOL_BAR_TITLE = "tool_bar_title";
    private final static String WEB_VIEW_URL = "web_view_url";

    private ProgressWebView webView;


    public static ViewModelBaseBindingFragment newInstance(String title,String url){
        EthermeticArticleFragment fragment = new EthermeticArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TOOL_BAR_TITLE,title);
        bundle.putString(WEB_VIEW_URL,url);

        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initWebView();
        initToolbar();

        //初始化参数
        setToolbarTitle(getArguments().getString(TOOL_BAR_TITLE));
        setModelView(this);
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_ethermetic_article,_mActivity);
    }

    @Override
    public WebView getWebView() {
        if(webView == null) {
            webView = new ProgressWebView(_mActivity);
            getBinding().linearLayout.addView(webView);
        }

        return webView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        clearWebViewResource();
    }

    @Override
    public android.support.v7.widget.Toolbar getToolbar() {
        return getBinding().toolBar;
    }

    @Override
    public void loadWebView(String url) {
        getWebView().loadDataWithBaseURL(null,setHtml(url),"text/html", "utf-8", null);
    }

    @Override
    public void setToolbarTitle(String title) {
        getToolbar().setTitle(title);
    }

    @Override
    public String getWebViewUrl() {
        return getArguments().getString(WEB_VIEW_URL);
    }


    private void clearWebViewResource() {
        if(webView != null){
            webView.removeAllViews();
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.clearHistory();
            webView.destroy();
            webView = null;
        }
    }


    private void initToolbar() {
        getToolbar().setTitleTextColor(Color.WHITE);
        getToolbar().setNavigationIcon(com.gan.lib.frame.R.drawable.ic_arrow_back_white_24dp);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(){
//        getWebView().setWebViewClient(new WebViewClient());
        WebSettings ws = getWebView().getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setDefaultTextEncodingName("utf-8"); //设置文本编码
        ws.setLoadWithOverviewMode(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式
    }

    private String setHtml(String url) {
        return url;
    }
}
