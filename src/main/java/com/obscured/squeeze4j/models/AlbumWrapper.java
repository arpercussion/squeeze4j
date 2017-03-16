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
		"albums_loop"
})
public class AlbumWrapper {
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("titles_loop")
	private List<Albums> albums = null;

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("albums_loop")
	public List<Albums> getAlbums() {
		return albums;
	}

	@JsonProperty("albums_loop")
	public void setAlbums(List<Albums> albums) {
		this.albums = albums;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(count).append(albums).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof AlbumWrapper)) {
			return false;
		}
		AlbumWrapper rhs = ((AlbumWrapper) other);
		return new EqualsBuilder().append(count, rhs.count).append(albums, rhs.albums).isEquals();
	}
}
