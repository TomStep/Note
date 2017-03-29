package com.gan.lib.frame.image.transformation;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.gan.lib.frame.image.interfaces.OnLoadingListener;

/**
 *
 * Created by tangjun on 2016/10/20.
 */
public class setLoadTarget extends SimpleTarget<Bitmap> {

    private ImageView imageView;
    private OnLoadingListener loading;

    public setLoadTarget(ImageView imageView) {
        this.imageView = imageView;
    }

    public setLoadTarget(ImageView imageView, OnLoadingListener loading) {
        this.imageView = imageView;
        this.loading = loading;
    }

    @Override
    public void onLoadStarted(Drawable placeholder) {
        if(loading != null) {
            loading.onLoadingStart();
        }
        super.onLoadStarted(placeholder);
    }

    @Override
    public void onLoadFailed(Exception e, Drawable errorDrawable) {
        if(loading != null) {
            loading.onLoadingFail(e);
        }
        super.onLoadFailed(e, errorDrawable);
    }

    @Override
    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
        if(loading != null) {
            loading.onLoadingSuccess();
        }

        if(imageView != null) {
            imageView.setImageBitmap(resource);
        }
    }


    public ImageView getImageView() {
        return imageView;
    }

    public OnLoadingListener getLoading() {
        return loading;
    }
}
