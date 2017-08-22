package com.obscured.squeeze4j.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.obscured.squeeze4j.models.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class SqueezeServer extends SlimRequest {

    private static final Logger logger = LogManager.getLogger(SqueezeServer.class);

    /**
     * The the list of players known to the LMS instance
     *
     * @return Players object
     */
    public Players getPlayers() {
        Players players = null;
        try {
            String params = setParameters(null, Arrays.asList("players", "-"));
            players = request(Players.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return players;
    }

    /**
     * Get artists matching artist name, or all. supports paging
     *
     * @param artist search by artist or all if empty
     * @param skip   start at index
     * @param take   page size
     * @return Artists object
     */
    public Artists getArtists(String artist, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("artists", s, t));
        if (StringUtils.isNotEmpty(artist)) {
            list.add("search:" + artist);
        }
        String params = setParameters(null, list);

        Artists artists = null;
        try {
            artists = request(Artists.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return artists;

    }

    /**
     * Get albums matching album title, or all. supports paging
     *
     * @param album search by album or all if empty
     * @param skip  start at index
     * @param take  page size
     * @return Albums object
     */
    public Albums getAlbums(String album, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("albums", s, t, "tags:tSS"));
        if (StringUtils.isNotEmpty(album)) {
            list.add("search:" + album);
        }
        String params = setParameters(null, list);

        Albums albums = null;
        try {
            albums = request(Albums.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return albums;

    }

    /**
     * Get songs matching song title, or all. supports paging
     *
     * @param song search by song or all if empty
     * @param skip start at index
     * @param take page size
     * @return Title object
     */
    public Tracks getTracks(String song, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("songs", s, t, "tags:seuSp"));
        if (StringUtils.isNotEmpty(song)) {
            list.add("search:" + song);
        }
        String params = setParameters(null, list);

        Tracks songs = null;
        try {
            songs = request(Tracks.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return songs;

    }

    /**
     * Get genres matching genre name, or all. supports paging
     *
     * @param genre search by genre or all if empty
     * @param skip  start at index
     * @param take  page size
     * @return Genres object
     */
    public Genres getGenres(String genre, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("genres", s, t));
        if (StringUtils.isNotEmpty(genre)) {
            list.add("search:" + genre);
        }
        String params = setParameters(null, list);

        Genres genres = null;
        try {
            genres = request(Genres.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return genres;

    }

    /**
     * Get playlists matching playlist name, or all. supports paging
     *
     * @param playlist search by playlist or all if empty
     * @param skip     start at index
     * @param take     page size
     * @return Playlists object
     */
    public Playlists getPlaylists(String playlist, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "0";
        String t = (take != null && take >= 1) ? take.toString() : "10000";
        List<Object> list = new ArrayList<>(Arrays.asList("playlists", s, t, "tags:u"));
        if (StringUtils.isNotEmpty(playlist)) {
            list.add("search:" + playlist);
        }
        String params = setParameters(null, list);

        Playlists playlists = null;
        try {
            playlists = request(Playlists.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return playlists;

    }

    /**
     * Get albums matching artist id.  supports paging
     *
     * @param artistId filter by artist id
     * @param skip     start at index
     * @param take     page size
     * @return Albums object
     */
    public Albums getAlbumsByArtistId(long artistId, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("albums", s, t, "artist_id:" + artistId, "tags:tSS"));
        String params = setParameters(null, list);
        Albums albums = null;
        try {
            albums = request(Albums.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return albums;
    }

    /**
     * Get songs matching album id. supports paging
     *
     * @param albumId filter by album id
     * @param skip    start at index
     * @param take    page size
     * @return Titles object
     */
    public Tracks getTracksByAlbumId(long albumId, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("songs", s, t, "album_id:" + albumId, "tags:seuSp"));
        String params = setParameters(null, list);
        Tracks titles = null;
        try {
            titles = request(Tracks.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return titles;
    }

    /**
     * Get songs matching artists id. supports paging
     *
     * @param artistId search by artist id
     * @param skip     start at index
     * @param take     page size
     * @return Titles object
     */
    public Tracks getTracksByArtistId(long artistId, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("songs", s, t, "artist_id:" + artistId, "tags:seuSp"));
        String params = setParameters(null, list);
        Tracks titles = null;
        try {
            titles = request(Tracks.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return titles;
    }

    /**
     * Get songs matching genre id. supports paging
     *
     * @param genreId filter by genre id
     * @param skip    start at index
     * @param take    page size
     * @return Titles object
     */
    public Tracks getTracksByGenreId(long genreId, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "_";
        String t = (take != null && take >= 1) ? take.toString() : "_";
        List<Object> list = new ArrayList<>(Arrays.asList("songs", s, t, "genre_id:" + genreId, "tags:seuSp"));
        String params = setParameters(null, list);
        Tracks titles = null;
        try {
            titles = request(Tracks.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return titles;
    }

    public Search search(String term, Integer skip, Integer take) {
        String s = (skip != null && skip >= 0) ? skip.toString() : "0";
        String t = (take != null && take >= 1) ? take.toString() : "5";
        List<Object> list = new ArrayList<>(Arrays.asList("search", s, t, "term:" + term, "extended:1"));
        String params = setParameters(null, list);
        Search results = null;
        try {
            results = request(Search.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return results;
    }

    /**
     * Get the song info given a path or track id
     *
     * @param trackIdOrUrl the path or the track id
     * @return SongInfo object
     */
    public SongInfo getSongInfo(String trackIdOrUrl) {
        List<Object> args = new ArrayList<>();
        args.addAll(Arrays.asList("songinfo", "0", "100", "tags:algcu"));
        if (trackIdOrUrl.contains("file://")) {
            args.add("url:" + trackIdOrUrl);
        } else {
            args.add("track_id:" + trackIdOrUrl);
        }

        SongInfo songInfo = null;
        JSONObject jobj = new JSONObject();
        try {
            String params = setParameters(null, args);
            JsonNode jsonNode = request(params);
            JSONObject root = jsonNode.getObject();
            JSONObject result = root.optJSONObject("result");
            JSONArray songInfoLoop = result.optJSONArray("songinfo_loop");
            int length = songInfoLoop.length();
            for (int x = 0; x < length; x += 1) {
                JSONObject obj = songInfoLoop.optJSONObject(x);
                Iterator<String> it = obj.keys();
                while (it.hasNext()) {
                    String key = it.next();
                    jobj.put(key, obj.opt(key));
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            songInfo = mapper.readValue(jobj.toString(), SongInfo.class);
        } catch (Exception e) {
            logger.error(e);
        }

        return songInfo;
    }

    /**
     * Get totals for artists, album, songs, and genres
     *
     * @return Map of type=>count
     */
    public Map<String, Long> getTotals() {
        return Arrays.asList("artists", "albums", "songs", "genres")
                .parallelStream()
                .map(item -> {
                    Pair<String, Long> pair = null;
                    try {
                        String params = setParameters(null, Arrays.asList("info", "total", item, "?"));
                        JsonNode jsonNode = request(params);
                        JSONObject obj = jsonNode.getObject();
                        JSONObject result = obj.optJSONObject("result");
                        long value = result.optLong("_" + item);
                        pair = Pair.of(item, value);
                    } catch (UnirestException e) {
                        logger.error(e);
                    }
                    return pair;
                })
                .collect(Collectors.toConcurrentMap(Pair::getKey, Pair::getValue));
    }

    /**
     * Get the cover art
     *
     * @param path the cover art path
     * @return InputStream or null
     */
    public InputStream getCoverImage(String path) {
        InputStream result = null;
        try {
            result = this.download(path);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return result;
    }
}
