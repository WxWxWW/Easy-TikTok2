package com.qxy.minitiktok.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qxy.minitiktok.R;
import com.qxy.minitiktok.base.BaseFragment;
import com.qxy.minitiktok.databinding.FragmentHomeBinding;
import com.qxy.minitiktok.logic.vm.HomeViewModel;

public class HomeFragment extends BaseFragment<HomeViewModel, FragmentHomeBinding> {

    private HomeViewModel mViewModel = model;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected Class<HomeViewModel> getViewModelClass() {
        return HomeViewModel.class;
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}