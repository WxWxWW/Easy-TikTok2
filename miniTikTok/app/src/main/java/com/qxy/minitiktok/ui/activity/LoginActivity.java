package com.qxy.minitiktok.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.qxy.minitiktok.R;
import com.qxy.minitiktok.base.BaseActivity;
import com.qxy.minitiktok.base.BaseViewModel;
import com.qxy.minitiktok.databinding.ActivityLoginBinding;

/**
 * @Classname LogicActivity
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/21 16:06
 */
public class LoginActivity extends BaseActivity<BaseViewModel, ActivityLoginBinding> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected Class<BaseViewModel> getViewModelClass() {
        return BaseViewModel.class;
    }
}
