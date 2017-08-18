package com.aghafari.tvmaze.vm;

import android.databinding.BaseObservable;

import com.aghafari.tvmaze.model.Show;


/**
 * Created by amir on 8/18/17.
 */

public class ShowViewModel extends BaseObservable {
	private Show show;

	public ShowViewModel(Show show) {
		this.show = show;
	}

	public String getCover() {
		return show.getImage().getOriginal();
	}
}
