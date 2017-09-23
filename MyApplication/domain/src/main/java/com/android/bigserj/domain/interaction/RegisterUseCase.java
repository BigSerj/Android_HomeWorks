package com.android.bigserj.domain.interaction;


import com.android.bigserj.data.entity.AccessTokenData;
import com.android.bigserj.data.entity.RegisterData;
import com.android.bigserj.data.net.RestService;
import com.android.bigserj.domain.entity.OkDomain;
import com.android.bigserj.domain.entity.RegisterDomain;
import com.android.bigserj.domain.interaction.base.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RegisterUseCase extends UseCase<RegisterDomain, OkDomain> {

    AuthService authService;

    @Inject
    public RegisterUseCase(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected Observable<OkDomain> buildUseCase(RegisterDomain registerDomain) {

        return RestService.getInstance().register(convert(registerDomain))
                .doOnNext(new Consumer<AccessTokenData>() {
                    @Override
                    public void accept(AccessTokenData accessTokenData) throws Exception {
                        accessTokenData.setAccessToken(accessTokenData.getAccessToken());
                    }
                })
                .map(new Function<AccessTokenData, OkDomain>() {
                    @Override
                    public OkDomain apply(@NonNull AccessTokenData accessTokenData) throws Exception {
                        return new OkDomain();
                    }
                });

    }

    private RegisterData convert(RegisterDomain registerDomain){
        RegisterData registerData = new RegisterData();
        registerData.setUserName(registerDomain.getUserName());
        registerData.setPassword(registerDomain.getPassword());
        return registerData;
    }

}