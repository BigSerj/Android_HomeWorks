package com.android.bigserj.classwork9;


import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.interaction.old.ProfileUseCase;
import com.android.bigserj.domain.interaction.old.SaveProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class ClassWork9ViewModel implements BaseViewModel{


    public Activity activity;
    public ClassWork9ViewModel(Activity activity) {
        this.activity = activity;
    }

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> surname = new ObservableField<>();
    public ObservableInt age = new ObservableInt(0);


    private ProfileUseCase useCase = new ProfileUseCase();
    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        ProfileModel profileModel = new ProfileModel();
        profileModel.setAge(27);
        profileModel.setName("NameBB");
        profileModel.setSurName("SNameBB");
        saveProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAA","OK");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA","error = ",e);
            }

            @Override
            public void onComplete() {

            }
        });




        ProfileId profileId = new ProfileId();
        profileId.setId("123");// это для теста, как будто у нас есть ID_NUMBER пользователя

        // сделали подписку на получение информации
        useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name.set(profile.getName());
                surname.set(profile.getSurName());
                age.set(profile.getAge());

                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });







    }

    @Override
    public void pause() {

        useCase.dispose();
        saveProfileUseCase.dispose();

    }
}
