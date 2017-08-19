package com.aghafari.tvmaze.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.Window;
import android.view.WindowManager;

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
//		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
//			Window w = getWindow(); // in Activity's onCreate() for instance
//			w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//			CollapsingToolbarLayout.LayoutParams lp = (CollapsingToolbarLayout.LayoutParams) mToolBar.getLayoutParams();
//			lp.setMargins(0,24,0,0);
//			mToolBar.setLayoutParams(lp);
//		}
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
