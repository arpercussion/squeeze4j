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
public class ArtistWrapper {
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("artists_loop")
	private List<Artists> artists = null;

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("artists_loop")
	public List<Artists> getArtists() {
		return artists;
	}

	@JsonProperty("artists_loop")
	public void setArtists(List<Artists> artists) {
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
		if (!(other instanceof ArtistWrapper)) {
			return false;
		}
		ArtistWrapper rhs = ((ArtistWrapper) other);
		return new EqualsBuilder().append(count, rhs.count).append(artists, rhs.artists).isEquals();
	}
}
