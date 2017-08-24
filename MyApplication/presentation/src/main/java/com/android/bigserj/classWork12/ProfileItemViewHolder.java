package com.android.bigserj.classWork12;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.bigserj.base.BaseItemViewHolder;
import com.android.bigserj.databinding.ItemProfileBinding;
import com.android.bigserj.domain.entity.ProfileModel;

public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        ProfileItemViewModel, ItemProfileBinding> {

    public ProfileItemViewHolder(ItemProfileBinding binding, ProfileItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel) {
        ItemProfileBinding binding = ItemProfileBinding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}
