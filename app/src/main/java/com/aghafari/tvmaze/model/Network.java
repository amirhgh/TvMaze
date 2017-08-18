package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class Network {

	@JsonField(name = "country")
	private Country country;

	@JsonField(name = "name")
	private String name;

	@JsonField(name = "id")
	private int id;
}