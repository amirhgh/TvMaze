package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class Links {

	@JsonField(name = "self")
	private Self self;

	@JsonField(name = "previousepisode")
	private Previousepisode previousepisode;
}