package com.obscured.squeeze4j.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.obscured.squeeze4j.models.Mode;
import com.obscured.squeeze4j.models.SongInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import java.util.stream.Stream;

public class SqueezePlayer extends SlimRequest {

	private static final Logger logger = LogManager.getLogger(SqueezePlayer.class);

	private String playerId;

	/**
	 * ctor load with player id to perform actions against
	 *
	 * @param playerId the player id
	 */
	public SqueezePlayer(String playerId) {
		this.playerId = playerId;
	}

	/**
	 * Get the player mode
	 *
	 * @return Mode
	 */
	public Mode getMode() {
		Mode rmode = null;
		try {
			// whether play, pause, stop
			String params = setParameters(this.playerId, Arrays.asList("mode", "?"));
			JsonNode jsonNode = request(params);
			JSONObject obj = jsonNode.getObject();
			JSONObject result = obj.optJSONObject("result");
			String mode = result.optString("_mode", StringUtils.EMPTY);
			rmode = Mode.fromLabel(mode);

			// whether muted
			Boolean muted = mute(null);
			rmode = (muted) ? Mode.MUTE : rmode;
		} catch (UnirestException e) {
			logger.error(e);
		}
		return rmode;
	}

	/**
	 * Get path of currently playing song
	 *
	 * @return the path to the song
	 */
	public String getPath() {
		String rpath = null;
		try {
			String params = setParameters(this.playerId, Arrays.asList("path", "?"));
			JsonNode jsonNode = request(params);
			JSONObject obj = jsonNode.getObject();
			JSONObject result = obj.optJSONObject("result");
			rpath = result.optString("_path", StringUtils.EMPTY);
		} catch (UnirestException e) {
			logger.error(e);
		}
		return rpath;
	}

	/**
	 * Get the song info given a path or track id
	 *
	 * @param trackIdOrUrl the path or the track id
	 * @return SongInfo object
	 */
	public SongInfo getSongInfo(String trackIdOrUrl) {
		List<Object> args = new ArrayList<>();
		args.addAll(Arrays.asList("songinfo", "0", "100", "tags:algc"));
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
	 * Toggle pause
	 *
	 * @param state 0/1
	 */
	public void pause(int state) {
		state = (state >= 1) ? 1 : 0;
		String params = setParameters(this.playerId, Arrays.asList("pause", state));
		try {
			request(params);
		} catch (UnirestException e) {
			logger.error(e);
		}
	}

	/**
	 * Toggle mute or get current mute state if null
	 *
	 * @param state 0/1/null
	 * @return Mute state or null if setting state
	 */
	public Boolean mute(Integer state) {
		Boolean rbool = null;
		try {
			String arg = (state == null) ? "?" : (state >= 1) ? "1" : "0";
			String params = setParameters(this.playerId, Arrays.asList("mixer", "muting", arg));
			JsonNode jsonNode = request(params);
			JSONObject obj = jsonNode.getObject();
			JSONObject result = obj.optJSONObject("result");
			int muted = result.optInt("_muting", -1);
			if (muted != -1) {
				rbool = (muted == 1);
			}
		} catch (UnirestException e) {
			logger.error(e);
		}
		return rbool;
	}

	/**
	 * Toggle stop
	 */
	public void stop() {
		String params = setParameters(this.playerId, Collections.singletonList("stop"));
		try {
			request(params);
		} catch (UnirestException e) {
			logger.error(e);
		}
	}

	/**
	 * Toggle power state or get state if null
	 *
	 * @param state 0/1/null
	 * @return Power state or null if setting state
	 */
	public Boolean power(Integer state) {
		Boolean power = null;
		try {
			String arg = (state == null) ? "?" : (state >= 1) ? "1" : "0";
			String params = setParameters(this.playerId, Arrays.asList("power", arg));
			JsonNode jsonNode = request(params);
			JSONObject root = jsonNode.getObject();
			JSONObject result = root.optJSONObject("result");
			int p = result.optInt("_power", -1);
			power = (p == -1) ? null : (p >= 1);
		} catch (UnirestException e) {
			logger.error(e);
		}
		return power;
	}

	/**
	 * Move to previous track
	 */
	public void previous() {
		try {
			String params = setParameters(this.playerId, Arrays.asList("button", "jump_rew"));
			request(params);
		} catch (UnirestException e) {
			logger.error(e);
		}
	}

	/**
	 * Move to next track
	 */
	public void next() {
		try {
			String params = setParameters(this.playerId, Arrays.asList("button", "jump_fwd"));
			request(params);
		} catch (UnirestException e) {
			logger.error(e);
		}
	}

	/**
	 * Set or get volume level
	 *
	 * @param state 0/1/null
	 * @return Volume level or null if setting volume
	 */
	public int volume(Integer state) {
		Integer volume = null;
		try {
			String arg = (state == null) ? "?" : (state > 100) ? "100" : (state < 0) ? "0" : state.toString();
			String params = setParameters(this.playerId, Arrays.asList("mixer", "volume", arg));
			JsonNode jsonNode = request(params);
			JSONObject root = jsonNode.getObject();
			JSONObject result = root.optJSONObject("result");
			int v = result.optInt("_volume", -1);
			volume = (v == -1) ? null : v;
		} catch (UnirestException e) {
			logger.error(e);
		}
		return volume;
	}

	/**
	 * Get the song info of the currently playing song including the cover id url
	 *
	 * @return SongInfo
	 */
	public SongInfo getCurrentlyPlaying() {
		SongInfo songInfo = null;
		String path = getPath();
		if (StringUtils.isNotEmpty(path)) {
			songInfo = getSongInfo(path);
			if (songInfo != null) {
				if (StringUtils.isEmpty(songInfo.getCoverId())) {
					songInfo.setCoverId("unknown");
				}
				songInfo.setCoverUrl("/music/" + songInfo.getCoverId() + "/cover.jpg");
			}
		}
		return songInfo;
	}

	public void play() {
		String params = setParameters(this.playerId, Collections.singletonList("play"));
		try {
			request(params);
		} catch (UnirestException e) {
			logger.error(e);
		}
	}

	/**
	 * Play a song, or play songs by artist, album or genre
	 *
	 * @param url    path to a track
	 * @param genre  the genre name
	 * @param artist the artist name
	 * @param album  the album title
	 */
	public void play(String url, String genre, String artist, String album) {
		List<Object> args;
		String mgenre = (StringUtils.isEmpty(genre)) ? "*" : genre;
		String martist = (StringUtils.isEmpty(artist)) ? "*" : artist;
		String malbum = (StringUtils.isEmpty(album)) ? "*" : album;

		if (Stream.of(url, genre, artist, album).allMatch(String::isEmpty)) {
			args = Arrays.asList("play");
		} else if (StringUtils.isNotEmpty(url)) {
			args = Arrays.asList("playlist", "play", url);
		} else {
			args = Arrays.asList("playlist", "loadalbum", mgenre, martist, malbum);
		}

		try {
			String params = setParameters(this.playerId, args);
			request(params);
		} catch (UnirestException e) {
			logger.error(e);
		}
	}

	/**
	 * Play a specific playlist by id
	 *
	 * @param playlistId the playlist id to play
	 * @return the count of tracks for this playlist
	 */
	public int playPlaylist(String playlistId) {
		Integer count = null;
		try {
			String params = setParameters(this.playerId, Arrays.asList("playlistcontrol", "cmd:load", "playlist_id:" + playlistId));
			JsonNode jsonNode = request(params);
			JSONObject root = jsonNode.getObject();
			JSONObject result = root.optJSONObject("result");
			count = result.optInt("count", -1);
		} catch (UnirestException e) {
			logger.error(e);
		}
		return count;
	}
}
