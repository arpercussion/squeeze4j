package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.obscured.squeeze4j.converters.StringToList;
import com.obscured.squeeze4j.converters.ListToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"artist_id",
		"artist_ids",
		"title"
})
public class Album {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("artist_id")
	private String artistId;

	@JsonProperty("artist_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> artistIds;

	@JsonProperty("title")
	private String title;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public List<Integer> getArtistIds() {
		return artistIds;
	}

	public void setArtistIds(List<Integer> artistIds) {
		this.artistIds = artistIds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
		                            .append(artistId)
		                            .append(artistIds)
		                            .append(title)
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Album)) {
			return false;
		}
		Album rhs = ((Album) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(artistId, rhs.artistId)
		                          .append(artistIds, rhs.artistIds)
		                          .append(title, rhs.title)
		                          .isEquals();
	}
}
