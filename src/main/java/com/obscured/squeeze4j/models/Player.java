package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.obscured.squeeze4j.converters.BooleanToInteger;
import com.obscured.squeeze4j.converters.DashToInteger;
import com.obscured.squeeze4j.converters.IntegerToBoolean;
import com.obscured.squeeze4j.converters.IntegerToDash;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"seq_no",
		"playerid",
		"displaytype",
		"connected",
		"ip",
		"model",
		"name",
		"firmware",
		"uuid",
		"isplayer",
		"canpoweroff",
		"isplaying",
		"playerindex",
		"power",
		"modelname"
})
public class Player {

	@JsonProperty("seq_no")
	private String seq_no;

	@JsonProperty("playerid")
	private String playerId;

	@JsonProperty("displaytype")
	private String displayType;

	@JsonProperty("connected")
	private Integer connected;

	@JsonProperty("ip")
	private String ip;

	@JsonProperty("model")
	private String model;

	@JsonProperty("name")
	private String name;

	@JsonProperty("firmware")
	private String firmware;

	@JsonProperty("uuid")
	private Object uuid;

	@JsonProperty("isplayer")
	@JsonSerialize(using = BooleanToInteger.class)
	@JsonDeserialize(using = IntegerToBoolean.class)
	private Boolean isPlayer;

	@JsonProperty("canpoweroff")
	@JsonSerialize(using = BooleanToInteger.class)
	@JsonDeserialize(using = IntegerToBoolean.class)
	private Boolean canPowerOff;

	@JsonProperty("isplaying")
	@JsonSerialize(using = BooleanToInteger.class)
	@JsonDeserialize(using = IntegerToBoolean.class)
	private Boolean isPlaying;

	@JsonProperty("playerindex")
	@JsonSerialize(using = IntegerToDash.class)
	@JsonDeserialize(using = DashToInteger.class)
	private Integer playerIndex;

	@JsonProperty("power")
	private Integer power;

	@JsonProperty("modelname")
	private String modelName;

	public String getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(String seq_no) {
		this.seq_no = seq_no;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public Integer getConnected() {
		return connected;
	}

	public void setConnected(Integer connected) {
		this.connected = connected;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public Object getUuid() {
		return uuid;
	}

	public void setUuid(Object uuid) {
		this.uuid = uuid;
	}

	public Boolean getIsPlayer() {
		return isPlayer;
	}

	public void setIsPlayer(Boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	public Boolean getCanPowerOff() {
		return canPowerOff;
	}

	public void setCanPowerOff(Boolean canPowerOff) {
		this.canPowerOff = canPowerOff;
	}

	public Boolean getIsPlaying() {
		return isPlaying;
	}

	public void setIsPlaying(Boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public Integer getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(Integer playerIndex) {
		this.playerIndex = playerIndex;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(seq_no)
		                            .append(playerId)
		                            .append(displayType)
		                            .append(connected)
		                            .append(ip)
		                            .append(model)
		                            .append(name)
		                            .append(firmware)
		                            .append(uuid)
		                            .append(isPlayer)
		                            .append(canPowerOff)
		                            .append(isPlaying)
		                            .append(playerIndex)
		                            .append(power)
		                            .append(modelName)
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
		return new EqualsBuilder().append(seq_no, rhs.seq_no)
		                          .append(playerId, rhs.playerId)
		                          .append(displayType, rhs.displayType)
		                          .append(connected, rhs.connected)
		                          .append(ip, rhs.ip)
		                          .append(model, rhs.model)
		                          .append(name, rhs.name)
		                          .append(firmware, rhs.firmware)
		                          .append(uuid, rhs.uuid)
		                          .append(isPlayer, rhs.isPlayer)
		                          .append(canPowerOff, rhs.canPowerOff)
		                          .append(isPlaying, rhs.isPlaying)
		                          .append(playerIndex, rhs.playerIndex)
		                          .append(power, rhs.power)
		                          .append(modelName, rhs.modelName)
		                          .isEquals();
	}

}