package com.android.bigserj.base;


public interface BaseViewModelFragment {

    public void create();

    public void createView();

    public void onPause();

    public void destroyView();

    public void viewCreated();

    public void start();

    public void stop();

    public void activityCreated();

    public void attach();

    public void detach();


}
