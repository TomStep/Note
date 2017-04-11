package com.gan.lib.note.broad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.gan.lib.frame.broad.LocalBroadUtils;
import com.gan.lib.note.entiry.EtherItemEntiry;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.entiry.FifteenWordEntiry;
import java.util.ArrayList;


/**
 * 实现广播发送
 * Created by tangjun on 2017/3/15.
 */

public class BroadLauncher implements IBroadLauncher{


    /**
     * 发送fifteenArticle
     */
    public static void sendFifteenWoridEntiry(Context context, FifteenArticleEntiry entiry) {
        Intent intent = new Intent();
        intent.setAction(SEND_FIFTEEN_ARTICLE);
        intent.putExtra(KEY_SEND_FIFTEEN_ARTICLE,entiry);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收fifteenArticle
     */
    public static FifteenArticleEntiry receiveFifteenArticle(Intent intent){
        return (FifteenArticleEntiry)intent.getParcelableExtra(KEY_SEND_FIFTEEN_ARTICLE);
    }


    /**
     * 发送fifteenItems
     */
    public static void sendFifteenItems(Context context, ArrayList<FifteenWordEntiry> list){
        Intent intent = new Intent();
        intent.setAction(SEND_FIFTEEN_ITEMS);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_SEND_FIFTEEN_ITEM,list);
        intent.putExtras(bundle);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收fifteenItems
     */
    public static ArrayList<FifteenWordEntiry> receiveFifteenItems(Intent intent){
        return intent.getParcelableArrayListExtra(KEY_SEND_FIFTEEN_ITEM);
    }


    /**
     * 发送send Fifteen Entiry
     */
    public static void sendFifteenWordToFragment(Context context, FifteenWordEntiry entiry){
        Intent intent = new Intent();
        intent.setAction(SEND_FIFTEEN_ENTIRY);
        intent.putExtra(KEY_START_FIFTEEN_ENTIRY,entiry);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收FifteenWorid
     */
    public static FifteenWordEntiry receiveFifteenWordToFragment(Intent intent){
        return intent.getParcelableExtra(KEY_START_FIFTEEN_ENTIRY);
    }

    /**
     * 发送send ethermetic item entiry
     */
    public static void sendEtherItemEntiry(Context context, ArrayList<EtherItemEntiry> list){
        Intent intent = new Intent();
        intent.setAction(SEND_ETHER_ITEM_ENTIRY);
        intent.putExtra(KEY_SEND_ETHER_ITEM_ENTIRY,list);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收 ethermetic 数据
     */
    public static ArrayList<EtherItemEntiry> receiveEtherItemsEntiry(Intent intent) {
        return intent.getParcelableArrayListExtra(KEY_SEND_ETHER_ITEM_ENTIRY);
    }

    /**
     * 发送ether article 数据
     */
    public static void sendToStartEtherArticle(Context context, EtherItemEntiry entiry){
        Intent intent = new Intent();
        intent.setAction(START_ETHER_ARTICLE_FRAGMENT);
        intent.putExtra(KEY_START_ETHER_ARTICLE_FRAGMENT,entiry);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收开起EthmerticFragment的参数
     */
    public static EtherItemEntiry receiveEtherArticleInfo(Intent intent){
        return intent.getParcelableExtra(KEY_START_ETHER_ARTICLE_FRAGMENT);
    }

    /**
     * 发送ehermetic 文章代码块
     */
    public static void sendEtherArticle(Context context,String url){
        Intent intent = new Intent();
        intent.setAction(SEND_ETEER_ARTICLE);
        intent.putExtra(KEY_SEND_ETEER_ARTICLE,url);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收文章代码块
     */
    public static String getEtherArticleStr(Intent intent){
        return intent.getStringExtra(KEY_SEND_ETEER_ARTICLE);
    }
}
