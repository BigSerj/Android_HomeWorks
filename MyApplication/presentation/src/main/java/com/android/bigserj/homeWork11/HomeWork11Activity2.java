package com.android.bigserj.homeWork11;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.Activity2Homework11Binding;


public class HomeWork11Activity2 extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        HomeWork11ViewModel2 viewModel = new HomeWork11ViewModel2(this);
        this.viewModel = viewModel;

        Activity2Homework11Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity2_homework11);


        binding.setViewModel(viewModel);


        super.onCreate(savedInstanceState);

    }
}
