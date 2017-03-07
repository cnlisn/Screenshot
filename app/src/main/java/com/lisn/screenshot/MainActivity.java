package com.lisn.screenshot;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
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
public class MainActivity extends ActionBarActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GlobalScreenshot screenshot = new GlobalScreenshot(this);
        //后面的两个boolean参数是表示是否有状态栏，用于显示不同的淡出动画，如果有一个为false，就会直接淡出，而不会向上偏移到状态栏上。
        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenshot.takeScreenshot(getWindow().getDecorView(), new Runnable() {
                    @Override
                    public void run() {

                    }
                }, true, true);
            }
        });
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
