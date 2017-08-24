package com.android.bigserj.classWork12;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.bigserj.base.BaseAdapter;
import com.android.bigserj.domain.entity.ProfileModel;


public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {

    @Override
    public ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
