package com.gan.lib.frame.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 *  添加一个标记，防止接收多次数据
 * Created by tangjun on 2017/2/22.
 */

public class LocalBroadReceiver extends BroadcastReceiver{

    //标记
    private String mLastState;

    //接收广播回调
    private OnBroadReceive mBroadReceive;

    public LocalBroadReceiver(OnBroadReceive broadReceive) {
        this.mBroadReceive = broadReceive;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(LocalBroadUtils.IsRepetition(intent,mLastState)){
            Log.d("LocalBroadReceiver","LocalBroadReceiver --> 重复调用");
            return;
        }

        if(null == mBroadReceive){
            throw new NullPointerException("this not implements OnBroadReceive ");
        }

        mBroadReceive.onReceive(context,intent);

        mLastState = LocalBroadUtils.getStateId(intent);
    }


    public void setBroadReceive(OnBroadReceive mBroadReceive) {
        this.mBroadReceive = mBroadReceive;
    }
}
