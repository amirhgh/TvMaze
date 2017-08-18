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
}