package com.android.bigserj.homeWork11;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.ActivityHomework11Binding;

import java.util.ArrayList;


public class HomeWork11Activity extends BaseActivity{

    public static void show(Activity activity){
        Intent intent = new Intent(activity, HomeWork11Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        HomeWork11ViewModel viewModel = new HomeWork11ViewModel(this);
        this.viewModel = viewModel;

        ActivityHomework11Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_homework11);

        binding.setViewModel(viewModel);
        binding.homeWork11RW.setLayoutManager(new LinearLayoutManager(this));
        binding.homeWork11RW.setAdapter(viewModel.profileAdapter);


        super.onCreate(savedInstanceState);



    }
}
