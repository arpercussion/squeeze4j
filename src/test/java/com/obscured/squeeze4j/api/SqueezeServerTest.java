package com.obscured.squeeze4j.api;

import com.obscured.squeeze4j.models.*;
import org.junit.*;

import java.io.InputStream;
import java.util.Map;

@Ignore
public class SqueezeServerTest extends BaseTest {
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
    public void getTracks() throws Exception {
        Tracks tracks = server.getTracks("one", null, null);

        Assert.assertNotNull("Tracks is null", tracks);
        Assert.assertNotNull("Tracks no count", tracks.getCount());
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
    public void getTracksByAlbumId() throws Exception {
        Tracks tracks = server.getTracksByAlbumId(3489, null, null);

        Assert.assertNotNull("Tracks is null", tracks);
        Assert.assertNotNull("Tracks no count", tracks.getCount());
    }


    @Test
    public void getTotals() throws Exception {
        Map<String, Long> totals = server.getTotals();

        Assert.assertNotNull("Totals is null", totals);
        Assert.assertNotNull("Totals no artists", totals.get("artists"));
    }

    @Test
    public void search() throws Exception {
        Search search = server.search("dream", null, null);

        Assert.assertNotNull("search is null", search);
        Assert.assertNotNull("search no results", search.getAlbumsCount());
    }

    @Test
    public void getTracksByArtistId() {
        Tracks tracks = server.getTracksByArtistId(4738, null, null);

        Assert.assertNotNull("getTracksByArtistId is null", tracks);
        Assert.assertNotNull("getTracksByArtistId no results", tracks.getCount());

    }

    @Test
    public void getTracksByGenreId() {
        Tracks tracks = server.getTracksByGenreId(502, null, null);

        Assert.assertNotNull("getTracksByGenreId is null", tracks);
        Assert.assertNotNull("getTracksByGenreId no results", tracks.getCount());

    }

    @Test
    public void cover() throws Exception {
        InputStream result = server.getCoverImage("/music/48692/cover.jpg");

        Assert.assertNotNull("cover is null", result);
    }

    @Test
    public void getTrackInfo() throws Exception {
        SongInfo trackInfo = server.getTrackInfo(PATH);

        Assert.assertNotNull("getTrackInfo is null", trackInfo);
    }
}