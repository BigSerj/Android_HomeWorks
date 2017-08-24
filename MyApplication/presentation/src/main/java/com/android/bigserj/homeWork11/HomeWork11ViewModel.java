package com.android.bigserj.homeWork11;


import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.HomeWork11.GetAllProfilesUseCaseHW11;
import com.android.bigserj.domain.interaction.HomeWork11.GetProfileUseCaseHW11;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class HomeWork11ViewModel implements BaseViewModel{


    public Activity activity;
    public HomeWork11ViewModel(Activity activity) {
        this.activity = activity;
    }


    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);


    private GetAllProfilesUseCaseHW11 getAllProfilesUseCase = new GetAllProfilesUseCaseHW11();

    public ProfileAdapterHW11 profileAdapter = new ProfileAdapterHW11();


    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        getAllProfilesUseCase.execute(null,new DisposableObserver<List<ProfileModel>>(){

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

        getAllProfilesUseCase.dispose();

    }
}
