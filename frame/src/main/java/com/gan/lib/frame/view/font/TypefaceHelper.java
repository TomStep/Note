package com.gan.lib.frame.view.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * 修改字体帮助类
 * Created by tangjun on 2016/11/14.
 */

public class TypefaceHelper {
    private static final String TAG = "TypefaceHelper";

    private final static String PATH = "fonts/SYFZLTKHJW.TTF";

    private static TypefaceHelper mTypefaceHelper;

    private static Typeface mTypeface;

    public static TypefaceHelper instance(Context context){
        synchronized (TypefaceHelper.class){
            if(mTypefaceHelper == null){
                mTypefaceHelper = new TypefaceHelper();
                try {
                    mTypefaceHelper.mTypeface = Typeface.createFromAsset(context.getAssets(), PATH);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get mTypeface '" + PATH
                            + "' because " + e.getMessage());
                    return null;
                }
            }
            return mTypefaceHelper;
        }
    }

    public Typeface getTypeface(){
        if(mTypefaceHelper == null){
            throw new NullPointerException("mTypefaceHelper == null,first instance()");
        }
        return mTypefaceHelper.mTypeface;
    }
}
