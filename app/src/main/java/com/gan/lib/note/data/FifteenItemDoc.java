package com.gan.lib.note.data;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.FifteenWordEntiry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * http://www.15yan.com/topic/bian-ji-tui-jian/
 * Created by tangjun on 2017/3/30.
 */

public class FifteenItemDoc implements IDocument{

    private final static String URL = "http://www.15yan.com/";


    public FifteenItemDoc() {
    }

    /**
     * <ul class="bucket-posts>
     *     <li class="bucket-item">
     *         <div class="post-item clearfix">
     *              <a class="post-item-img">
     *                  <img />
     *              </a>
     *
     *              <div class="post-item-info">
     *                  <a class="post-item-title" href="url">
     *                      <h3>标题</h3>
     *                      <p class="post-item-subtitle">
     *                          <span>副标题</span>
     *                      </p>
     *                  </a>
     *              </div>
     *
     *         </div>
     *     </li>
     *
     *     ...
     * </ul>
     */
    public void getData(){
        mList = new ArrayList<>();

        try {
            Document document = Jsoup.connect("http://www.15yan.com/topic/bian-ji-tui-jian/").get();

            Element item = document.select("ul.bucket-posts").get(0);
            Elements lis = item.select("li.bucket-item");
            for(Element li:lis){

                String img = li.select("img").attr("src");
                String title = li.select("a.post-item-title").attr("title");
                String title_sub = li.select("p.post-item-subtitle").text();
                String userImg = li.select("img.img-circle").attr("src");
                String userName = li.select("a.post-item-author").attr("title");
                String url = URL + li.select("a.post-item-img").attr("href");

                mList.add(new FifteenWordEntiry(img,title,title_sub,userName,userImg,url));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<FifteenWordEntiry> mList;


    public FifteenItemDoc post(final Context context) {
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0){
                    BroadLauncher.sendFifteenItems(context,mList);
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
        return this;
    }

    public List<FifteenWordEntiry> getList() {
        return mList;
    }
}
