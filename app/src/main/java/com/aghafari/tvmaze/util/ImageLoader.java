package com.aghafari.tvmaze.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by amir on 8/18/17.
 */

public class ImageLoader {
	@BindingAdapter("cover")
	public static void loadCover(ImageView imageView, String url) {
		Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
	}

}
