package com.gan.lib.note.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.gan.lib.note.R;
/**
 *  带有进度条的webview
 * Created by tangjun on 2017/4/10.
 */

public class ProgressWebView extends WebView {

    private ProgressBar mProgressBar;

    private boolean isStartTime = false;
    private int mProgressMax;

    public ProgressWebView(Context context) {
        this(context,null);
    }

    public ProgressWebView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mProgressBar = new ProgressBar(context, null,
                android.R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 10);
        mProgressBar.setLayoutParams(layoutParams);

        Drawable drawable = context.getResources().getDrawable(
                R.drawable.web_progress_bar_states);
        mProgressBar.setProgressDrawable(drawable);
        addView(mProgressBar);
        setWebChromeClient(new WebChromeClient());
    }



    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {

            if (mProgressBar.getVisibility() == GONE) {
                mProgressBar.setVisibility(VISIBLE);
                mProgressMax = 0;
                isStartTime =false;
            }

            if(newProgress > 90 && !isStartTime){
                ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", 20, 90).setDuration(1500);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(mProgressMax == 100){
                            mProgressBar.setProgress(mProgressMax);
                            mProgressBar.setVisibility(GONE);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                isStartTime = true;
            }else {
                mProgressBar.setProgress(20);
            }

            if(newProgress >= 100){
                mProgressMax = 100;
            }


            super.onProgressChanged(view, newProgress);
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

}
