package com.android.bigserj.homeWork13;


import android.app.Activity;
import android.databinding.ObservableField;
import com.android.bigserj.base.BaseViewModel;

public class HomeWork13ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;

    public HomeWork13ViewModel(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {




    }

    @Override
    public void pause() {

    }

}