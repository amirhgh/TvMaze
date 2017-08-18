package com.aghafari.tvmaze.ui.activity.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aghafari.tvmaze.R;
import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by amir on 8/18/17.
 */

public abstract class BaseActivity<BINDER extends ViewDataBinding> extends AppCompatActivity {
	protected BINDER binding;
	protected Context context;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
	}

	public void setContent(@LayoutRes int layoutResID) {
		binding = DataBindingUtil.setContentView(this, layoutResID);
	}

	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}

	private Retrofit provideRetrofit() {
		return new Retrofit.Builder().baseUrl(getString(R.string.base_url))
				.addConverterFactory(LoganSquareConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
	}

	public ApiService provideApiService() {
		return provideRetrofit().create(ApiService.class);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}}
