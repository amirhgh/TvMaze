package com.aghafari.tvmaze;

import android.content.Context;

import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.network.Api;
import com.aghafari.tvmaze.network.Router.ShowsRouter;
import com.bluelinelabs.logansquare.LoganSquare;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by amir on 8/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApiTest {
	@Mock
	private ShowsRouter router;
	@Mock

	private String shows = "[\n" +
			"{\"id\":1,\"url\":\"http://www.tvmaze.com/shows/1/under-the-dome\",\"name\":\"Under the Dome\",\"type\":\"Scripted\",\"language\":\"English\",\"genres\":[\"Drama\",\"Science-Fiction\",\"Thriller\"],\"status\":\"Ended\",\"runtime\":60,\"premiered\":\"2013-06-24\",\"officialSite\":\"http://www.cbs.com/shows/under-the-dome/\",\"schedule\":{\"time\":\"22:00\",\"days\":[\"Thursday\"]},\"rating\":{\"average\":6.5},\"weight\":94,\"network\":{\"id\":2,\"name\":\"CBS\",\"country\":{\"name\":\"United States\",\"code\":\"US\",\"timezone\":\"America/New_York\"}},\"webChannel\":null,\"externals\":{\"tvrage\":25988,\"thetvdb\":264492,\"imdb\":\"tt1553656\"},\"image\":{\"medium\":\"http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg\",\"original\":\"http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg\"},\"summary\":\"<p><b>Under the Dome</b> is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.</p>\",\"updated\":1490211618,\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/shows/1\"},\"previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/185054\"}}},\n" +
			"{\"id\":1,\"url\":\"http://www.tvmaze.com/shows/1/under-the-dome\",\"name\":\"Under the Dome\",\"type\":\"Scripted\",\"language\":\"English\",\"genres\":[\"Drama\",\"Science-Fiction\",\"Thriller\"],\"status\":\"Ended\",\"runtime\":60,\"premiered\":\"2013-06-24\",\"officialSite\":\"http://www.cbs.com/shows/under-the-dome/\",\"schedule\":{\"time\":\"22:00\",\"days\":[\"Thursday\"]},\"rating\":{\"average\":6.5},\"weight\":94,\"network\":{\"id\":2,\"name\":\"CBS\",\"country\":{\"name\":\"United States\",\"code\":\"US\",\"timezone\":\"America/New_York\"}},\"webChannel\":null,\"externals\":{\"tvrage\":25988,\"thetvdb\":264492,\"imdb\":\"tt1553656\"},\"image\":{\"medium\":\"http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg\",\"original\":\"http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg\"},\"summary\":\"<p><b>Under the Dome</b> is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.</p>\",\"updated\":1490211618,\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/shows/1\"},\"previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/185054\"}}}]";

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void Test() {
		doReturn(Observable.just(shows)).when(router).listShows(anyInt());
		router.listShows(0).map(new Function<String, List<Show>>() {
			@Override
			public List<Show> apply(String s) throws Exception {
				return LoganSquare.parseList(s,Show.class);
			}
		}).subscribe();
	}
}
