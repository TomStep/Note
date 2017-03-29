package com.gan.lib.frame.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *  常用的加载布局方法
 * Created by tangjun on 2017/2/23.
 */

public class FrameUtils {

    /**
     * 添加一个布局文件
     * @param viewGroup 附着的根控件
     * @param layoutRes 布局文件
     * @return view
     */
    public static View LayoutInflater(ViewGroup viewGroup,int layoutRes){
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutRes, viewGroup, false);
    }

    /**
     * 获取LayoutInflater
     * @param viewGroup viewGroup
     */
    public static LayoutInflater getLayoutInflater(ViewGroup viewGroup){
        return LayoutInflater.from(viewGroup.getContext());
    }

    /**
     * 获取android SDK version
     * @return 返回版本号
     */
    public static int getVersion(){
        return android.os.Build.VERSION.SDK_INT;
    }

}
