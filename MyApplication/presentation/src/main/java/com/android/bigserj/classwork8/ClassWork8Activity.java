package com.android.bigserj.classwork8;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.ActivityClasswork8Binding;

public class ClassWork8Activity extends BaseActivity {

    public static void show(Activity activity){
        Intent intent = new Intent(activity, ClassWork8Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ClassWork8ViewModel viewModel = new ClassWork8ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork8Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_classwork8);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }
}