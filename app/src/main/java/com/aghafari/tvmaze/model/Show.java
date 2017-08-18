package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;


@JsonObject
public class Show {

	@JsonField(name = "summary")
	private String summary;

	@JsonField(name = "image")
	private Image image;

	@JsonField(name = "_links")
	private Links links;

	@JsonField(name = "premiered")
	private String premiered;

	@JsonField(name = "rating")
	private Rating rating;

	@JsonField(name = "runtime")
	private int runtime;

	@JsonField(name = "weight")
	private int weight;

	@JsonField(name = "language")
	private String language;

	@JsonField(name = "type")
	private String type;

	@JsonField(name = "url")
	private String url;

	@JsonField(name = "officialSite")
	private String officialSite;

	@JsonField(name = "network")
	private Network network;

	@JsonField(name = "schedule")
	private Schedule schedule;

	@JsonField(name = "webChannel")
	private WebChannel webChannel;

	@JsonField(name = "genres")
	private List<String> genres;

	@JsonField(name = "name")
	private String name;

	@JsonField(name = "id")
	private int id;

	@JsonField(name = "externals")
	private Externals externals;

	@JsonField(name = "updated")
	private int updated;

	@JsonField(name = "status")
	private String status;
}