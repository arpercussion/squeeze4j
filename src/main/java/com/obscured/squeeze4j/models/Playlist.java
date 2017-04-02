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
public class Playlist {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("url")
	private String url;

	@JsonProperty("playlist")
	private String playlist;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPlaylist() {
		return playlist;
	}

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
		if (!(other instanceof Playlist)) {
			return false;
		}
		Playlist rhs = ((Playlist) other);
		return new EqualsBuilder().append(url, rhs.url)
		                          .append(id, rhs.id)
		                          .append(playlist, rhs.playlist)
		                          .isEquals();
	}

}
