package com.qxy.minitiktok.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.qxy.minitiktok.R;
import com.qxy.minitiktok.base.BaseFragment;
import com.qxy.minitiktok.databinding.FragmentLoginBinding;
import com.qxy.minitiktok.databinding.FragmentVideoBinding;
import com.qxy.minitiktok.logic.vm.ListViewModel;

/**
 * 榜单数据展示fragment
 */
public class VideoFragment extends BaseFragment<ListViewModel, FragmentVideoBinding> {

    private ListViewModel mViewModel = model;

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected Class<ListViewModel> getViewModelClass() {
        return ListViewModel.class;
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.fragment_video;
    }
}