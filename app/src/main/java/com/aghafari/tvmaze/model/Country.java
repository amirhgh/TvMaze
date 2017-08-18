package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class Country {

	@JsonField(name = "code")
	private String code;

	@JsonField(name = "timezone")
	private String timezone;

	@JsonField(name = "name")
	private String name;
}