package com.android.bigserj.data.net;

import com.android.bigserj.data.entity.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// тут нсатроим ретрофит и тут будут лежать сервисы которые мы настроим из слоя domain
public class RestService {
    private static final RestService instance = new RestService();

    private RestApi restApi;

    public static RestService getInstance() {
        return instance;
    }

    private RestService() {
        init();
    }




    private void init() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder() // замена HttpURLConnection в Java
                .readTimeout(10, TimeUnit.SECONDS)  // если за 10 сек не произойдет считывания с серверы какой-либо инфы
                .connectTimeout(10, TimeUnit.SECONDS)  // будет ошибка если за 10 сек не произойдет подключение к серверу
                .addInterceptor(logging) // класс который в промежутке между тем чтобы отправить данные производит некоторые действия с объектом
                .build();

        // gson либа для парсинга json
        Gson gson = new GsonBuilder().create();

        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        restApi = retrofit.create(RestApi.class);
    }


    // возвращает лист всех профайлов
    public Observable<List<Profile>> getProfiles(){
        return restApi.getProfiles();
    }

    public Observable<Void> saveProfile(Profile profile){
        return restApi.saveProfile(profile);
    }


    public Observable<Profile> getProfile(String id){
        return restApi.getProfile(id);
    }

//    public Observable<Void> saveProfile(Profile profile){
//        return restApi.saveProfile(profile);
//    }


}