package com.android.bigserj.domain.interaction.HomeWork11;


import com.android.bigserj.data.entity.Profile;
import com.android.bigserj.data.net.RestService;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.base.UseCase;

import io.reactivex.Observable;

public class EditProfileUseCaseHomeWork11 extends UseCase<ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {


        Profile profileData = new Profile();

        profileData.setName(param.getName());
        profileData.setSurName(param.getSurName());
        profileData.setAge(param.getAge());
        profileData.setId(param.getId());

        return RestService.getInstance().editProfile(profileData);


    }
}
