package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.obscured.squeeze4j.converters.DashToInteger;
import com.obscured.squeeze4j.converters.IntegerToDash;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"connected",
		"displaytype",
		"canpoweroff",
		"ip",
		"name",
		"model",
		"uuid",
		"isplayer",
		"playerindex",
		"playerid"
})
public class Player {

	@JsonProperty("connected")
	private Integer connected;

	@JsonProperty("displaytype")
	private String displayType;

	@JsonProperty("canpoweroff")
	private Integer canPowerOff;

	@JsonProperty("ip")
	private String ip;

	@JsonProperty("name")
	private String name;

	@JsonProperty("model")
	private String model;

	@JsonProperty("uuid")
	private Object uuid;

	@JsonProperty("isplayer")
	private Integer isPlayer;

	@JsonProperty("playerindex")
	@JsonSerialize(using = IntegerToDash.class)
	@JsonDeserialize(using = DashToInteger.class)
	private Integer playerIndex;

	@JsonProperty("playerid")
	private String playerId;

	public Integer getConnected() {
		return connected;
	}

	public void setConnected(Integer connected) {
		this.connected = connected;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public Integer getCanPowerOff() {
		return canPowerOff;
	}

	public void setCanPowerOff(Integer canPowerOff) {
		this.canPowerOff = canPowerOff;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Object getUuid() {
		return uuid;
	}

	public void setUuid(Object uuid) {
		this.uuid = uuid;
	}

	public Integer getIsPlayer() {
		return isPlayer;
	}

	public void setIsPlayer(Integer isPlayer) {
		this.isPlayer = isPlayer;
	}

	public Integer getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(Integer playerIndex) {
		this.playerIndex = playerIndex;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerid(String playerId) {
		this.playerId = playerId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(connected)
		                            .append(displayType)
		                            .append(canPowerOff)
		                            .append(ip)
		                            .append(name)
		                            .append(model)
		                            .append(uuid)
		                            .append(isPlayer)
		                            .append(playerIndex)
		                            .append(playerId)
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Player)) {
			return false;
		}
		Player rhs = ((Player) other);
		return new EqualsBuilder().append(connected, rhs.connected)
		                          .append(displayType, rhs.displayType)
		                          .append(canPowerOff, rhs.canPowerOff)
		                          .append(ip, rhs.ip)
		                          .append(name, rhs.name)
		                          .append(model, rhs.model)
		                          .append(uuid, rhs.uuid)
		                          .append(isPlayer, rhs.isPlayer)
		                          .append(playerIndex, rhs.playerIndex)
		                          .append(playerId, rhs.playerId)
		                          .isEquals();
	}

}
