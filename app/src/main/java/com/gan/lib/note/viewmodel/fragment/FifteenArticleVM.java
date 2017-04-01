package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.entiry.FifteenArticleEntiry;
import com.gan.lib.note.ui.view.IFifteenArticle;

/**
 *
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleVM extends AbstractViewModel<IFifteenArticle> {

    private FifteenArticleEntiry mData;

    @Override
    public void onReceive(Context context, Intent intent) {

    }

    @Override
    public void onBindView(@NonNull IFifteenArticle view) {
        super.onBindView(view);
        mData = (FifteenArticleEntiry) view.getInitData();

        view.loadWebViewData(mData.getArticle());
    }


}
