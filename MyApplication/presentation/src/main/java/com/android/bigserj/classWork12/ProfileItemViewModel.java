package com.android.bigserj.classWork12;


import android.databinding.ObservableField;
import android.util.Log;

import com.android.bigserj.base.BaseItemViewModel;
import com.android.bigserj.domain.entity.ProfileModel;

public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {

    public ObservableField<String> name = new ObservableField<>("");

    @Override
    public void setItem(ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
    }

}