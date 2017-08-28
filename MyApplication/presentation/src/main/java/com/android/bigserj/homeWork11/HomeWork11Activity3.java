package com.android.bigserj.homeWork11;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.Activity3Homework11Binding;

public class HomeWork11Activity3 extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        HomeWork11ViewModel3 viewModel = new HomeWork11ViewModel3(this);
        this.viewModel = viewModel;

        Activity3Homework11Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity3_homework11);

        binding.setViewModel(viewModel);


        super.onCreate(savedInstanceState);

    }

}
