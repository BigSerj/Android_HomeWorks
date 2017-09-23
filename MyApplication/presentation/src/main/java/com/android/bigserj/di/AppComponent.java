package com.android.bigserj.di;


import com.android.bigserj.ClassWork17.UI;
import com.android.bigserj.classWork21.RegisterPresenter;
import com.android.bigserj.homeWork11.HomeWork11ViewModel2;

import javax.inject.Singleton;

import dagger.Component;


// связующее звено между AppModule и UI (мост для того чтобы оно все работало)
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    public void inject(UI ui);
    public void inject2(HomeWork11ViewModel2 homeWork11ViewModel2);

    public void inject(RegisterPresenter presenter);

}