package com.android.bigserj.homeWork6;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.bigserj.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeWork6Adapter extends RecyclerView.Adapter<HomeWork6Adapter.Holder> {

    private ArrayList<String> items;
    private Context context;

    public HomeWork6Adapter(ArrayList<String> items) {
        this.items = items;
    }


    // создаем Holder
    @Override
    public HomeWork6Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View root = LayoutInflater.from(context)
                .inflate(R.layout.item_recycle_view_hw6,parent,false);
        Log.e("AAA","onCreateViewHolder()");
        return new Holder(root);
    }


    // заполняем Holder
    @Override
    public void onBindViewHolder(final HomeWork6Adapter.Holder holder, int position) {
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
