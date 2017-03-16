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
		"players_loop"
})
public class PlayerWrapper {

	@JsonProperty("players_loop")
	private List<Players> players = null;

	@JsonProperty("count")
	private Integer count;

	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(players).append(count).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PlayerWrapper) == false) {
			return false;
		}
		PlayerWrapper rhs = ((PlayerWrapper) other);
		return new EqualsBuilder().append(players, rhs.players).append(count, rhs.count).isEquals();
	}
}
