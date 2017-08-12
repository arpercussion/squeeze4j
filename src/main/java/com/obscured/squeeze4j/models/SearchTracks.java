package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "audio",
        "coverid",
        "track",
        "track_id"
})
public class SearchTracks {

    @JsonProperty("audio")
    private Integer audio;

    @JsonProperty("coverid")
    private String coverid;

    @JsonProperty("track")
    private String track;

    @JsonProperty("track_id")
    private Integer trackId;

    public Integer getAudio() {
        return audio;
    }

    public void setAudio(Integer audio) {
        this.audio = audio;
    }

    public String getCoverid() {
        return coverid;
    }

    public void setCoverid(String coverid) {
        this.coverid = coverid;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(audio).append(coverid).append(track).append(trackId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchTracks) == false) {
            return false;
        }
        SearchTracks rhs = ((SearchTracks) other);
        return new EqualsBuilder().append(audio, rhs.audio).append(coverid, rhs.coverid).append(track, rhs.track).append(trackId, rhs.trackId).isEquals();
    }
}