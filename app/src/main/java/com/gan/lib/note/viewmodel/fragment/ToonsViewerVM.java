package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.ui.view.IToonsViewer;

/**
 *
 * Created by tangjun on 2017/4/20.
 */

public class ToonsViewerVM extends AbstractViewModel<IToonsViewer>{
    @Override
    public void onReceive(Context context, Intent intent) {}


    @Override
    public void onBindView(@NonNull IToonsViewer view) {
        super.onBindView(view);

        view.loadWebViewData(view.getSrcUrl());
    }
}
