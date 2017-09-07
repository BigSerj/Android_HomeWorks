package com.android.bigserj.data.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.bigserj.data.dbEntity.Country;
import com.android.bigserj.data.dbEntity.User;

import java.util.List;

public class DatabaseManager {

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    // открываем бд
    public void open(boolean isWritable){
        if (isWritable)
            sqLiteDatabase = dbHelper.getWritableDatabase();
        else
            sqLiteDatabase = dbHelper.getReadableDatabase();
    }

    // закртываем бд
    public void close(){
        if (sqLiteDatabase!=null)
            sqLiteDatabase.close();
    }

    public void insertUser(User user){

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO user ('name', 'age', 'countryId') ");
        sql.append("VALUES (");
        sql.append("'");
        sql.append(user.getName());
        sql.append("',");
        sql.append(user.getAge());
        sql.append(",'");
        sql.append(user.getCountry().getId());
        sql.append(")");

        // INSERT INTO ('name', 'age', 'countryId') VALUES ('Name', 25, 0)


        Log.e("DatabaseManager", "insertUser() sql = "+sql.toString());
        sqLiteDatabase.execSQL(sql.toString());
    }

    public void updateUser(User user){

    }

    public List<User> getUsers(){

        return null;
    }

    public User getUserBuId(String id){

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user INNER JOIN country ON " +
                "user.countryId = country.id WHERE id = ?", new String[]{String.valueOf(id)});

        if (cursor!=null) {
            User user = new User();

            // вытягиваем данные из Cursor
            cursor.moveToFirst();
            int userId = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            int countryId = cursor.getInt(3);
            String countryName = cursor.getString(4);

            // заполняем объет user
            user.setId(userId);
            user.setName(name);
            user.setAge(age);

            // заполняем объет country
            Country country = new Country();
            country.setId(countryId);
            country.setName(countryName);

            // добавляем объект Country в User
            user.setCountry(country);

            return user;

        }else
            Log.e("DatabaseManager", "getUserById() cursor is null");


        return null;
    }


}
