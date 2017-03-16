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
		"genres_loop"
})
public class GenreWrapper {
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("genres_loop")
	private List<Genres> genres = null;

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("genres_loop")
	public List<Genres> getGenres() {
		return genres;
	}

	@JsonProperty("genres_loop")
	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(count).append(genres).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof GenreWrapper)) {
			return false;
		}
		GenreWrapper rhs = ((GenreWrapper) other);
		return new EqualsBuilder().append(count, rhs.count).append(genres, rhs.genres).isEquals();
	}
}
