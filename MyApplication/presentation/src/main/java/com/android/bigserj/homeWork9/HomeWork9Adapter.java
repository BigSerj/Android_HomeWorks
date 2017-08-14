package com.android.bigserj.homeWork9;


import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.bigserj.R;
import com.android.bigserj.databinding.ItemRecycleViewHw9Binding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeWork9Adapter extends RecyclerView.Adapter<HomeWork9Adapter.Holder> {



    private ArrayList<String> items;
    private Context context;

    public HomeWork9Adapter(ArrayList<String> items) {
        this.items = items;
    }


    // создаем Holder
    @Override
    public HomeWork9Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {




//        HomeWork9AdapterViewModel homeWork9AdapterViewModel =
//            new HomeWork9AdapterViewModel(this);
//
//        ItemRecycleViewHw9Binding binding = DataBindingUtil
//            .setContentView(, R.layout.activity_homework9);




        this.context = parent.getContext();
        View root = LayoutInflater.from(context)
                .inflate(R.layout.item_recycle_view_hw9,parent,false);
        Log.e("AAA","onCreateViewHolder()");
        return new Holder(root);
    }


    // заполняем Holder
    @Override
    public void onBindViewHolder(final HomeWork9Adapter.Holder holder, int position) {
        Log.e("AAA","onBindViewHolder() position = "+position);

        String item = items.get(position);

        final ProgressBar progressView = holder.progressBar;
        Picasso.with(context)
                .load(item)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        progressView.setVisibility(View.GONE);
                    }
                });
    }

    // считает сколько раз нужно вызвать onBindViewHolder()
    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }



    public static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;

        public Holder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress);

        }
    }




}