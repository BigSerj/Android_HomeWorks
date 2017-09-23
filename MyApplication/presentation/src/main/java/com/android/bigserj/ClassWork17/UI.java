package com.android.bigserj.ClassWork17;


import com.android.bigserj.TestApplication;

import javax.inject.Inject;

public class UI {

    @Inject
    UseCase1 useCase1;

    public UI() {
        TestApplication.appComponent.inject(this);
    }

    public void testUseCase1() {

        useCase1.getRestData();

    }

}
