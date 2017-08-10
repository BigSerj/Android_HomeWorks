package com.android.bigserj.homeWork6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.bigserj.R;

import java.util.ArrayList;

public class HomeWork6Activity extends Activity{

    private static final String img1 = "http://www.bugaga.ru/uploads/posts/2016-09/1474981059_foto-9.jpg";
    private static final String img2 = "http://www.bugaga.ru/uploads/posts/2017-03/1488547863_kartinko-20.jpg";
    private static final String img3 = "http://cdn.fishki.net/upload/post/201505/21/1539868/q48f_1kclqe.jpg";
    private static final String img4 = "http://cs5.pikabu.ru/images/big_size_comm/2015-09_5/144293824815326688.jpg";
    private static final String img5 = "https://cs5.pikabu.ru/images/previews_comm/2015-09_4/1442494629129086018.jpg";
    private static final String img6 = "https://pp.userapi.com/c638317/v638317888/354e2/PH4HTmdZxn4.jpg";
    private static final String img7 = "http://bm.img.com.ua/nxs/img/prikol/images/large/4/3/156034.gif";
    private static final String img8 = "http://s4.storage.akamai.coub.com/get/b88/p/coub/simple/cw_timeline_pic/c0ce61faf68/84fc2c3d374d0a19ed258/med_1411107592_image.jpg";
    private static final String img9 = "https://s-media-cache-ak0.pinimg.com/736x/d7/b6/de/d7b6de2ba6166683223c1b7f0b3f5a6d--funny-cats-and-dogs-pet-cats.jpg";
    private static final String img10 = "http://www.bugaga.ru/uploads/posts/2015-06/1433173601_smeshnye-sobaki.jpg";

    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);

        // тут вносим данные
        stringArrayList.add(img1);
        stringArrayList.add(img2);
        stringArrayList.add(img3);
        stringArrayList.add(img4);
        stringArrayList.add(img5);
        stringArrayList.add(img6);
        stringArrayList.add(img7);
        stringArrayList.add(img8);
        stringArrayList.add(img9);
        stringArrayList.add(img10);


        recyclerView = (RecyclerView) findViewById(R.id.homeWork6RW);

        // тут блок отвечающий за расстановку (форму) на экране
        GridLayoutManager gm = new GridLayoutManager(this, 2);
        gm.canScrollHorizontally();
        recyclerView.setLayoutManager(gm);


        // инициализаируем адаптер
        recyclerView.setAdapter(new HomeWork6Adapter(stringArrayList));

    }
}
