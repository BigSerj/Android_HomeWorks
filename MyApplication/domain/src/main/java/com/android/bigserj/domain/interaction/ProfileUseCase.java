package com.android.bigserj.domain.interaction;


import com.android.bigserj.data.entity.Profile;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.interaction.base.UseCase;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ProfileUseCase extends UseCase<ProfileId, ProfileModel>{
    @Override
    protected Observable<ProfileModel> buildUseCase() {

        // тут делаем запрос к слою data в котором вызывается метод на сервере (Rest)

        // создем объект Profile который лежит в data слое
        // это для теста, в будщем этот объект нам вернет слой data
        Profile profile = new Profile();
        profile.setName("Name");
        profile.setSurName("Surname");
        profile.setAge(20);

        // все что выше удалим когда реализуем rest


        return Observable.just(profile)
                .delay(3, TimeUnit.SECONDS)
                .map(new Function<Profile, ProfileModel>() {
            @Override
            public ProfileModel apply(@NonNull Profile profile) throws Exception {

                ProfileModel profileModel = new ProfileModel();

                profileModel.setName(profile.getName());
                profileModel.setSurName(profile.getSurName());
                profileModel.setAge(profile.getAge());

                return profileModel;
            }
        });

    }
}
