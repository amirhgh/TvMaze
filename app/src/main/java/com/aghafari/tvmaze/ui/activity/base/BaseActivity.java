package com.aghafari.tvmaze.ui.activity.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aghafari.tvmaze.R;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

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

	protected Retrofit provideRetrofit() {
		OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request.Builder builder = chain.request().newBuilder();
				return chain.proceed(builder.build());
			}
		}).build();
		return new Retrofit.Builder().baseUrl(getString(R.string.base_url))
				.client(client)
				.addConverterFactory(ScalarsConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
