package com.aghafari.tvmaze;

import com.aghafari.tvmaze.model.Show;
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
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;

/**
 * Created by amir on 8/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApiTest {
	@Mock
	private ShowsRouter router;
	@Mock
	private Exception exception;
	private String mockShow = "\n" +
			"{\"id\":1,\"url\":\"http://www.tvmaze.com/shows/1/under-the-dome\",\"name\":\"Under the Dome\",\"type\":\"Scripted\",\"language\":\"English\",\"genres\":[\"Drama\",\"Science-Fiction\",\"Thriller\"],\"status\":\"Ended\",\"runtime\":60,\"premiered\":\"2013-06-24\",\"officialSite\":\"http://www.cbs.com/shows/under-the-dome/\",\"schedule\":{\"time\":\"22:00\",\"days\":[\"Thursday\"]},\"rating\":{\"average\":6.5},\"weight\":94,\"network\":{\"id\":2,\"name\":\"CBS\",\"country\":{\"name\":\"United States\",\"code\":\"US\",\"timezone\":\"America/New_York\"}},\"webChannel\":null,\"externals\":{\"tvrage\":25988,\"thetvdb\":264492,\"imdb\":\"tt1553656\"},\"image\":{\"medium\":\"http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg\",\"original\":\"http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg\"},\"summary\":\"<p><b>Under the Dome</b> is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.</p>\",\"updated\":1490211618,\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/shows/1\"},\"previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/185054\"}}}";
	private String mockShows = "[\n" +
			"{\"id\":1,\"url\":\"http://www.tvmaze.com/shows/1/under-the-dome\",\"name\":\"Under the Dome\",\"type\":\"Scripted\",\"language\":\"English\",\"genres\":[\"Drama\",\"Science-Fiction\",\"Thriller\"],\"status\":\"Ended\",\"runtime\":60,\"premiered\":\"2013-06-24\",\"officialSite\":\"http://www.cbs.com/shows/under-the-dome/\",\"schedule\":{\"time\":\"22:00\",\"days\":[\"Thursday\"]},\"rating\":{\"average\":6.5},\"weight\":94,\"network\":{\"id\":2,\"name\":\"CBS\",\"country\":{\"name\":\"United States\",\"code\":\"US\",\"timezone\":\"America/New_York\"}},\"webChannel\":null,\"externals\":{\"tvrage\":25988,\"thetvdb\":264492,\"imdb\":\"tt1553656\"},\"image\":{\"medium\":\"http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg\",\"original\":\"http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg\"},\"summary\":\"<p><b>Under the Dome</b> is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.</p>\",\"updated\":1490211618,\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/shows/1\"},\"previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/185054\"}}},\n" +
			"{\"id\":1,\"url\":\"http://www.tvmaze.com/shows/1/under-the-dome\",\"name\":\"Under the Dome\",\"type\":\"Scripted\",\"language\":\"English\",\"genres\":[\"Drama\",\"Science-Fiction\",\"Thriller\"],\"status\":\"Ended\",\"runtime\":60,\"premiered\":\"2013-06-24\",\"officialSite\":\"http://www.cbs.com/shows/under-the-dome/\",\"schedule\":{\"time\":\"22:00\",\"days\":[\"Thursday\"]},\"rating\":{\"average\":6.5},\"weight\":94,\"network\":{\"id\":2,\"name\":\"CBS\",\"country\":{\"name\":\"United States\",\"code\":\"US\",\"timezone\":\"America/New_York\"}},\"webChannel\":null,\"externals\":{\"tvrage\":25988,\"thetvdb\":264492,\"imdb\":\"tt1553656\"},\"image\":{\"medium\":\"http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg\",\"original\":\"http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg\"},\"summary\":\"<p><b>Under the Dome</b> is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.</p>\",\"updated\":1490211618,\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/shows/1\"},\"previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/185054\"}}}]";

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void GetList() {
		doReturn(Observable.just(mockShows)).when(router).listShows(anyInt());
		router.listShows(0).map(new Function<String, List<Show>>() {
			@Override
			public List<Show> apply(String s) throws Exception {
				return LoganSquare.parseList(s, Show.class);
			}
		}).doOnNext(new Consumer<List<Show>>() {
			@Override
			public void accept(@NonNull List<Show> shows) throws Exception {
				assertEquals(shows.size(), 2);
			}
		}).subscribe();
	}

	@Test
	public void GetListThrowable() {
		doReturn(Observable.error(exception)).when(router).listShows(anyInt());
		router.listShows(0).map(new Function<String, List<Show>>() {
			@Override
			public List<Show> apply(String s) throws Exception {
				return LoganSquare.parseList(s, Show.class);
			}
		}).subscribe(new Consumer<List<Show>>() {
			@Override
			public void accept(@NonNull List<Show> shows) throws Exception {
			}
		}, new Consumer<Throwable>() {
			@Override
			public void accept(@NonNull Throwable throwable) throws Exception {
				assertEquals(throwable, exception);
			}
		});
	}

	@Test
	public void GetSingle() {
		doReturn(Observable.just(mockShow)).when(router).singleShow(anyInt());
		router.singleShow(1).map(new Function<String, Show>() {
			@Override
			public Show apply(String s) throws Exception {
				return LoganSquare.parse(s, Show.class);
			}
		}).doOnNext(new Consumer<Show>() {
			@Override
			public void accept(@NonNull Show shows) throws Exception {
				assertEquals(shows.getId(), 1);
			}
		}).subscribe();
	}

	@Test
	public void GetSingleThrowable() {
		doReturn(Observable.error(exception)).when(router).singleShow(anyInt());
		router.singleShow(1).map(new Function<String, Show>() {
			@Override
			public Show apply(String s) throws Exception {
				return LoganSquare.parse(s, Show.class);
			}
		}).subscribe(new Consumer<Show>() {
			@Override
			public void accept(@NonNull Show show) throws Exception {

			}
		}, new Consumer<Throwable>() {
			@Override
			public void accept(@NonNull Throwable throwable) throws Exception {
				assertEquals(throwable,exception);
			}
		});
	}
}
