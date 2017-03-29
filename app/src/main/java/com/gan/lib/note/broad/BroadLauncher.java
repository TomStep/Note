package com.gan.lib.note.broad;

import android.content.Context;
import android.content.Intent;

import com.gan.lib.frame.broad.LocalBroadUtils;

/**
 * 实现广播发送
 * Created by tangjun on 2017/3/15.
 */

public class BroadLauncher implements IBroadLauncher{

    private static BroadLauncher broadLauncher;
    private BroadLauncher() {}

    public static IBroadLauncher instance(){
        if(broadLauncher == null){
            synchronized (BroadLauncher.class){
                if(broadLauncher == null) {
                    broadLauncher = new BroadLauncher();
                }
            }
        }

        return broadLauncher;
    }

}
