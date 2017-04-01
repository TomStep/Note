package com.gan.lib.note.data;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * http://www.15yan.com/topic/bian-ji-tui-jian/2VZwtTfZ9N3/ ?
 *
 *
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleDoc implements IDocument {


    private String url;
    private FifteenArticleEntiry entiry;

    public FifteenArticleDoc(String url) {
        this.url = url;
    }

    /**
     *  <div class="story-cover-image" data-bg_img="url">
     *      <h1 class="post-title">标题</h1>
     *      <h2 class="post-subtitle">副标题</h2>
     *  </div>
     *
     *  <div class="noteable post-body" id="noteArea" >
     *      ...代码块
     *  </div>
     *
     */
    @Override
    public void getData() {
        try {
            Document document = Jsoup.connect(url).get();

            if(document.select("div.story-cover-image").size() != 0) {
                String img = document.select("div.story-cover-image").attr("data-bg_img");
                String title = document.select("h1.post-title").text();
                String title_sub = document.select("h2.post-subtitle").text();
                String article = document.select("div.post-body").toString();
                entiry = new FifteenArticleEntiry(title,title_sub,img,article);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void post(final Context context){
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0){
                    //发送数据
                    BroadLauncher.SendFifteenArticle(context,new Intent(),entiry);
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                getData();
                mHandler.sendEmptyMessage(0);
            }
        }).start();
    }


    public FifteenArticleEntiry getEntiry() {
        return entiry;
    }
}
