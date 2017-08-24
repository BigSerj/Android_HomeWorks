package com.android.bigserj.homeWork11;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.bigserj.base.BaseAdapter;
import com.android.bigserj.classWork12.ProfileItemViewHolder;
import com.android.bigserj.classWork12.ProfileItemViewModel;
import com.android.bigserj.domain.entity.ProfileModel;


public class ProfileAdapterHW11 extends BaseAdapter<ProfileModel, ProfileItemViewModelHW11> {

    @Override
    public ProfileItemViewHolderHW11 onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModelHW11 itemViewModel = new ProfileItemViewModelHW11();
        return ProfileItemViewHolderHW11.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
