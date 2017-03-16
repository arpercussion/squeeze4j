package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"url",
		"playlist"
})
public class Playlists {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("url")
	private String url;

	@JsonProperty("playlist")
	private String playlist;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("playlist")
	public String getPlaylist() {
		return playlist;
	}

	@JsonProperty("playlist")
	public void setPlaylist(String playlist) {
		this.playlist = playlist;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(url).append(id).append(playlist).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Playlists)) {
			return false;
		}
		Playlists rhs = ((Playlists) other);
		return new EqualsBuilder().append(url, rhs.url)
		                          .append(id, rhs.id)
		                          .append(playlist, rhs.playlist)
		                          .isEquals();
	}

}
