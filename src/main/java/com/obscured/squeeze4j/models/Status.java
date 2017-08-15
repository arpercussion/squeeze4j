package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.obscured.squeeze4j.converters.BooleanToInteger;
import com.obscured.squeeze4j.converters.IntegerToBoolean;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "player_name",
        "player_connected",
        "player_ip",
        "power",
        "signalstrength",
        "mode",
        "time",
        "rate",
        "duration",
        "can_seek",
        "mixer volume",
        "playlist repeat",
        "playlist shuffle",
        "playlist mode",
        "seq_no",
        "playlist_cur_index",
        "playlist_timestamp",
        "playlist_tracks",
        "digital_volume_control",
        "playlist_loop",
        "playlist_name",
        "playlist_id",
        "playlist_modified",
        "waitingToPlay"
})
public class Status {

    @JsonProperty("player_name")
    private String playerName;

    @JsonProperty("player_connected")
    private Integer playerConnected;

    @JsonProperty("player_ip")
    private String playerIp;

    @JsonProperty("power")
    private Integer power;

    @JsonProperty("signalstrength")
    private Integer signalstrength;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("time")
    private Double time;

    @JsonProperty("rate")
    private Integer rate;

    @JsonProperty("duration")
    private Double duration;

    @JsonProperty("can_seek")
    @JsonSerialize(using = BooleanToInteger.class)
    @JsonDeserialize(using = IntegerToBoolean.class)
    private Boolean canSeek;

    @JsonProperty("waitingToPlay")
    @JsonSerialize(using = BooleanToInteger.class)
    @JsonDeserialize(using = IntegerToBoolean.class)
    private Boolean waitingToPlay;

    @JsonProperty("mixer volume")
    private Integer mixerVolume;

    @JsonProperty("playlist repeat")
    private Integer playlistRepeat;

    @JsonProperty("playlist_name")
    private String playlistName;

    @JsonProperty("playlist_id")
    private Integer playlistId;

    @JsonProperty("playlist_modified")
    @JsonSerialize(using = BooleanToInteger.class)
    @JsonDeserialize(using = IntegerToBoolean.class)
    private Boolean playlistModified;

    @JsonProperty("playlist shuffle")
    private Integer playlistShuffle;

    @JsonProperty("playlist mode")
    private String playlistMode;

    @JsonProperty("seq_no")
    private Integer seqNo;

    @JsonProperty("playlist_cur_index")
    private String playlistCurIndex;

    @JsonProperty("playlist_timestamp")
    private Double playlistTimestamp;

    @JsonProperty("playlist_tracks")
    private Integer playlistTracks;

    @JsonProperty("digital_volume_control")
    private Integer digitalVolumeControl;

    @JsonProperty("playlist_loop")
    private List<StatusPlaylists> playlistLoop = null;

    public Boolean getPlaylistModified() {
        return playlistModified;
    }

    public void setPlaylistModified(Boolean playlistModified) {
        this.playlistModified = playlistModified;
    }

    public Boolean getWaitingToPlay() {
        return waitingToPlay;
    }

    public void setWaitingToPlay(Boolean waitingToPlay) {
        this.waitingToPlay = waitingToPlay;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerConnected() {
        return playerConnected;
    }

    public void setPlayerConnected(Integer playerConnected) {
        this.playerConnected = playerConnected;
    }

    public String getPlayerIp() {
        return playerIp;
    }

    public void setPlayerIp(String playerIp) {
        this.playerIp = playerIp;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getSignalstrength() {
        return signalstrength;
    }

    public void setSignalstrength(Integer signalstrength) {
        this.signalstrength = signalstrength;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Boolean getCanSeek() {
        return canSeek;
    }

    public void setCanSeek(Boolean canSeek) {
        this.canSeek = canSeek;
    }

    public Integer getMixerVolume() {
        return mixerVolume;
    }

    public void setMixerVolume(Integer mixerVolume) {
        this.mixerVolume = mixerVolume;
    }

    public Integer getPlaylistRepeat() {
        return playlistRepeat;
    }

    public void setPlaylistRepeat(Integer playlistRepeat) {
        this.playlistRepeat = playlistRepeat;
    }

    public Integer getPlaylistShuffle() {
        return playlistShuffle;
    }

    public void setPlaylistShuffle(Integer playlistShuffle) {
        this.playlistShuffle = playlistShuffle;
    }

    public String getPlaylistMode() {
        return playlistMode;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public void setPlaylistMode(String playlistMode) {
        this.playlistMode = playlistMode;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getPlaylistCurIndex() {
        return playlistCurIndex;
    }

    public void setPlaylistCurIndex(String playlistCurIndex) {
        this.playlistCurIndex = playlistCurIndex;
    }

    public Double getPlaylistTimestamp() {
        return playlistTimestamp;
    }

    public void setPlaylistTimestamp(Double playlistTimestamp) {
        this.playlistTimestamp = playlistTimestamp;
    }

    public Integer getPlaylistTracks() {
        return playlistTracks;
    }

    public void setPlaylistTracks(Integer playlistTracks) {
        this.playlistTracks = playlistTracks;
    }

    public Integer getDigitalVolumeControl() {
        return digitalVolumeControl;
    }

    public void setDigitalVolumeControl(Integer digitalVolumeControl) {
        this.digitalVolumeControl = digitalVolumeControl;
    }

    public List<StatusPlaylists> getPlaylistLoop() {
        return playlistLoop;
    }

    public void setPlaylistLoop(List<StatusPlaylists> playlistLoop) {
        this.playlistLoop = playlistLoop;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playerName).append(waitingToPlay).append(playlistModified).append(playerConnected).append(playerIp).append(playlistName).append(playlistId).append(power).append(signalstrength).append(mode).append(time).append(rate).append(duration).append(canSeek).append(mixerVolume).append(playlistRepeat).append(playlistShuffle).append(playlistMode).append(seqNo).append(playlistCurIndex).append(playlistTimestamp).append(playlistTracks).append(digitalVolumeControl).append(playlistLoop).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Status)) {
            return false;
        }
        Status rhs = ((Status) other);
        return new EqualsBuilder().append(playerName, rhs.playerName).append(waitingToPlay, rhs.waitingToPlay).append(playlistModified, rhs.playlistModified).append(playerConnected, rhs.playerConnected).append(playerIp, rhs.playerIp).append(playlistId, rhs.playlistId).append(playlistName, rhs.playlistName).append(power, rhs.power).append(signalstrength, rhs.signalstrength).append(mode, rhs.mode).append(time, rhs.time).append(rate, rhs.rate).append(duration, rhs.duration).append(canSeek, rhs.canSeek).append(mixerVolume, rhs.mixerVolume).append(playlistRepeat, rhs.playlistRepeat).append(playlistShuffle, rhs.playlistShuffle).append(playlistMode, rhs.playlistMode).append(seqNo, rhs.seqNo).append(playlistCurIndex, rhs.playlistCurIndex).append(playlistTimestamp, rhs.playlistTimestamp).append(playlistTracks, rhs.playlistTracks).append(digitalVolumeControl, rhs.digitalVolumeControl).append(playlistLoop, rhs.playlistLoop).isEquals();
    }

}
