package com.android.bigserj.homeWork11;


import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.HomeWork11.GetProfileUseCaseHW11;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static com.android.bigserj.homeWork11.HomeWork11ViewModel3.*;

public class HomeWork11ViewModel2 implements BaseViewModel{

    public Activity activity;
    public HomeWork11ViewModel2(Activity activity) {
        this.activity = activity;
    }

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    public static final String ID_NUMBER = "ID_NUMBER";

    private GetProfileUseCaseHW11 getProfileUseCaseHW11 = new GetProfileUseCaseHW11();

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> sureName = new ObservableField<>();
    public ObservableField<Integer> age = new ObservableField<>();



    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        final String id = activity.getIntent().getStringExtra(ID_NUMBER);

        getProfileUseCaseHW11.execute(id, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profileModel) {

                name.set(profileModel.getName());
                sureName.set(profileModel.getSurName());
                age.set(profileModel.getAge());

                state.set(STATE.DATA);

                Button textEditButton = (Button)activity.findViewById(R.id.textEdit);
                textEditButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), HomeWork11Activity3.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                        intent.putExtra(NAME_NUMBER,name.get());
                        intent.putExtra(SURNAME_NUMBER,sureName.get());
                        intent.putExtra(AGE_NUMBER,age.get().toString());
                        intent.putExtra(ID_NUMBER,id);
                        activity.startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(@NonNull Throwable e) {
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

        getProfileUseCaseHW11.dispose();

    }
}
