package com.obscured.squeeze4j.api;

import com.obscured.squeeze4j.models.*;
import org.junit.*;

import java.util.Map;

@Ignore
public class SqueezeServerTest {
	private static SqueezeServer server;

	@BeforeClass
	public static void beforeClass() {
		server = new SqueezeServer();
	}

	@AfterClass
	public static void afterClass() {
		server = null;
	}

	@Test
	public void getPlayers() throws Exception {
		Players players = server.getPlayers();

		Assert.assertNotNull("Players is null", players);
		Assert.assertNotNull("Players no count", players.getCount());
	}

	@Test
	public void getArtists() throws Exception {
		Artists artists = server.getArtists(null, null, null);

		Assert.assertNotNull("Artists is null", artists);
		Assert.assertNotNull("Artists no count", artists.getCount());
	}

	@Test
	public void getAlbums() throws Exception {
		Albums albums = server.getAlbums(null, null, null);

		Assert.assertNotNull("Albums is null", albums);
		Assert.assertNotNull("Albums no count", albums.getCount());
	}

	@Test
	public void getSongs() throws Exception {
		Tracks songs = server.getTracks("one", null, null);

		Assert.assertNotNull("Songs is null", songs);
		Assert.assertNotNull("Songs no count", songs.getCount());
	}

	@Test
	public void getGenres() throws Exception {
		Genres genres = server.getGenres(null, null, null);

		Assert.assertNotNull("Genres is null", genres);
		Assert.assertNotNull("Genres no count", genres.getCount());
	}

	@Test
	public void getPlaylists() throws Exception {
		Playlists playlists = server.getPlaylists(null, null, null);

		Assert.assertNotNull("Players is null", playlists);
		Assert.assertNotNull("Players no count", playlists.getCount());
	}

	@Test
	public void getAlbumsByArtistId() throws Exception {
		Albums albums = server.getAlbumsByArtistId(3911, null, null);

		Assert.assertNotNull("Albums is null", albums);
		Assert.assertNotNull("Albums no count", albums.getCount());
	}

	@Test
	public void getSongsByAlbumId() throws Exception {
		Tracks songs = server.getTracksByAlbumId(3489, null, null);

		Assert.assertNotNull("Songs is null", songs);
		Assert.assertNotNull("Songs no count", songs.getCount());
	}

	@Test
	public void getSongsByArtistId() throws Exception {
		Tracks songs = server.getTracksByAlbumId(3911, null, null);

		Assert.assertNotNull("Songs is null", songs);
		Assert.assertNotNull("Songs no count", songs.getCount());
	}

	@Test
	public void getSongsByGenreId() throws Exception {
		Tracks songs = server.getTracksByAlbumId(397, null, null);

		Assert.assertNotNull("Songs is null", songs);
		Assert.assertNotNull("Songs no count", songs.getCount());
	}

	@Test
	public void getTotals() throws Exception {
		Map<String, Long> totals = server.getTotals();

		Assert.assertNotNull("Totals is null", totals);
		Assert.assertNotNull("Totals no artists", totals.get("artists"));
	}
}