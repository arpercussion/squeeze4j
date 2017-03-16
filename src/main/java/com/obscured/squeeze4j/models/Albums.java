package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"artist_id",
		"title"
})
public class Albums {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("artist_id")
	private String artistId;

	@JsonProperty("album")
	private String album;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("artist_id")
	public String getArtistId() {
		return artistId;
	}

	@JsonProperty("artist_id")
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	@JsonProperty("album")
	public String getAlbum() {
		return album;
	}

	@JsonProperty("album")
	public void setAlbum(String album) {
		this.album = album;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
		                            .append(artistId)
		                            .append(album)
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Albums)) {
			return false;
		}
		Albums rhs = ((Albums) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(artistId, rhs.artistId)
		                          .append(album, rhs.album)
		                          .isEquals();
	}
}
