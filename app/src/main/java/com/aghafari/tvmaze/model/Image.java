package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class Image {

	@JsonField(name = "original")
	private String original;

	@JsonField(name = "medium")
	private String medium;
}