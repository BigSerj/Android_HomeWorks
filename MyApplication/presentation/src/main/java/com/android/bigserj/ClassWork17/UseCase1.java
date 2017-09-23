package com.android.bigserj.ClassWork17;


public class UseCase1 {

    private Rest rest;
    private SharedPrefs sharedPrefs;

    public UseCase1(Rest rest, SharedPrefs sharedPrefs) {
        this.rest = rest;
        this.sharedPrefs = sharedPrefs;
    }

    public String getRestData(){
        return "";
    }


}

