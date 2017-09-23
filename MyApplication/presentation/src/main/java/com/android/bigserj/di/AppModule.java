package com.android.bigserj.di;


import android.content.Context;

import com.android.bigserj.ClassWork17.Gson;
import com.android.bigserj.ClassWork17.OkHttp;
import com.android.bigserj.ClassWork17.Rest;
import com.android.bigserj.ClassWork17.SharedPrefs;
import com.android.bigserj.ClassWork17.UseCase1;
import com.android.bigserj.domain.entity.GetUser;
import com.android.bigserj.domain.interaction.HomeWork11.GetProfileUseCaseHW11;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


// тут мы рассказываем даггеру как нужно создавать наш объект
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public UseCase1 provideUseCase1(Rest rest, SharedPrefs sharedPrefs){
        return new UseCase1(rest,sharedPrefs);
    }

    @Provides
    public OkHttp provideOkHttp(){
        return new OkHttp();
    }

    @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Provides
    public Rest provideRest(OkHttp okHttp, Gson gson){
        return new Rest(okHttp,gson);
    }

    @Provides
    public SharedPrefs provideSharedPrefs(){
        return new SharedPrefs();
    }


    @Provides
    @Singleton
    public GetProfileUseCaseHW11 provideGetProfileUseCaseHW11(){
        return new GetProfileUseCaseHW11();
    }

}
