package com.gan.lib.frame.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import com.gan.lib.frame.R;
import com.gan.lib.frame.image.transformation.GlideCircleTransform;
import com.gan.lib.frame.image.transformation.GlideRoundTransform;

import net.qiujuer.genius.blur.StackBlur;

/**
 *
 * Created by tangjun on 2017/3/15.
 */

public class ImageHelper implements ImageTools {

    private static ImageHelper imageHelper;

    private ImageHelper(){}

    public static ImageHelper instance(){
        if(imageHelper == null){
            synchronized (ImageHelper.class){
                if(imageHelper == null){
                    imageHelper = new ImageHelper();
                }
            }
        }
        return imageHelper;
    }

    public void loadImage(ImageView imageView,String url){
        Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
    }

    @Override
    public void loadImage(ImageView image, String image_url, Drawable drawable) {
        Glide.with(image.getContext()).load(image_url).placeholder(drawable).centerCrop().crossFade().error(drawable).into(image);
    }

    @Override
    public void loadImageLoading(Context context, BaseTarget<Bitmap> baseTarget, String image_url) {
        Glide.with(context).load(image_url).asBitmap().into(baseTarget);
    }

    @Override
    public void loadImageThumbnail(ImageView image, String image_url) {
        Glide.with(image.getContext()).load(image_url).thumbnail(0.1f).into(image);
    }

    @Override
    public void loadImageHolder(ImageView image, String image_url, int success_image, int error_image) {
        Glide.with(image.getContext()).load(image_url).placeholder(success_image).error(error_image).into(image);
    }

    @Override
    public void loadImageRound(ImageView imageView, String image_url) {
        Glide.with(imageView.getContext()).load(image_url).transform(new GlideRoundTransform(imageView.getContext())).crossFade().into(imageView);
    }

    @Override
    public void loadImageCircle(ImageView imageView, String image_url, Drawable error) {
        Glide.with(imageView.getContext())
                .load(image_url)
                .placeholder(error)
                .crossFade()
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void loadImageCircle(ImageView imageView, int image_id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            imageView.setBackground(getDrawable(imageView.getContext(), R.drawable.base_image_loop_solid_circle));
        }
        Glide.with(imageView.getContext()).load(image_id).crossFade().transform(new GlideCircleTransform(imageView.getContext())).into(imageView);
    }

    @Override
    public void loadImageBlur(final ImageView imageView, final int radius, String image_url) {
        Glide.with(imageView.getContext()).load(image_url)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setImageBitmap(StackBlur.blurNativelyPixels(resource, radius, true));
                    }
                });
    }

    @Override
    public void loadImageBlur(final ImageView imageView, final int radius, int id) {
        Glide.with(imageView.getContext()).load(id)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setImageBitmap(StackBlur.blurNativelyPixels(resource, radius, true));
                    }
                });
    }

    @Override
    public void loadImageDefaultBlur(final ImageView imageView, String image_url) {
        Glide.with(imageView.getContext()).load(image_url)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setImageBitmap(StackBlur.blurNativelyPixels(resource, 8, true));
                    }
                });
    }


    /**
     * 从网络获取图片，并放在textview中
     */
    @Override
    public void loadImage2TextTop(String url, final TextView view) {
        Glide.with(view.getContext()).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(resource);
                bitmapDrawable.setBounds(0,0,bitmapDrawable.getMinimumWidth(),bitmapDrawable.getMinimumHeight());
                view.setCompoundDrawables(null,bitmapDrawable,null,null);
            }
        });
    }


    /**
     * 使用时配合setOnClickListener
     */
    @Override
    public void setJumpAuto(final View view) {
        // Create a system to run the physics loop for a set of springs.
        SpringSystem springSystem = SpringSystem.create();
        // Add a spring to the system.
        final Spring spring = springSystem.createSpring();
        // Add a listener to observe the motion of the spring.
        spring.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                // You can observe the updates in the spring
                // state by asking its current value in onSpringUpdate.
                float value = (float) spring.getCurrentValue();
                float scale = 1f - (value * 0.5f);
                view.setScaleX(scale);
                view.setScaleY(scale);
            }
        });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // When pressed startFragment solving the spring to 0.5.
                        spring.setEndValue(0.3);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // When released startFragment solving the spring to 0.
                        spring.setEndValue(0);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void loadGIF(ImageView imageView, String image_url) {
        Glide.with(imageView.getContext()).load(image_url).asGif().into(imageView);
    }

    /**
     * 从资源图片中获取Drawable
     */
    public static Drawable getDrawable(Context context,int id) {
        return context.getResources().getDrawable(id);
    }
}
