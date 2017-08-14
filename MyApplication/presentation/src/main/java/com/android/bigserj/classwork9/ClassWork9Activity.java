package com.android.bigserj.classwork9;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.ActivityClasswork9Binding;

public class ClassWork9Activity extends BaseActivity{

    public static void show(Activity activity){
        Intent intent = new Intent(activity, ClassWork9Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ClassWork9ViewModel viewModel = new ClassWork9ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork9Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_classwork9);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }
}
