package com.gan.lib.note.broad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.gan.lib.frame.broad.LocalBroadUtils;
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
    public static void SendFifteenArticle(Context context,Intent intent, FifteenArticleEntiry entiry) {
        intent.setAction(SEND_FIFTEEN_ARTICLE);
        intent.putExtra(KEY_FIFTEEN_ARTICLE,entiry);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收fifteenArticle
     */
    public static FifteenArticleEntiry receiveFifteenArticle(Context context, Intent intent){
        return (FifteenArticleEntiry)intent.getParcelableExtra(KEY_FIFTEEN_ARTICLE);
    }


    /**
     * 发送fifteenItems
     */
    public static void SendFifteenItems(Context context, Intent intent, ArrayList<FifteenWordEntiry> list){
        intent.setAction(SEND_FIFTEEN_ITEMS);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_FIFTEEN_ITEM,list);
        intent.putExtras(bundle);
        LocalBroadUtils.sendBroadcast(context,intent);
    }

    /**
     * 接收fifteenItems
     */
    public static ArrayList<FifteenWordEntiry> receiveFifteenItems(Context context,Intent intent){
        return intent.getParcelableArrayListExtra(KEY_FIFTEEN_ITEM);
    }

}
