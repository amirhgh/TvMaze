package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class Rating {
	@JsonField(name = "average")
	private int average;

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}
}