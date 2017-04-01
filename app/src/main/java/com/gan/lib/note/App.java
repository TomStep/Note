package com.gan.lib.note;

import com.gan.lib.frame.base.FrameAppliaction;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 *
 * Created by tangjun on 2017/3/14.
 */

public class App extends FrameAppliaction {

    @Override
    public void onCreate() {
        super.onCreate();

        //开启视图球
        startFragmentation(false, Fragmentation.BUBBLE, new ExceptionHandler() {
            @Override
            public void onException(Exception e) {

            }
        });
    }
}
