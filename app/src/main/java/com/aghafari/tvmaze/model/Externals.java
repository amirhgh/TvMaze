package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class Externals {
	@JsonField(name = "thetvdb")
	private int thetvdb;
	@JsonField(name = "imdb")
	private String imdb;
	@JsonField(name = "tvrage")
	private int tvrage;

	public int getThetvdb() {
		return thetvdb;
	}

	public void setThetvdb(int thetvdb) {
		this.thetvdb = thetvdb;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public int getTvrage() {
		return tvrage;
	}

	public void setTvrage(int tvrage) {
		this.tvrage = tvrage;
	}
}