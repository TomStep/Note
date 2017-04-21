package com.gan.lib.frame.base;

import android.app.Activity;
import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * 本框架需要的app
 * Created by tangjun on 2017/3/13.
 */

public class FrameApplication extends Application {

    private static RefWatcher refWatcher;

    /**
     * 监控fragment小球，可以展示fragment的层级和异常
     *
     * @param isStart   是否开启framentation
     *
     * @param mode  小球显示模式
     *     Fragmentation.BUBBLE
     *     Fragmentation.SHAKE
     *     Fragmentation.NONE
     *
     * @param exceptionHandler  上传错误信息到服务器
     */
    protected void startFragmentation(boolean isStart,int mode,ExceptionHandler exceptionHandler){
        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                //Fragmentation.BUBBLE
                .stackViewMode(mode)
                // ture时，遇到异常："Can not perform this action after onSaveInstanceState!"时，会抛出
                // false时，不会抛出，会捕获，可以在handleException()里监听到
                .debug(isStart)
                // 线上环境时，可能会遇到上述异常，此时debug=false，不会抛出该异常（避免crash），会捕获
                // 建议在回调处上传至我们的Crash检测服务器
                .handleException(exceptionHandler)
                .install();
    }


    public static RefWatcher getRefWatcher(Activity activity){
        if(refWatcher == null){
            LeakCanary.install(activity.getApplication());
        }
        return refWatcher;
    }

    private static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static Application getApplication() {
        return app;
    }
}
