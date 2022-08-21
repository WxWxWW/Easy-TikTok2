package com.qxy.minitiktok;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.qxy.minitiktok.util.LogUtil;
import com.qxy.minitiktok.util.SpUtil;

/**
 * @Classname TikTokApplication
 * @Description: 应用全局变量存放处
 * @Created by 康斯坦丁
 * @Date 2022/8/10 15:52
 */
public class TikTokApplication extends Application {

    private static Context context;
    // 需要到开发者网站申请


    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.setLogMode(true);
        //初始化DouYinOpenApiFactory
        context = getApplicationContext();
        //判断是否为第一次使用该app
    }

    public static Context getContext(){
        return context;
    }

}
