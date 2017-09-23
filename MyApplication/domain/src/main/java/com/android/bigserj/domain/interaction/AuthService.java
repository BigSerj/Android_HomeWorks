package com.android.bigserj.domain.interaction;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.android.bigserj.domain.entity.AuthState;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

@Singleton
public class AuthService {

    private static final String KEY_ACCESS_TOKEN = "accessToken";
    private static final String SHARED_PREFS_NAME = "sharedPrefs";
    private Context context;

    private BehaviorSubject<AuthState> state = BehaviorSubject.createDefault(new AuthState(false));

    @Inject
    public AuthService(Context context){
        this.context = context;
        restoreAccessToken();
    }




    public Observable<AuthState> observeState(){
        return state;
    }

    void saveAccessToken(String accessToken){
        // сохраняем локально токен
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(KEY_ACCESS_TOKEN,accessToken).apply();

        // увдомляем всех подписчиков о том что мы залогинениы (всех кто подписан к state,
        // точнее, всех, кто вызвал метод Observable())
        state.onNext(new AuthState(true));
    }

    void removeAccessToken(){
        // удаляем токен
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(KEY_ACCESS_TOKEN).apply();

        // уведомляем о том что мы разлогинились
        state.onNext(new AuthState(false));
    }


    private void restoreAccessToken(){
        // получаем токен
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(KEY_ACCESS_TOKEN,null);

        // если токен не null - значит мы залогинены
        if (!TextUtils.isEmpty(token))
            state.onNext(new AuthState(true));
        else
            state.onNext(new AuthState(false));

    }

}
