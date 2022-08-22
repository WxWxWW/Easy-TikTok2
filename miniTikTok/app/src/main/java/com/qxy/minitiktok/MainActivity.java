package com.qxy.minitiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.qxy.minitiktok.ui.fragment.VideoFragment;
import com.qxy.minitiktok.ui.fragment.LoginFragment;


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

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.layout_carrier,LoginFragment.newInstance());
        transaction.add(R.id.layout_carrier, VideoFragment.newInstance());
    }

}