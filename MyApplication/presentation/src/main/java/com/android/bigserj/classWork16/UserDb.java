package com.android.bigserj.classWork16;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserDb extends RealmObject{

    @PrimaryKey
    private int id;
    private String name;
    private int nameOneTwo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNameOneTwo() {
        return nameOneTwo;
    }

    public void setNameOneTwo(int nameOneTwo) {
        this.nameOneTwo = nameOneTwo;
    }
}
