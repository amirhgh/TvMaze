package com.aghafari.tvmaze.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.aghafari.tvmaze.R;
import com.aghafari.tvmaze.databinding.ActivityShowsBinding;
import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.network.Router.ShowsRouter;
import com.aghafari.tvmaze.ui.activity.base.BaseActivity;
import com.aghafari.tvmaze.ui.adapter.ShowsListAdapter;
import com.bluelinelabs.logansquare.LoganSquare;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amir on 8/18/17.
 */

public class ShowsActivity extends BaseActivity<ActivityShowsBinding> {
	private static final String TAG = "ShowsActivity";
	private List<Show> list = new ArrayList<>();
	private ShowsListAdapter showsListAdapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContent(R.layout.activity_shows);
		showsListAdapter = new ShowsListAdapter(context, list);
		GridLayoutManager layout = new GridLayoutManager(this, 2);
		binding.list.setLayoutManager(layout);
		binding.list.setAdapter(showsListAdapter);

		provideRetrofit().create(ShowsRouter.class).listShows(0)
				.map(new Function<String, List<Show>>() {
					@Override
					public List<Show> apply(@NonNull String s) throws Exception {
						return LoganSquare.parseList(s, Show.class);
					}
				}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Show>>() {
			@Override
			public void accept(@NonNull List<Show> shows) throws Exception {
				list.addAll(shows);
				showsListAdapter.notifyDataSetChanged();
			}
		}, new Consumer<Throwable>() {
			@Override
			public void accept(@NonNull Throwable throwable) throws Exception {
				Log.e(TAG, "accept: ", throwable);
			}
		});
	}
}
