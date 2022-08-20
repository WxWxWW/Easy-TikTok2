package com.qxy.minitiktok;

import android.app.Application;
import android.content.Context;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.qxy.minitiktok.util.LogUtil;

/**
 * @Classname TikTokApplication
 * @Description: 应用全局变量存放处
 * @Created by 康斯坦丁
 * @Date 2022/8/10 15:52
 */
public class TikTokApplication extends Application {

    private static Context context;
    // 需要到开发者网站申请
    private static final String clientKey = "awi8027ob33cpbg7";
    private static final String clientSecret = "654ac0adbeb6adb6d830bc633e7445d0";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.setLogMode(true);
        //初始化DouYinOpenApiFactory

        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

    public static String getClientKey() {
        return clientKey;
    }

    public static String getClientSecret() {
        return clientSecret;
    }
}
