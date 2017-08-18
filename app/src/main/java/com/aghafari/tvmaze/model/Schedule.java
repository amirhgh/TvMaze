package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;


@JsonObject
public class Schedule {

	@JsonField(name = "days")
	private List<String> days;

	@JsonField(name = "time")
	private String time;
}