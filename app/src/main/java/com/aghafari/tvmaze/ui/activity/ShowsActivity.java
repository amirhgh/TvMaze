package com.aghafari.tvmaze.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.aghafari.tvmaze.R;
import com.aghafari.tvmaze.databinding.ActivityShowsBinding;
import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.network.Api;
import com.aghafari.tvmaze.network.ErrorHandler;
import com.aghafari.tvmaze.network.Router.ShowsRouter;
import com.aghafari.tvmaze.ui.activity.base.BaseActivity;
import com.aghafari.tvmaze.ui.adapter.ShowsListAdapter;
import com.bluelinelabs.logansquare.LoganSquare;
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout;
import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewScrollEvent;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
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
	private int page = 0;
	private Disposable subscribe;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContent(R.layout.activity_shows);
		showsListAdapter = new ShowsListAdapter(context, list);
		final GridLayoutManager layout = new GridLayoutManager(this, 2);
		binding.list.setLayoutManager(layout);
		binding.list.setAdapter(showsListAdapter);
		subscribe = Observable.merge(RxRecyclerView.scrollEvents(binding.list).map(new Function<RecyclerViewScrollEvent, Integer>() {
			@Override
			public Integer apply(@NonNull RecyclerViewScrollEvent recyclerViewScrollEvent) throws Exception {
				int totalItemCount = layout.getItemCount();
				int lastVisibleItemPosition = layout.findLastVisibleItemPosition();
				if (totalItemCount - 1 <= lastVisibleItemPosition) {
					page++;
				}
				return page;
			}
		}), RxSwipeRefreshLayout.refreshes(binding.refresh).map(new Function<Object, Integer>() {
			@Override
			public Integer apply(@NonNull Object o) throws Exception {
				page = 0;
				return page;
			}
		})).distinctUntilChanged().flatMap(new Function<Integer, ObservableSource<List<Show>>>() {
			@Override
			public ObservableSource<List<Show>> apply(@NonNull Integer integer) throws Exception {
				return Api.getInstance(getString(R.string.base_url)).create(ShowsRouter.class).listShows(integer)
						.map(new Function<String, List<Show>>() {
							@Override
							public List<Show> apply(@NonNull String s) throws Exception {
								return LoganSquare.parseList(s, Show.class);
							}
						}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
			}
		}).subscribe(new Consumer<List<Show>>() {
			@Override
			public void accept(@NonNull List<Show> shows) throws Exception {
				if (page == 0)
					list.clear();
				list.addAll(shows);
				showsListAdapter.notifyDataSetChanged();
			}
		}, new ErrorHandler(binding.getRoot()));
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (subscribe != null) {
			subscribe.dispose();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		try {
			RxSwipeRefreshLayout.refreshing(binding.refresh).accept(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
