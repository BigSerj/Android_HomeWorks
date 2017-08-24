package com.android.bigserj.homeWork11;


import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.android.bigserj.base.BaseItemViewModel;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.entity.ProfileModel;

public class ProfileItemViewModelHW11 extends BaseItemViewModel<ProfileModel> {

    public ObservableField<String> name = new ObservableField<>("");


    @Override
    public void setItem(ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());

    }

}