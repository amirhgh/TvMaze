package com.aghafari.tvmaze.vm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.text.Spanned;
import android.view.View;

import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.ui.activity.SingleShowActivity;
import com.aghafari.tvmaze.util.AndroidUtils;
import com.aghafari.tvmaze.util.MyApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by amir on 8/18/17.
 */

public class ShowViewModel extends BaseObservable {
	private Show show;

	private ShowViewModel(Show show) {
		this.show = show;
	}

	public static ShowViewModel with(Show show) {
		return new ShowViewModel(show);
	}

	public String getCover() {
		return show.getImage().getOriginal();
	}

	public String getHeader() {
		return show.getImage().getMedium();
	}

	public String getTitle() {
		return show.getName();
	}

	public String getDetail() {
		String year = "-";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", MyApplication.getContext().getResources().getConfiguration().locale);
		try {
			Date date = dateFormat.parse(show.getPremiered());
			SimpleDateFormat df = new SimpleDateFormat("yyyy.M", MyApplication.getContext().getResources().getConfiguration().locale);
			year = df.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return year + " \u25CF " + show.getRuntime() + " min \u25CF " + show.getRating().getAverage() + "/10";
	}

	public Spanned getSummary() {
		return AndroidUtils.fromHtml(show.getSummary());
	}

	public void openSingle(View v) {
		Context context = v.getContext();
		Intent intent = new Intent(context, SingleShowActivity.class);
		intent.putExtra(SingleShowActivity.SHOW_ID, show.getId());
		context.startActivity(intent);
	}
}
