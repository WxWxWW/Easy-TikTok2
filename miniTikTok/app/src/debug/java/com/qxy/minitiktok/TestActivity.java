package com.qxy.minitiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

/**
 * 在这里测试代码
 */
public class TestActivity extends AppCompatActivity {

    DouYinOpenApi douYinOpenApi;
    //_000x1h1XxYLVWBfbhPeCo4iTZUeBo16aFV2
    //_000x1h1XxYLVWBfbhPeCo4iTZUeBo16aFV2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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