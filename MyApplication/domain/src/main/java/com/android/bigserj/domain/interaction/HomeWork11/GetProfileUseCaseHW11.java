package com.android.bigserj.domain.interaction.HomeWork11;



import com.android.bigserj.data.entity.Profile;
import com.android.bigserj.data.net.RestService;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfileUseCaseHW11 extends UseCase<String, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase(String profileId) {
        return RestService
                .getInstance()
                .getProfile(profileId)
                .map(new Function<Profile, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull Profile profileThis) throws Exception {
                        ProfileModel profileModel = new ProfileModel();

                        profileModel.setName(profileThis.getName());
                        profileModel.setSurName(profileThis.getSurName());
                        profileModel.setAge(profileThis.getAge());

                        return profileModel;
                    }
                });
    }
}
