package com.android.bigserj.classwork8;


import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.android.bigserj.base.BaseViewModel;

public class ClassWork8ViewModel implements BaseViewModel{

    public Activity activity;

    public ClassWork8ViewModel(Activity activity) {
        this.activity = activity;
    }

    public ObservableField<String> helloText = new ObservableField<>("Hello");

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }


    public void onSuperButtonClick(){
        Log.e("AAA","Click");
//        Intent intent = new Intent(activity, ClassWork5Activity.class);
//        activity.startActivity(intent);

        ClassWork8Activity.show(activity);

    }




    public class MyAsyncTask extends AsyncTask<Void,Integer,String>{

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // выполняется в UI потоке
            // этот метод необходимо вызывать самостоятельно из doInBackgroud
        }

        @Override
        protected void onPreExecute() {
            // выполняется в UI потоке, до начала работы метода doInBackgroud
            // выполняется первым как вызвали start
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            // тут все выполнится в отдельном потоке
            // затем передает данные в метод onPostExecute()

            publishProgress(20); // вызвать метод onProgressUpdate

            return null;
        }
        // этот метод выполнится после выполнения метода doInBackground() в отдельном потоке
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // тут все выполняется в UI потоке
            // входное значение s передается из метода doInBackground
        }
    }



}
