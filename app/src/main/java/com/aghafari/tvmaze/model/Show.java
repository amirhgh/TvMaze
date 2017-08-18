package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;


@JsonObject
public class Show {
	public String getSummary() {
		return summary;
	}

	public Image getImage() {
		return image;
	}

	public Links getLinks() {
		return links;
	}

	public String getPremiered() {
		return premiered;
	}

	public Rating getRating() {
		return rating;
	}

	public int getRuntime() {
		return runtime;
	}

	public int getWeight() {
		return weight;
	}

	public String getLanguage() {
		return language;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public String getOfficialSite() {
		return officialSite;
	}

	public Network getNetwork() {
		return network;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public WebChannel getWebChannel() {
		return webChannel;
	}

	public List<String> getGenres() {
		return genres;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Externals getExternals() {
		return externals;
	}

	public int getUpdated() {
		return updated;
	}

	public String getStatus() {
		return status;
	}

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