package com.android.bigserj.domain.interaction.old;


import com.android.bigserj.data.entity.Profile;
import com.android.bigserj.data.net.RestService;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.interaction.base.UseCase;

import org.reactivestreams.Subscription;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {
    @Override
    protected Observable<ProfileModel> buildUseCase(ProfileId profileId) {

        // тут делаем запрос к слою data в котором вызывается метод на сервере (Rest)
        // создем объект Profile который лежит в data слое
        // это для теста, в будщем этот объект нам вернет слой data
//        Profile profile = new Profile();
//        profile.setName("Name");
//        profile.setSurName("Surname");
//        profile.setAge(20);
        // все что выше удалим когда реализуем rest

        return RestService
                .getInstance()
                .getProfiles()
                .map(new Function<List<Profile>, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull List<Profile> profileList) throws Exception {

                        Profile profileData = profileList.get(0);

                        ProfileModel profileModel = new ProfileModel();

                        profileModel.setName(profileData.getName());
                        profileModel.setSurName(profileData.getSurName());
                        profileModel.setAge(profileData.getAge());

                        return profileModel;
                    }
                });
    }
}
