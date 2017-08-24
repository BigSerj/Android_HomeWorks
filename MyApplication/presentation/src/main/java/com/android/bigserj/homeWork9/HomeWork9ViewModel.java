package com.android.bigserj.homeWork9;


import android.app.Activity;
import android.databinding.ObservableField;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.domain.entity.HomeWork9ArrayListForLinks;
//import com.android.bigserj.domain.interaction.HomeWork9UseCase;
//import com.android.bigserj.domain.interaction.HomeWork9UseCase;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HomeWork9ViewModel implements BaseViewModel {


    public Activity activity;

    public HomeWork9ViewModel(Activity activity) {
        this.activity = activity;
    }


    public ObservableField<ArrayList<String>> stringArrayList = new ObservableField<>();

//    private HomeWork9UseCase useCase = new HomeWork9UseCase();


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {


        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.homeWork9RW);

        // тут блок отвечающий за расстановку (форму) на экране
        GridLayoutManager gm = new GridLayoutManager(recyclerView.getContext(), 2);
        gm.canScrollHorizontally();
        recyclerView.setLayoutManager(gm);


//        useCase.execute("Дай коллекцию с URL-ами, что ли", new DisposableObserver<HomeWork9ArrayListForLinks>() {
//            @Override
//            public void onNext(@NonNull HomeWork9ArrayListForLinks homeWork9ArrayListForLinks) {
//                stringArrayList.set(homeWork9ArrayListForLinks.getStringArrayList());
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });


        // инициализируем адаптер
//        recyclerView.setAdapter(new HomeWork9Adapter(stringArrayList.get()));


    }

    @Override
    public void pause() {

    }
}
