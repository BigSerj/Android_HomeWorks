package com.android.bigserj.homeWork7;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.databinding.ActivityHomework7Binding;

public class HomeWork7Activity extends Activity {

    public ObservableField<User> newUser = new ObservableField<>();
    private String inmgUrl = "http://s4.storage.akamai.coub.com/get/b88/p/coub/simple/cw_timeline_pic/c0ce61faf68/84fc2c3d374d0a19ed258/med_1411107592_image.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHomework7Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework7);

        User user = new User(inmgUrl,"ПотомуЧтоНеБудетВашегоИтальянскогоСыра", "Ахахахаха!!!!", 30, true);
        binding.setPerson(this);
        newUser.set(user);
    }
}
