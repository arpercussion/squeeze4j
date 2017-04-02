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
public class Genre {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("genre")
	private String genre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

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
		if (!(other instanceof Genre)) {
			return false;
		}
		Genre rhs = ((Genre) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(genre, rhs.genre)
		                          .isEquals();
	}
}
