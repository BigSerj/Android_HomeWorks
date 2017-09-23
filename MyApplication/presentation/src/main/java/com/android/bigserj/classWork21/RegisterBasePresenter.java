package com.android.bigserj.classWork21;


// те методы к которым будет иметь доступ активити
public interface RegisterBasePresenter {

    public void onRegisterButtonClick(String userName, String password);
    public void onResume();
    public void onPause();
}
