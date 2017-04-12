package com.gan.lib.note.data;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.ToonsHotEntiry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 咚漫热门榜
 * Created by tangjun on 2017/4/12.
 */

public class ToonsHotDoc {

    private ArrayList<ToonsHotEntiry> mList;
    private Handler mHandler;

    protected void getData(){
        mList = new ArrayList<>();

        try {
            Document document = Jsoup.connect("http://www.webtoons.com/zh-hans/top?rankingGenre=ALL")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
                    .get();

            Elements lis = document
                    .select("ul.lst_type1").get(0)
                    .select("li");

            for(Element li : lis){
                String url = li.select("a").get(0).attr("href");
                String img = li.select("img").get(0).attr("src");
                String tag = li.select("p.genre").text();
                String title = li.select("p.subj").text();
                String author = li.select("p.author").text();

                mList.add(new ToonsHotEntiry(url,img,tag,title,author));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<ToonsHotEntiry> getList(){
        return mList;
    }

    public void post(final Context context){
        //发送数据
        if(mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0) {
                        //发送数据
                        BroadLauncher.sendToonsHotList(context,mList);
                    }
                }
            };
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                getData();
                mHandler.sendEmptyMessage(0);
            }
        }).start();

    }

}
