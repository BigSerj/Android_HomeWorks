package com.android.bigserj.homeWork10;


import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableLong;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class HomeWork10ViewModel implements BaseViewModel {

    Disposable disposable;

    public Activity activity;

    public HomeWork10ViewModel(Activity activity) {
        this.activity = activity;
    }

    public ObservableLong count = new ObservableLong();

    Observable<Long> values;

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        values = Observable.interval(2000, TimeUnit.MILLISECONDS);

        disposable = values
                .observeOn(AndroidSchedulers.mainThread())  // нужно выполнить в потоке UI
                .subscribeOn(Schedulers.newThread())  // где выполнить observable
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong%2==0;
                    }
                })
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(@NonNull Long s) {
                        count.set(s);
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

        disposable.dispose();

    }
}
