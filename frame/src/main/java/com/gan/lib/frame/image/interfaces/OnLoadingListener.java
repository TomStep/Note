package com.gan.lib.frame.image.interfaces;

public interface OnLoadingListener {

    //开始加载
    void onLoadingStart();

    //加载成功
    void onLoadingSuccess();

    //加载失败
    void onLoadingFail(Exception e);
}
