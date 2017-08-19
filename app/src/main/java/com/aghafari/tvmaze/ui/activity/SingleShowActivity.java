package com.aghafari.tvmaze.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aghafari.tvmaze.R;
import com.aghafari.tvmaze.databinding.ActivitySingleShowBinding;
import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.network.Router.ShowsRouter;
import com.aghafari.tvmaze.ui.activity.base.BaseActivity;
import com.aghafari.tvmaze.vm.ShowViewModel;
import com.bluelinelabs.logansquare.LoganSquare;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amir on 8/19/17.
 */

public class SingleShowActivity extends BaseActivity<ActivitySingleShowBinding> {
	public static final String SHOW_ID = "show_id";
	private int showId;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContent(R.layout.activity_single_show);
		showId = getIntent().getIntExtra(SHOW_ID, -1);
		if (showId == -1)
			finish();
		provideRetrofit().create(ShowsRouter.class).singleShow(showId).map(new Function<String, Show>() {
			@Override
			public Show apply(String s) throws Exception {
				return LoganSquare.parse(s, Show.class);
			}
		}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<Show>() {
					@Override
					public void accept(Show show) throws Exception {
						binding.setShow(ShowViewModel.with(show));
					}
				});
//		binding.setShow();
	}
}
