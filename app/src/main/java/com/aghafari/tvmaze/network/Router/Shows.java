package com.aghafari.tvmaze.network.Router;

import com.aghafari.tvmaze.model.Show;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amir on 8/18/17.
 */

public interface Shows {
	@GET("shows")
	Observable<List<Show>> listShows(@Query("page") int page);

	@GET("shows/{id}")
	Observable<Show> singleShow(@Path("id") int id);
}
