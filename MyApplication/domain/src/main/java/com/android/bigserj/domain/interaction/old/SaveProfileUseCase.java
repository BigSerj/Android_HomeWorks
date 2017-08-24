package com.android.bigserj.domain.interaction.old;


import com.android.bigserj.data.entity.Profile;
import com.android.bigserj.data.net.RestService;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.base.UseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class SaveProfileUseCase extends UseCase<ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {


        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurName(param.getSurName());
        profileData.setAge(param.getAge());

        return RestService.getInstance().saveProfile(profileData);


    }
}
