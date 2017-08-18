package com.aghafari.tvmaze.network.Router;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amir on 8/18/17.
 */

public interface ShowsRouter {
	@GET("shows")
	Observable<String> listShows(@Query("page") int page);

	@GET("shows/{id}")
	Observable<String> singleShow(@Path("id") int id);
}
