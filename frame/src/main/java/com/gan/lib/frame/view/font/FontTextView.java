package com.gan.lib.frame.view.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * TextView字体修改
 * Created by tangjun on 2016/11/14.
 */
public class FontTextView extends TextView {
    public FontTextView(Context context) {
        super(context);
        fontInit(context);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fontInit(context);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        fontInit(context);
    }

    private void fontInit(Context context) {
        setTypeface(TypefaceHelper.instance(context).getTypeface());
    }
}
