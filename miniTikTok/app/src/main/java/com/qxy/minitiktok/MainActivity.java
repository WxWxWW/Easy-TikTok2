package com.qxy.minitiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;

import com.qxy.minitiktok.ui.activity.LoginActivity;


/**
 * @Classname MainActivity
 * @Description: 应用入口
 * @Created by 康斯坦丁
 * @Date 2022/8/10 15:52
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}