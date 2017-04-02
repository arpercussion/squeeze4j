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
		"artists_loop"
})
public class Artists {
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("artists_loop")
	private List<Artist> artists = null;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(count).append(artists).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Artists)) {
			return false;
		}
		Artists rhs = ((Artists) other);
		return new EqualsBuilder().append(count, rhs.count).append(artists, rhs.artists).isEquals();
	}
}
