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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public String getPremiered() {
		return premiered;
	}

	public void setPremiered(String premiered) {
		this.premiered = premiered;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOfficialSite() {
		return officialSite;
	}

	public void setOfficialSite(String officialSite) {
		this.officialSite = officialSite;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public WebChannel getWebChannel() {
		return webChannel;
	}

	public void setWebChannel(WebChannel webChannel) {
		this.webChannel = webChannel;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Externals getExternals() {
		return externals;
	}

	public void setExternals(Externals externals) {
		this.externals = externals;
	}

	public int getUpdated() {
		return updated;
	}

	public void setUpdated(int updated) {
		this.updated = updated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}