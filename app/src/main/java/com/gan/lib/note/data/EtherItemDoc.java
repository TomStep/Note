package com.gan.lib.note.data;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.EtherItemEntiry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 获取ethermetic的数据
 * Created by tangjun on 2017/4/11.
 */

public class EtherItemDoc {

    private static final String URL = "http://www.ethermetic.com/page/";
    private ArrayList<EtherItemEntiry> mList;
    private Handler mHandler;

    protected void getData(int index) {
        mList = new ArrayList<>();

        if(index == 0){
            return;
        }

        String url = URL +index;

        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Mobile Safari/537.36")
                    .get();
            Element element = document.select("div.post-list").get(0);
            Elements postRows = element.select("div.post-row");

            for(Element postRow :postRows){
                Elements articles = postRow.select("article");

                for(Element article :articles){
                    Element thumbnail = article.select("div.post-thumbnail").get(0);
                    Element meta = article.select("div.post-meta").get(0);

                    String article_url = thumbnail.select("a").get(0).attr("href");
                    String article_title = thumbnail.select("a").get(0).attr("title");
                    String article_img = thumbnail.select("img").attr("src");
                    String tag_url = meta.select("a").get(0).attr("href");
                    String tag_name = meta.select("a").get(0).text();
                    String time = meta.select("time").get(0).text();

                    mList.add(new EtherItemEntiry(article_url, article_title, article_img, tag_url, tag_name, time));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<EtherItemEntiry> getList() {
        return mList;
    }

    public void post(final Context context, final int index){
        //发送数据
        if(mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0) {
                        //发送数据
                        BroadLauncher.sendEtherItemEntiry(context,getList());
                    }
                }
            };
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                getData(index);
                mHandler.sendEmptyMessage(0);
            }
        }).start();
    }
}
