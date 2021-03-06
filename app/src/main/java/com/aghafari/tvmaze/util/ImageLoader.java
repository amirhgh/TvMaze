package com.aghafari.tvmaze.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;

/**
 * Created by amir on 8/18/17.
 */

public class ImageLoader {
	@BindingAdapter("cover")
	public static void loadCover(ImageView imageView, String url) {
		Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
	}
	@BindingAdapter("header")
	public static void loadHeader(ImageView imageView, String url) {
		Glide.with(imageView.getContext()).load(url).asBitmap().transform(new CenterCrop(imageView.getContext())).into(imageView);
	}

}
