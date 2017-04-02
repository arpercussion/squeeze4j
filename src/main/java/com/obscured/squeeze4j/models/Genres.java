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
public class Genres {
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("genres_loop")
	private List<Genre> genres = null;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
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
		if (!(other instanceof Genres)) {
			return false;
		}
		Genres rhs = ((Genres) other);
		return new EqualsBuilder().append(count, rhs.count).append(genres, rhs.genres).isEquals();
	}
}
