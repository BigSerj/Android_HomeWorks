package com.android.bigserj.data.entity;


import com.google.gson.annotations.SerializedName;

public class Profile implements DataModel{

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surName;

    @SerializedName("age")
    private int age;

    @SerializedName("objectId")
    private String id;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
