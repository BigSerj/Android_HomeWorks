package com.android.bigserj.homeWork4;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.bigserj.R;
import com.android.bigserj.main.MainActivity;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class HomeWork4Activity extends Activity {

    Disposable disposable;


    //  ------------ дополнение не из ДЗ (вставлено позже на уроке)
    public PublishSubject<String> publishSubject = PublishSubject.create();
    public BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
    public ReplaySubject<String> replaySubject = ReplaySubject.create();
    //  ------------

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);

    //  ------------ дополнение не из ДЗ (вставлено позже на уроке)
        publishSubject.onNext("Одни");
        publishSubject.onNext("Два");
        publishSubject.onNext("Три");
        publishSubject.onNext("Четыре");
        disposable = publishSubject.subscribeWith((new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAA",s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }));
        publishSubject.onNext("Пять");
        publishSubject.onNext("Шесть");
        publishSubject.onNext("Семь");
    //  ------------


        ImageView imageOwl = (ImageView) findViewById(R.id.owlImage);
        imageOwl.setBackgroundResource(R.drawable.owl_animation);
        AnimationDrawable animationOwl = (AnimationDrawable) imageOwl.getBackground();
        animationOwl.start();



        Button hw42Button = (Button)findViewById(R.id.task4_Clocks);
        hw42Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeWork4Activity.this, AnalogClocksActivity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!disposable.isDisposed())
            disposable.dispose();
    }
}