package com.android.bigserj.classwork9;


import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.AsyncTask;
import android.util.Log;

import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.classwork8.ClassWork8Activity;
import com.android.bigserj.domain.entity.Profile;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.interaction.ProfileUseCase;

public class ClassWork9ViewModel implements BaseViewModel{

    public Activity activity;
    public ClassWork9ViewModel(Activity activity) {
        this.activity = activity;
    }

    public enum STATE {PROGRESS, DATA}

    public ObservableField name = new ObservableField();
    public ObservableField surname = new ObservableField();
    public ObservableInt age = new ObservableInt(0);
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);


    private ProfileUseCase useCase = new ProfileUseCase();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        ProfileId profileId = new ProfileId();
        profileId.setId("123");// это для теста, как будто у нас есть id пользователя

        Profile profile = useCase.execute(profileId);

        name.set(profile.getName());
        surname.set(profile.getSurName());
        age.set(profile.getAge());

        state.set(STATE.DATA);

    }

    @Override
    public void pause() {
    }
}
