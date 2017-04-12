package com.gan.lib.note;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义setters
 * Created by tangjun on 2017/3/16.
 */

public class CustomSetters {

    /**
     * 加载圆形图片
     * ImageView
     *      circleUrl   : 图片地址
     *      circleError : drawable类型，xml中可以写成 @{@drawable/ic_launcher}
     */
    @BindingAdapter({"circleUrl","circleError"})
    public static void setCircleImg(ImageView view, String url, Drawable error){
        AppUtils.getImageTools().loadImageCircle(view,url,error);
    }

    /**
     * 加载网络图片
     * ImageView
     *      url   : 图片地址
     *      urlError : drawable类型，xml中可以写成 @{@drawable/ic_launcher}
     */
    @BindingAdapter({"url","error"})
    public static void setImgFromUrl(ImageView view, String url, Drawable error){
        AppUtils.getImageTools().loadImage(view,url,error);
    }

    /**
     * 加载网络图片
     * ImageView
     *      url   : 图片地址
     *      urlError : drawable类型，xml中可以写成 @{@drawable/ic_launcher}
     *      refer : 请求头
     */
    @BindingAdapter({"url","refer","error"})
    public static void setImgFromUrl(ImageView view, String url, final String refer, Drawable error){
        Headers headers = new Headers() {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> header = new HashMap<>();
                header.put("Referer", refer);
                return header;
            }
        };
        GlideUrl glideUrl = new GlideUrl(url,headers);
        AppUtils.getImageTools().loadImage(view,glideUrl,error);
    }

}
