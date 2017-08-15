package com.android.bigserj.homeWork10;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.ActivityHomework10Binding;

public class HomeWork10Activity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        HomeWork10ViewModel viewModel = new HomeWork10ViewModel(this);
        this.viewModel = viewModel;

        ActivityHomework10Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_homework10);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
