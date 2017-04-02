package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"artist"
})
public class Artist {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("artist")
	private String artist;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
		                            .append(artist)
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Artist)) {
			return false;
		}
		Artist rhs = ((Artist) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(artist, rhs.artist)
		                          .isEquals();
	}
}
