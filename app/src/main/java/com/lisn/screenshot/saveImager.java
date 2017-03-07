package com.lisn.screenshot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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


public class saveImager {
    /**
     * 保存图片到本地文件夹 路径：/mnt/sdcard/Lishan/ 当前时间.jpg
     * @param bmp
     */
    public static void saveImage(Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "Lishan");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存图片到本地文件夹，并保存到相册中
     * @param context
     * @param bmp
     */
    public static void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片到本地文件夹 路径：/mnt/sdcard/Lishan/ 当前时间.jpg
        File appDir = new File(Environment.getExternalStorageDirectory(), "Lishan");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        String path = Environment.getExternalStorageDirectory().getPath()+File.separator+"Lishan";
//        Log.e(TAG, "saveImageToGallery: "+path );
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" +  path)));

        //我们可以通过下面的代码看出每个应用程序最高可用内存是多少。

        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
//        Log.e("TAG", "Max memory is " + maxMemory + "KB");
    }
}
