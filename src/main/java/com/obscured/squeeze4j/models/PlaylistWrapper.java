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
public class PlaylistWrapper {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("playlists_loop")
	private List<Playlists> playlists = null;

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("playlists_loop")
	public List<Playlists> getPlaylists() {
		return playlists;
	}

	@JsonProperty("playlists_loop")
	public void setPlaylists(List<Playlists> playlists) {
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
		if (!(other instanceof PlaylistWrapper)) {
			return false;
		}
		PlaylistWrapper rhs = ((PlaylistWrapper) other);
		return new EqualsBuilder().append(count, rhs.count).append(playlists, rhs.playlists).isEquals();
	}

}