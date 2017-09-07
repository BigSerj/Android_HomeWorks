package com.android.bigserj.classwork15;


public class Sql {

    /*
    "SELECT * FROM user" - все данные из таблицы * означает все поля

    "SELECT id, name FROM user" - только поля id и name из таблицы user

    "SELECT * FROM user WHERE country=1" - выборка юзеров только с countryId = 1
    "SELECT * FROM user WHERE name='ABC'" - выборка всех полей юзеров только с name = "ABC"



    ----   INNER JOIN, RIGHT JOIN, LEFT JOIN   -----

    "SELECT * FROM user INNER JOIN country ON user.countyId = country.id" - выборка из таблиц
              user и country одновременно, возвращает одну объединенную таблицу

    "SELECT * FROM user INNER JOIN country ON user.countyId = country.id" - выборка из таблиц
              user и country одновременно, возвращает одну объединенную таблицу
              только если возможно их соединить по условию "user.countryId = country.id"


    "SELECT * FROM user LEFT JOIN country ON user.countyId = country.id" - выборка из таблиц
              user и country одновременно, все из таблицы user и
              если в country ничего не нашлось то справа будет null,
              возвращает одну объединенную таблицу

    "SELECT * FROM user RIGHT JOIN country ON user.countyId = country.id" -
           вернет все что справа в таблицу country и то что совпадет в таблице user

    "SELECT * FROM user RIGHT JOIN country ON user.countyId = country.id WHERE <условие>"




    "SELECT * FROM user LIMIT 20" - вернет первых 20 записей
    "SELECT * FROM user LIMIT 20 OFFSET 20" - вернет записи с позиции 20 и до позиции 40

    "SELECT * FROM user ORDER BY age ACS" - сортировка от меньшего к большему <DESC> - наоборт


    */

}
