package com.qxy.minitiktok.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.qxy.minitiktok.R;
import com.qxy.minitiktok.base.BaseFragment;
import com.qxy.minitiktok.databinding.FragmentPersonBinding;
import com.qxy.minitiktok.logic.vm.PersonViewModel;

public class PersonFragment extends BaseFragment<PersonViewModel,FragmentPersonBinding> {

    private PersonViewModel mViewModel = model;

    public static PersonFragment newInstance() {
        return new PersonFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    protected Class<PersonViewModel> getViewModelClass() {
        return PersonViewModel.class;
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.fragment_person;
    }
}