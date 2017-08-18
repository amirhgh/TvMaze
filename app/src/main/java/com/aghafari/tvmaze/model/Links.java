package com.aghafari.tvmaze.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class Links {
	@JsonField(name = "self")
	private Self self;
	@JsonField(name = "previousepisode")
	private Previousepisode previousepisode;

	public Self getSelf() {
		return self;
	}

	public void setSelf(Self self) {
		this.self = self;
	}

	public Previousepisode getPreviousepisode() {
		return previousepisode;
	}

	public void setPreviousepisode(Previousepisode previousepisode) {
		this.previousepisode = previousepisode;
	}
}