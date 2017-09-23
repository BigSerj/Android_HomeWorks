package com.android.bigserj.classWork21;


import com.android.bigserj.TestApplication;
import com.android.bigserj.domain.entity.AuthState;
import com.android.bigserj.domain.entity.OkDomain;
import com.android.bigserj.domain.entity.RegisterDomain;
import com.android.bigserj.domain.interaction.AuthService;
import com.android.bigserj.domain.interaction.RegisterUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class RegisterPresenter implements RegisterBasePresenter{

    @Inject
    public RegisterUseCase useCase;

    @Inject
    public AuthService authService;

    private Disposable authDisposable;



    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        this.view = view;
        TestApplication.appComponent.inject(this);
    }

    public void onRegisterButtonClick(String userName, String password){
        view.showProgress();

        RegisterDomain register = new RegisterDomain();
        register.setUserName(userName);
        register.setPassword(password);

        useCase.execute(register, new DisposableObserver<OkDomain>() {
            @Override
            public void onNext(@NonNull OkDomain okDomain) {
                view.dismiss();
                view.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError("error");
            }

            @Override
            public void onComplete() {
            }
        });

        // тут вызываем usecase

        view.dismiss();
        view.showError("Error");
    }


    public void onResume(){
        authService.observeState().subscribeWith(new DisposableObserver<AuthState>() {
            @Override
            public void onNext(@NonNull AuthState authState) {
                // проверяем состояние авторизации
                if (authState.isSigned())  // если подписаны - сразу переходим на главный экран, если нет - останемся тут
                    view.goToMainActivity();
            }
            @Override
            public void onError(@NonNull Throwable e) {

            }
            @Override
            public void onComplete() {
            }
        });
    }

    public void onPause(){
        if (authDisposable != null && !authDisposable.isDisposed())
            authDisposable.dispose();
    }

}
