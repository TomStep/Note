package com.gan.lib.note.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentToonsViewerBinding;
import com.gan.lib.note.ui.view.IToonsViewer;
import com.gan.lib.note.view.ProgressWebView;
import com.gan.lib.note.viewmodel.fragment.ToonsViewerVM;

/**
 *
 * Created by tangjun on 2017/4/20.
 */

public class ToonsViewerFragment extends ViewModelBaseBindingFragment<IToonsViewer,ToonsViewerVM,FragmentToonsViewerBinding>
    implements IToonsViewer{

    private final static String TITLE = "title";
    private final static String URL = "url";
    private final static String USERAGENT = "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Mobile Safari/537.36";


    public static ToonsViewerFragment newInstance(String title,String url) {
        Bundle args = new Bundle();
        args.putString(TITLE,title);
        args.putString(URL,url);

        ToonsViewerFragment fragment = new ToonsViewerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_toons_viewer,_mActivity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initToolBar(getToolbar(),getArguments().getString(TITLE));
        initWebView(getWebView());

        setModelView(this);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(final WebView webView){
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setDefaultTextEncodingName("utf-8"); //设置文本编码
        ws.setLoadWithOverviewMode(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式
        ws.setUserAgentString(USERAGENT);
        webView.setWebViewClient(new WebViewClient());
    }


    private void initToolBar(Toolbar toolbar,String title){
        toolbar.setNavigationIcon(com.gan.lib.frame.R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(title);
    }



    @Override
    public Toolbar getToolbar() {
        return getBinding().toolBar;
    }

    @Override
    public ProgressWebView getWebView() {
        return getBinding().webView;
    }

    @Override
    public void loadWebViewData(String url) {
        getWebView().loadUrl(url);
    }

    @Override
    public String getSrcUrl() {
        return getArguments().getString(URL);
    }

}
