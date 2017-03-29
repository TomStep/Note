package com.gan.lib.frame.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import java.util.UUID;

/**
 *  利用本地广播实现组件之间、模块之间的通信。
 *
 *  注册了广播的地方一定要在onDestroy内注销掉广播。
 *
 * Created by tangjun on 2017/2/20.
 */

public class LocalBroadUtils{

    private final static String STATE_ID = LocalBroadUtils.class.getName()+"state_id";

    /**
     * 获取LocalBroadcastManager实例
     */
    private static LocalBroadcastManager getInstance(Context context){
        return LocalBroadcastManager.getInstance(context);
    }


    private static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, String intentFilter){
        getInstance(context).registerReceiver(broadcastReceiver,new IntentFilter(intentFilter));
    }


    /**
     *  注册多个本地广播
     * @param context 上下文环境
     * @param broadcastReceiver 广播接受者
     * @param intentFilter  多个广播过滤器
     */
    public static void registerReceivers(Context context,BroadcastReceiver broadcastReceiver, String ...intentFilter){
        for (String anIntentFilter : intentFilter) {
            registerReceiver(context, broadcastReceiver, anIntentFilter);
        }
    }

    /**
     * 发送本地广播
     *    自带一个时间标记，用于判断是否重复接数据
     * @param context   上下文环境
     * @param intent    发送的信息
     */
    public synchronized static void sendBroadcast(Context context,Intent intent){
        intent.putExtra(STATE_ID, UUID.randomUUID().toString());
        getInstance(context).sendBroadcast(intent);
    }


    /**
     * 注销本地广播
     * @param context context
     * @param broadcastReceiver broadcastReceiver
     */
    public static void unRegisterReceiver(Context context,BroadcastReceiver broadcastReceiver){
        getInstance(context).unregisterReceiver(broadcastReceiver);
    }


    /**
     * 判断是否重复数据
     * @param intent intent
     * @param lastState 最新的状态
     * @return  返回是否重复，true 为重复
     */
    static boolean IsRepetition(Intent intent, String lastState) {
        return intent.getStringExtra(STATE_ID) == null || intent.getStringExtra(STATE_ID).equals(lastState);
    }

    /**
     *  获取最新标记
     * @param intent intent
     * @return string
     */
    static String getStateId(Intent intent){
        return intent.getStringExtra(STATE_ID);
    }
}
