package com.android.bigserj.classWork12;


import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.GetProfileListUseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class ClassWork12ViewModel implements BaseViewModel{

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;

    public ClassWork12ViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfileListUseCase getProfileListUseCase = new GetProfileListUseCase();

    public ProfileAdapter profileAdapter = new ProfileAdapter();


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getProfileListUseCase.execute(null, new DisposableObserver<List<ProfileModel>>(){

            @Override
            public void onNext(List<ProfileModel> profileModels) {
                profileAdapter.setItems(profileModels);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAAA items = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("AAAA item", "onComplete");
            }
        });




    }

    @Override
    public void pause() {

    }
}
