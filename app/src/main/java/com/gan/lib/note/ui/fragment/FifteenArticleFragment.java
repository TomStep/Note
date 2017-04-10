package com.gan.lib.note.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentFifteenArticleBinding;
import com.gan.lib.note.entiry.FifteenWordEntiry;
import com.gan.lib.note.ui.view.IFifteenArticle;
import com.gan.lib.note.view.ProgressWebView;
import com.gan.lib.note.viewmodel.fragment.FifteenArticleVM;

/**
 *
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleFragment
        extends ViewModelBaseBindingFragment<IFifteenArticle,FifteenArticleVM,FragmentFifteenArticleBinding>
        implements IFifteenArticle{

    private static final String KEY_FIFTEEN_ARTICLE = "key_fifteen_article";

    /**
     * 创建一个WebView
     */
    private WebView webView;

    public static FifteenArticleFragment newInstance(FifteenWordEntiry entiry){
        FifteenArticleFragment fragment = new FifteenArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_FIFTEEN_ARTICLE,entiry);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化webView
        initWebView();
        //初始化toolbar相关属性
        initToolbar();

        //设置modelView
        setModelView(this);
        //设置viewModel
        getBinding().setViewModel(getViewModel());
    }


    @Override
    public void onDetach() {
        super.onDetach();
        clearWebViewResource();
    }

    private void initToolbar() {
        //初始化Toolbar
        getToolbar().setNavigationIcon(com.gan.lib.frame.R.drawable.ic_arrow_back_white_24dp);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回
                pop();
            }
        });

        //初始化Collapsing
        getCollapsingTool().setCollapsedTitleTextColor(Color.WHITE);
        getCollapsingTool().setExpandedTitleColor(Color.TRANSPARENT);
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_fifteen_article,getActivity());
    }

    @Override
    public WebView getWebView() {
        if(webView == null) {
            webView = new ProgressWebView(_mActivity);
//            webView.setBackgroundColor(Color.WHITE);
            getNestedScrollView().addView(webView);
        }

        return webView;
    }

    @Override
    public CollapsingToolbarLayout getCollapsingTool() {
        return getBinding().collapsingTool;
    }

    @Override
    public NestedScrollView getNestedScrollView() {
        return getBinding().NestedScrollView;
    }

    @Override
    public Toolbar getToolbar() {
        return getBinding().toolBar;
    }

    @Override
    public void loadWebViewData(String content) {
        getWebView().loadDataWithBaseURL(null,setFifiteenHtml(content),"text/html", "utf-8", null);
    }

    @Override
    public Parcelable getInitData() {
        return getArguments().getParcelable(KEY_FIFTEEN_ARTICLE);
    }

    @Override
    public void clearWebViewResource() {
        if(webView != null){
            webView.removeAllViews();
            ((ViewGroup)webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.clearHistory();
            webView.destroy();
            webView = null;
        }
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


    /**
     *  修改html代码块，添加修改样式
     */
    private String setFifiteenHtml(String url){
        return  "<html>\n" +
                "<head>\n" +
                "<link href=\"http://static.guokr.com/apps/liyan/styles/652f023f.main.css\" rel=\"stylesheet\">\n"+
                "<link href=\"http://static.guokr.com/apps/liyan/styles/8ab5a0a5.story.css\" rel=\"stylesheet\">\n"+
                "<link href=\"http://static.guokr.com/apps/liyan/styles/02cfa342.reply.css\" rel=\"stylesheet\">\n"+
                "<style type=\"text/css\">\n" +
                "\t\t.mClear {margin:0;}\n" +
                "\t</style>"+
                "</head>\n" +
                "<body>\n" +
                "<div class=\"post-content noteClear mClear\">" +
                url +
                "<div>" +
                "</body>\n" +
                "</html>";
    }
}
