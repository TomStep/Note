package com.gan.lib.note;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * 自定义setters
 * Created by tangjun on 2017/3/16.
 */

public class CustomSetters {

    /**
     * 加载圆形图片
     * ImageView
     *      circleUrl   : 图片地址
     *      circleError : drawable类型，xml中可以写成 @drawable/xxx
     */
    @BindingAdapter({"circleUrl","circleError"})
    public static void setCircleImg(ImageView view, String url, Drawable error){
        AppUtils.getImageTools().loadImageCircle(view,url,error);
    }

    /**
     * 加载网络图片
     * ImageView
     *      url   : 图片地址
     *      urlError : drawable类型，xml中可以写成 @drawable/xxx
     */
    @BindingAdapter({"url","urlError"})
    public static void setImgfromUrl(ImageView view,String url,Drawable error){
        AppUtils.getImageTools().loadImage(view,url,error);
    }

}
