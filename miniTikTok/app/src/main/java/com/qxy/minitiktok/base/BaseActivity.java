package com.qxy.minitiktok.base;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.qxy.minitiktok.ActivityCollector;
import com.qxy.minitiktok.BR;
import com.qxy.minitiktok.TokenReceiver;

/**
 * @Classname BaseActivity
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/17 13:56
 */
public abstract class BaseActivity<VM extends ViewModel,VDB extends ViewDataBinding> extends AppCompatActivity {
    //如果不绑定则可以默认传递BaseViewModel
    protected VM model;
    //如果不绑定则可以默认传递BaseViewBinding
    protected VDB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        model = new ViewModelProvider(this).get(getViewModelClass());
    }

    protected abstract Integer getLayoutId();

    protected abstract Class<VM> getViewModelClass();

}
