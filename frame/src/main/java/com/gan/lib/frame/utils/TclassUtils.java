package com.gan.lib.frame.utils;

import java.lang.reflect.ParameterizedType;

/**
 *  获取T.class的方法
 * Created by tangjun on 2017/2/22.
 */

public class TclassUtils<T> {

    public Class<T> getInside(){
        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
