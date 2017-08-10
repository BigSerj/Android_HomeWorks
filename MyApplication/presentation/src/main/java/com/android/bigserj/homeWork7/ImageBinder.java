package com.android.bigserj.homeWork7;


import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public final class ImageBinder {

    @BindingAdapter({"bind:image_url"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}

