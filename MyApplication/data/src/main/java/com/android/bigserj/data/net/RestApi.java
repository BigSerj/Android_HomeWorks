package com.android.bigserj.data.net;


import com.android.bigserj.data.entity.Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

    // возвращает все профили
    @GET("data/profile")
    Observable<List<Profile>> getProfiles();

    // возвращает один профиль "resourceName"
    @GET("data/profile/{id}")
    Observable<Profile> getProfile(@Path("id") String id);

    // значит этот объект профиля который подадим будет конверирован в json и передан в тело запроса
    @POST("data/profile")
    Observable<Void> saveNewProfile(@Body Profile profile);

    // редактируем
    @PUT("data/profile/{id}")
    Observable<Void> editProfile(@Path("id") String id, @Body Profile profile);
}



// ПАТТЕРН REPOSITORY всунуть в data-модуль !!!


//API json weather - !!! - так искать серваки