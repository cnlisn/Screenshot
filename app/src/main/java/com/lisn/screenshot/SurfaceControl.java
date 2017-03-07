package com.lisn.screenshot;

import android.graphics.Bitmap;
import android.view.View;

/**
 * ****************************
 * 项目名称：Screenshot
 * 创建人：LiShan
 * 邮箱：cnlishan@163.com
 * 创建时间：2016/12/12
 * 版权所有违法必究
 * <p>
 * ****************************
 */
public class SurfaceControl {

    public static Bitmap screenshot(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        return bmp;
    }
}
