package com.qxy.minitiktok.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.qxy.minitiktok.R;
import com.qxy.minitiktok.base.BaseFragment;
import com.qxy.minitiktok.databinding.FragmentLoginBinding;
import com.qxy.minitiktok.logic.vm.LoginViewModel;
/**
 * 登录fragment
 */
public class LoginFragment extends BaseFragment<LoginViewModel, FragmentLoginBinding> {

    private LoginViewModel mViewModel = model;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    protected Class<LoginViewModel> getViewModelClass() {
        return LoginViewModel.class;
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.fragment_login;
    }
}