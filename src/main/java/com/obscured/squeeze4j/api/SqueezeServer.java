package com.obscured.squeeze4j.api;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.obscured.squeeze4j.models.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SqueezeServer extends SlimRequest {

	private static final Logger logger = LogManager.getLogger(SqueezeServer.class);

	/**
	 * The the list of players known to the LMS instance
	 *
	 * @return Players object
	 */
	public PlayerWrapper getPlayers() {
		PlayerWrapper players = null;
		try {
			String params = setParameters(null, Arrays.asList("players", "-"));
			players = request(PlayerWrapper.class, params);
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
	public ArtistWrapper getArtists(String artist, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("artists", s, t);
		if (StringUtils.isNotEmpty(artist)) {
			list.add("search:" + artist);
		}
		String params = setParameters(null, list);

		ArtistWrapper artists = null;
		try {
			artists = request(ArtistWrapper.class, params);
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
	public AlbumWrapper getAlbums(String album, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("albums", s, t, "tags:tSS");
		if (StringUtils.isNotEmpty(album)) {
			list.add("search:" + album);
		}
		String params = setParameters(null, list);

		AlbumWrapper albums = null;
		try {
			albums = request(AlbumWrapper.class, params);
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
	public TitleWrapper getSongs(String song, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("songs", s, t, "tags:seuSp");
		if (StringUtils.isNotEmpty(song)) {
			list.add("search:" + song);
		}
		String params = setParameters(null, list);

		TitleWrapper songs = null;
		try {
			songs = request(TitleWrapper.class, params);
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
	public GenreWrapper getGenres(String genre, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("genres", s, t);
		if (StringUtils.isNotEmpty(genre)) {
			list.add("search:" + genre);
		}
		String params = setParameters(null, list);

		GenreWrapper genres = null;
		try {
			genres = request(GenreWrapper.class, params);
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
	public PlaylistWrapper getPlaylists(String playlist, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "0";
		String t = (take != null && take >= 1) ? take.toString() : "10000";
		List<Object> list = Arrays.asList("playlists", s, t, "tags:u");
		if (StringUtils.isNotEmpty(playlist)) {
			list.add("search:" + playlist);
		}
		String params = setParameters(null, list);

		PlaylistWrapper playlists = null;
		try {
			playlists = request(PlaylistWrapper.class, params);
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
	public AlbumWrapper getAlbumsByArtistId(long artistId, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("albums", s, t, "artist_id:" + artistId, "tags:tSS");
		String params = setParameters(null, list);
		AlbumWrapper albums = null;
		try {
			albums = request(AlbumWrapper.class, params);
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
	public TitleWrapper songsByAlbumId(long albumId, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("songs", s, t, "album_id:" + albumId, "tags:seuSp");
		String params = setParameters(null, list);
		TitleWrapper titles = null;
		try {
			titles = request(TitleWrapper.class, params);
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
	public TitleWrapper songsByArtistId(long artistId, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("songs", s, t, "artist_id:" + artistId, "tags:seuSp");
		String params = setParameters(null, list);
		TitleWrapper titles = null;
		try {
			titles = request(TitleWrapper.class, params);
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
	public TitleWrapper songsByGenreId(long genreId, Integer skip, Integer take) {
		String s = (skip != null && skip >= 0) ? skip.toString() : "_";
		String t = (take != null && take >= 1) ? take.toString() : "_";
		List<Object> list = Arrays.asList("songs", s, t, "genre_id:" + genreId, "tags:seuSp");
		String params = setParameters(null, list);
		TitleWrapper titles = null;
		try {
			titles = request(TitleWrapper.class, params);
		} catch (UnirestException e) {
			logger.error(e);
		}
		return titles;
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

}
