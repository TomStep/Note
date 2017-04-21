package com.gan.lib.note.data;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.ToonsBookEntiry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookDoc {


    private ArrayList<ToonsBookEntiry> mList;
    private Handler mHandler;

    /**
     * 判断是否是最后一页
     */
    private boolean isFinal=false;

    /**
     * 获取数据，判断当前是查询或下滑到下一页。若查询，则判断不是最后一页。
     * @param url   url
     * @param isSearch  是否在查询
     */
    protected void getData(String url,boolean isSearch){
        mList = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
                    .get();

            Elements lis = document.select("div.detail_lst")
                    .select("ul").select("li");

            for(Element li : lis){
                String a_url = li.select("a").attr("href");
                String img = li.select("span.thmb").select("img").attr("src");
                String title = li.select("span.subj").get(0).text();
                String date = li.select("span.date").text();
                String like = li.select("span._likeitArea").text().replace("like","");
                String tx = li.select("span.tx").text();

                if(!isFinal) {
                    mList.add(new ToonsBookEntiry(img, title, date, like, tx, a_url));
                }

                if("#1".equals(tx) && !isSearch) isFinal = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void post(final Context context, final String url, final boolean isSearch){
        //发送数据
        if(mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0) {
                        //发送数据
                        BroadLauncher.sendToonsBooksList(context,getList());
                    }
                }
            };
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                getData(url,isSearch);
                mHandler.sendEmptyMessage(0);
            }
        }).start();
    }

    /**
     * 默认下滑
     */
    public void post(final Context context,final String url){
        //发送数据
        if(mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0) {
                        //发送数据
                        BroadLauncher.sendToonsBooksList(context,getList());
                    }
                }
            };
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                getData(url,false);
                mHandler.sendEmptyMessage(0);
            }
        }).start();
    }


    public ArrayList<ToonsBookEntiry> getList() {
        return mList;
    }
}
