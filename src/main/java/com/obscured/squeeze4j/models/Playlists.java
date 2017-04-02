package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"count",
		"playlists_loop"
})
public class Playlists {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("playlists_loop")
	private List<Playlist> playlists = null;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(count).append(playlists).toHashCode();
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
		return new EqualsBuilder().append(count, rhs.count).append(playlists, rhs.playlists).isEquals();
	}

}