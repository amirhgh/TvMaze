package com.aghafari.tvmaze.network;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.aghafari.tvmaze.R;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by amir on 8/24/17.
 */

public class Api {

	private static Retrofit build;
	private static Api instance;

	private Api(String baseUrl) {
		build = new Retrofit.Builder().baseUrl(baseUrl)
				.addConverterFactory(ScalarsConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
	}

	@VisibleForTesting
	public static Api getInstance(Context c) {
		return new Api(c.getString(R.string.base_url));
	}

	public static Api getInstance(String baseUrl) {
		if (instance == null) {
			instance = new Api(baseUrl);
		}
		return instance;
	}

	public <T> T create(Class<T> cls) {
		return build.create(cls);
	}
}
