package com.android.bigserj.homeWork11;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.bigserj.base.BaseItemViewHolder;
import com.android.bigserj.classWork12.ProfileItemViewModel;
import com.android.bigserj.databinding.ItemProfileBinding;
import com.android.bigserj.databinding.ItemProfileHw11Binding;
import com.android.bigserj.domain.entity.ProfileModel;

public class ProfileItemViewHolderHW11 extends BaseItemViewHolder<ProfileModel,
        ProfileItemViewModelHW11, ItemProfileHw11Binding> {

    public ProfileItemViewHolderHW11(ItemProfileHw11Binding binding, ProfileItemViewModelHW11 viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolderHW11 create(LayoutInflater inflater, ViewGroup parent,
                                                   ProfileItemViewModelHW11 viewModel) {
        ItemProfileHw11Binding binding = ItemProfileHw11Binding.inflate(inflater, parent, false);
        return new ProfileItemViewHolderHW11(binding, viewModel);
    }
}
