package com.aghafari.tvmaze.vm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.ui.activity.SingleShowActivity;


/**
 * Created by amir on 8/18/17.
 */

public class ShowViewModel extends BaseObservable {
	private Show show;

	private ShowViewModel(Show show) {
		this.show = show;
	}

	public String getCover() {
		return show.getImage().getOriginal();
	}

	public String getHeader() {
		return show.getImage().getMedium();
	}

	public void openSingle(View v) {
		Context context = v.getContext();
		Intent intent = new Intent(context, SingleShowActivity.class);
		intent.putExtra(SingleShowActivity.SHOW_ID, show.getId());
		context.startActivity(intent);
	}

	public static ShowViewModel with(Show show) {
		return new ShowViewModel(show);
	}
}
