package com.gan.lib.note;

import com.gan.lib.frame.image.ImageHelper;
import com.gan.lib.frame.image.ImageTools;

/**
 *  工具类
 * Created by tangjun on 2017/3/15.
 */

class AppUtils {

    /**
     * 获取image工具类
     */
    static ImageTools getImageTools(){
        return ImageHelper.instance();
    }

}
