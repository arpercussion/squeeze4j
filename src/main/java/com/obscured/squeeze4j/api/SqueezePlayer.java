package com.obscured.squeeze4j.api;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.obscured.squeeze4j.enums.PlayerMode;
import com.obscured.squeeze4j.models.SongInfo;
import com.obscured.squeeze4j.models.Status;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    public Status getStatus() {
        Status results = null;
        try {
            List<Object> list = new ArrayList<>(Arrays.asList("status", "-", 1, "tags:cgABbehldiqtyrSuoKLNJ"));
            String params = setParameters(this.playerId, list);
            results = request(Status.class, params);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return results;
    }

    /**
     * Jump to a particular position in a track by specifying a number of seconds to seek to
     *
     * @param seconds position in track
     * @return if null then get time, otherwise set time
     */
    public Double seek(Double seconds) {
        Double time = null;
        try {
            String arg = (seconds == null) ? "?" : Double.toString(seconds);
            String params = setParameters(this.playerId, Arrays.asList("time", arg));
            JsonNode jsonNode = request(params);
            JSONObject obj = jsonNode.getObject();
            JSONObject result = obj.optJSONObject("result");
            time = result.optDouble("_time", 0.0);
        } catch (UnirestException e) {
            logger.error(e);
        }
        return time;
    }

    /**
     * Get path of currently playing track
     *
     * @return the path to the track
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
     * Set the player mode
     *
     * @param mode  play, pause, mute, ...
     * @param state null, 0, 1
     */
    public void mode(PlayerMode mode, Integer state) {
        List<Object> modeList = playerModeToModeList(mode);
        if (modeList != null) {
            if (state != null) {
                // some modes like repeat and shuffle can be 0,1,2 for now only support 0,1
                state = (state >= 1) ? 1 : 0;
                modeList.add(state);
            }
            String params = setParameters(this.playerId, modeList);
            try {
                request(params);
            } catch (UnirestException e) {
                logger.error(e);
            }
        } else {
            logger.error("Unknown PlaylistMode given");
        }
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
    public Integer volume(Integer state) {
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
     * Get the track info of the currently playing track including the cover id url
     *
     * @return SongInfo
     */
    public SongInfo getCurrentlyPlaying() {
        SongInfo trackInfo = null;
        String path = getPath();
        if (StringUtils.isNotEmpty(path)) {
            SqueezeServer squeezeServer = new SqueezeServer();
            trackInfo = squeezeServer.getTrackInfo(path);
            if (trackInfo != null) {
                if (StringUtils.isEmpty(trackInfo.getCoverId())) {
                    trackInfo.setCoverId("unknown");
                }
                trackInfo.setCoverUrl("/music/" + trackInfo.getCoverId() + "/cover.jpg");
            }
        }
        return trackInfo;
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
     * Play a track, or play tracks by artist, album or genre
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

        if (Stream.of(url, genre, artist, album).allMatch(StringUtils::isEmpty)) {
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
