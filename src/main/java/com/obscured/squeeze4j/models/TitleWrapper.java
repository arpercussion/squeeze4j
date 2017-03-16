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
		"titles_loop"
})
public class TitleWrapper {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("titles_loop")
	private List<Titles> titles = null;

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("titles_loop")
	public List<Titles> getTitles() {
		return titles;
	}

	@JsonProperty("titles_loop")
	public void setTitles(List<Titles> titles) {
		this.titles = titles;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(count).append(titles).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof TitleWrapper)) {
			return false;
		}
		TitleWrapper rhs = ((TitleWrapper) other);
		return new EqualsBuilder().append(count, rhs.count).append(titles, rhs.titles).isEquals();
	}

}