package com.qxy.minitiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.minitiktok.util.SpUtil;

/**
 * 在这里测试代码
 */
public class TestActivity extends AppCompatActivity {

    DouYinOpenApi douYinOpenApi;
    //_000x1h1XxYLVWBfbhPeCo4iTZUeBo16aFV2
    //_000x1h1XxYLVWBfbhPeCo4iTZUeBo16aFV2
    private static boolean isFirst = true;
    private static long tokenFailureTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        if(SpUtil.contains(this,"isFirst")){
            isFirst = (boolean) SpUtil.get(this,"isFirst",false);
            tokenFailureTime = (Long)SpUtil.get(this, "tokenFailureTime", -1L);
            //超过规定时间，则启动授权页面
            if(tokenFailureTime > System.currentTimeMillis())
                startActivity(new Intent(this,ViewActivity.class));
        }else {
            SpUtil.put(this, "isFirst", !isFirst);
        }
        String clientkey = "awi8027ob33cpbg7"; // 需要到开发者网站申请并替换
        findViewById(R.id.btn_authorize).setOnClickListener((v) -> {
            DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
            douYinOpenApi = DouYinOpenApiFactory.create(this);
            Authorization.Request request = new Authorization.Request();
            request.scope = "user_info,fans.list,trial.whitelist,following.list,video.list,video.data";
            request.callerLocalEntry = "com.qxy.minitiktok.douyindemo.CallbackActivity";
            douYinOpenApi.authorize(request);
        });
    }
}