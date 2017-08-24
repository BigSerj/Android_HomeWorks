package com.android.bigserj.classWork12;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseActivity;
import com.android.bigserj.databinding.ActivityClasswork12Binding;

public class ClassWork12Activity extends BaseActivity{

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, ClassWork12Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        ClassWork12ViewModel viewModel = new ClassWork12ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork12Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_classwork12);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.profileAdapter);

        super.onCreate(savedInstanceState);
    }

}
