package com.android.bigserj.homeWork9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.ActivityHomework9Binding;


public class HomeWork9Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        HomeWork9ViewModel viewModel = new HomeWork9ViewModel(this);
        this.viewModel = viewModel;

        ActivityHomework9Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_homework9);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);



    }
}
