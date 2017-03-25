package com.obscured.squeeze4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.obscured.squeeze4j.Config;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collection;

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
		HttpResponse<T> result = Unirest.post(Config.get("lms_address"))
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
		HttpResponse<JsonNode> result = Unirest.post(Config.get("lms_address"))
		                                       .header("accept", "application/json")
		                                       .basicAuth(Config.get("lms_username"), Config.get("lms_password"))
		                                       .body(params)
		                                       .asJson();
		return (result.getStatus() == 200) ? result.getBody() : null;
	}
}
