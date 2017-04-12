package com.gan.lib.frame.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.target.BaseTarget;

/**
 * 图片处理工具
 * Created by tangjun on 2017/3/15.
 */

public interface ImageTools {


    void loadImage(ImageView imageView,String url);

    //加载图片
    void loadImage(ImageView image, String image_url, Drawable drawable);

    void loadImage(ImageView imageView, GlideUrl url,Drawable drawable);

    //加载图片显示loading
    void loadImageLoading(Context context, BaseTarget<Bitmap> baseTarget, String image_url);

    //加载图片设置缩略图支持
    void loadImageThumbnail(ImageView image, String image_url);

    //加载图片设置加载中和加载失败
    void loadImageHolder(ImageView image, String image_url, int success_image, int error_image);

    //加载图片设置圆角图片
    void loadImageRound(ImageView imageView, String image_url);

    //加载图片设置圆形图片
    void loadImageCircle(ImageView imageView, String image_url,Drawable error);

    //加载图片设置圆形图片
    void loadImageCircle(ImageView imageView, int image_id);

    //加载图片设置模糊效果
    void loadImageBlur(ImageView imageView, int radius, String image_url);

    //加载图片设置模糊效果
    void loadImageBlur(ImageView imageView, int radius, int id);

    //加载图片设置模糊效果
    void loadImageDefaultBlur(final ImageView imageView, String image_url);

    //加载网络图片，并放在textview上
    void loadImage2TextTop(String url, TextView view);

    //设置点击动态跳动效果
    void setJumpAuto(View view);

    //加载GIF图
    void loadGIF(ImageView imageView, String image_url);
}
