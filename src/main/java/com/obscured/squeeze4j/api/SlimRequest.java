package com.obscured.squeeze4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.obscured.squeeze4j.Config;
import com.obscured.squeeze4j.converters.Utilities;
import com.obscured.squeeze4j.enums.PlayerMode;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

abstract class SlimRequest {

    /**
     * ctor setup the default object mapper for requests
     */
    SlimRequest() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private final com.fasterxml.jackson.databind.ObjectMapper mapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    if (StringUtils.contains(value, "result")) {
                        JsonNode jsonNode = new JsonNode(value);
                        Object result = jsonNode.getObject().opt("result");
                        if (result != null) {
                            value = result.toString();
                        }
                    }
                    return mapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * Create the parameters to pass to request
     *
     * @param playerId the player to issue command against
     * @param params   parameters NOTE: order may matter to some calls
     * @return the parameters to pass to request
     */
    String setParameters(String playerId, Collection<Object> params) {
        String json = "{\"id\":1,\"method\":\"slim.request\",\"params\":[]}";
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("params");

        playerId = (StringUtils.isNotEmpty(playerId)) ? playerId : "00:00:00:00:00:00";
        jsonArray.put(playerId);
        jsonArray.put(params);
        return jsonObject.toString();
    }

    /**
     * Make request and convert to type
     *
     * @param clazz  expected return type
     * @param params the parameters for the request
     * @param <T>    the type to convert to
     * @return converted json payload to this type
     * @throws UnirestException exception when request is bad
     */
    <T> T request(Class<T> clazz, String params) throws UnirestException {
        String url = buildUrl(null);
        HttpResponse<T> result = Unirest.post(url)
                .header("accept", "application/json")
                .basicAuth(Config.get("lms_username"), Config.get("lms_password"))
                .body(params)
                .asObject(clazz);
        return (result.getStatus() == 200) ? result.getBody() : null;
    }

    /**
     * Make request but no conversion (other than to json)
     *
     * @param params the parameters for the request
     * @return json object
     * @throws UnirestException exception when request is bad
     */
    JsonNode request(String params) throws UnirestException {
        String url = buildUrl(null);
        HttpResponse<JsonNode> result = Unirest.post(url)
                .header("accept", "application/json")
                .basicAuth(Config.get("lms_username"), Config.get("lms_password"))
                .body(params)
                .asJson();
        return (result.getStatus() == 200) ? result.getBody() : null;
    }

    /**
     * Download file at given path
     *
     * @param path the path for the request appended to base url
     * @return InputStream
     * @throws UnirestException exception when request is bad
     */
    InputStream download(String path) throws UnirestException {
        String url = buildUrl(path);
        HttpResponse<InputStream> result = Unirest.get(url)
                .header("content-type", "*/*")
                .basicAuth(Config.get("lms_username"), Config.get("lms_password"))
                .asBinary();
        return (result.getStatus() == 200) ? result.getBody() : null;
    }

    List<Object> playerModeToModeList(PlayerMode mode) {
        List<Object> _mode = null;
        if (Stream.of(PlayerMode.PAUSE, PlayerMode.RESUME).anyMatch(m -> m == mode)) {
            _mode = Arrays.asList("pause");
        } else if (Stream.of(PlayerMode.PLAY, PlayerMode.CONTINUE, PlayerMode.KEEP_GOING).anyMatch(m -> m == mode)) {
            _mode = Arrays.asList("play");
        } else if (Stream.of(PlayerMode.MUTE, PlayerMode.UNMUTE).anyMatch(m -> m == mode)) {
            _mode = Arrays.asList("mixer", "muting");
        } else if (Stream.of(PlayerMode.REPEAT, PlayerMode.REPEAT_ON, PlayerMode.REPEAT_OFF).anyMatch(m -> m == mode)) {
            _mode = Arrays.asList("playlist", "repeat");
        } else if (Stream.of(PlayerMode.SHUFFLE, PlayerMode.SHUFFLE_ON, PlayerMode.SHUFFLE_OFF,
                PlayerMode.TURN_ON_SHUFFLE, PlayerMode.TURN_OFF_SHUFFLE, PlayerMode.STOP_SHUFFLING,
                PlayerMode.SHUFFLE_THE_MUSIC).anyMatch(m -> m == mode)) {
            _mode = Arrays.asList("playlist", "shuffle");
        } else if (PlayerMode.STOP == mode) {
            _mode = Arrays.asList("stop");
        }
        return _mode;
    }

    private String buildUrl(String path) {
        String url = null;
        String hostname = Config.get("lms_hostname");
        String port = Config.get("lms_port");
        path = StringUtils.isEmpty(path) ? "/jsonrpc.js" : path;
        if (Stream.of("http://", "https://").noneMatch(hostname::startsWith)) {
            hostname = "http://" + hostname;
        }
        try {
            Integer mport;
            URI uri = new URI(hostname);
            if (uri.getPort() != -1 && port == null) {
                mport = uri.getPort();
            } else {
                mport = Utilities.tryParseInteger(port);
            }
            if (mport == null) {
                mport = -1;
            }
            uri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), mport, path, null, null);
            url = uri.toString();
        } catch (URISyntaxException e) {
            // noop
        }
        return url;
    }
}
