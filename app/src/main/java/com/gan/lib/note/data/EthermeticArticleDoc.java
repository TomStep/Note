package com.gan.lib.note.data;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.gan.lib.note.broad.BroadLauncher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EthermeticArticleDoc {

    private String mHtml;
    private Handler mHandler;

    protected void getData(String url){

        try {
            Document document = Jsoup.connect(url)
                    .header("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Mobile Safari/537.36")
                    .get();

            Element element = document.select("div.entry-inner").get(0);
            mHtml = element.text();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected String getHtml(){
        return mHtml;
    }

    public void post(final Context context, final String url){
        //发送数据
        if(mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0) {
                        //发送数据
                        BroadLauncher.sendEtherArticle(context,mHtml);
                    }
                }
            };
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                getData(url);
                mHandler.sendEmptyMessage(0);
            }
        }).start();
    }
}
