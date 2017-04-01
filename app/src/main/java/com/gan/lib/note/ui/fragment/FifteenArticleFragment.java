package com.gan.lib.note.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentFifteenArticleBinding;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.ui.view.IFifteenArticle;
import com.gan.lib.note.viewmodel.fragment.FifteenArticleVM;

/**
 *
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleFragment
        extends ViewModelBaseBindingFragment<IFifteenArticle,FifteenArticleVM,FragmentFifteenArticleBinding>
        implements IFifteenArticle{

    private static final String KEY_FIFTEEN_ARTICLE = "key_fifteen_article";
    public static FifteenArticleFragment newInstance(FifteenArticleEntiry entiry){
        FifteenArticleFragment fragment = new FifteenArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_FIFTEEN_ARTICLE,entiry);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //设置webView
        setWebView();
        setModelView(this);
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_fifteen_article,getActivity());
    }

    @Override
    public WebView getWebView() {
        return getBinding().webView;
    }

    @Override
    public void loadWebViewData(String content) {
        getWebView().loadDataWithBaseURL(null,setFifiteenHtml(content),"text/html", "utf-8", null);
    }

    @Override
    public Parcelable getInitData() {
        return getArguments().getParcelable(KEY_FIFTEEN_ARTICLE);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setWebView(){
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
                "<link rel=\"stylesheet\" href=\"http://bdimg.share.baidu.com/static/api/css/share_style0_16.css?v=6aba13f0.css\">"+
                "<style type=\"text/css\">\n" +
                "\t\t.mClear {margin:0;}\n" +
                "\t</style>"+
                "</head>\n" +
                "<body>\n" +
                "<div class=\"post-content noteClear mClear\">"+ url +
                "<div>" +
                "</body>\n" +
                "</html>";
    }
}
