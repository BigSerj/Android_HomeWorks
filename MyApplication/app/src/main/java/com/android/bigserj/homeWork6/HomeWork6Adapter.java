package com.android.bigserj.homeWork6;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.bigserj.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeWork6Adapter extends RecyclerView.Adapter<HomeWork6Adapter.Holder> {

    private ArrayList<String> items;
    private Context context;

    public HomeWork6Adapter(ArrayList<String> items) {
        this.items = items;
    }


    @Override
    public HomeWork6Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View root = LayoutInflater.from(context)
                .inflate(R.layout.item_recycle_view_hw6,parent,false);
        Log.e("AAA","onCreateViewHolder()");
        return new Holder(root);
    }

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

//        holder.progressBar.setVisibility(View.VISIBLE);
//        Glide.with(context)
//                .load(item)
//                .apply(RequestOptions.circleCropTransform())
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        holder.progressBar.setVisibility(View.INVISIBLE);
//                        return false;
//                    }
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        holder.progressBar.setVisibility(View.INVISIBLE);
//                        return false;
//                    }
//                })
//                .into(holder.imageView);

    }

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
