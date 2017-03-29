package com.gan.lib.frame.broad;

import android.content.Context;
import android.content.Intent;

/**
 * 通过广播来获取的数据
 * Created by tangjun on 2017/3/13.
 */

public interface OnBroadReceive {


    /**
     * 接收广播数据
     * @param intent  回调的数据
     */
    void onReceive(Context context, Intent intent);
}
