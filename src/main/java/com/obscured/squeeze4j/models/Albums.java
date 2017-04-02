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
public class Albums {
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("albums_loop")
	private List<Album> albums = null;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
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
		if (!(other instanceof Albums)) {
			return false;
		}
		Albums rhs = ((Albums) other);
		return new EqualsBuilder().append(count, rhs.count).append(albums, rhs.albums).isEquals();
	}
}
