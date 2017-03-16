package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"genre"
})
public class Genres {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("genre")
	private String genre;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("genre")
	public String getGenre() {
		return genre;
	}

	@JsonProperty("genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
		                            .append(genre)
		                            .toHashCode();
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
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(genre, rhs.genre)
		                          .isEquals();
	}
}
