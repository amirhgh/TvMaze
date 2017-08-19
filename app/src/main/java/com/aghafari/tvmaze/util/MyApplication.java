package com.aghafari.tvmaze.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by amir on 8/19/17.
 */

public class MyApplication extends Application {

	private static Context applicationContext;

	public static Context getContext() {
		return applicationContext;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		applicationContext = getApplicationContext();
	}
}
