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
        "tracks_loop",
        "tracks_count",
        "contributors_count",
        "contributors_loop",
        "albums_count"
})
public class Search {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("tracks_loop")
    private List<SearchTracks> tracksLoop = null;

    @JsonProperty("tracks_count")
    private Integer tracksCount;

    @JsonProperty("contributors_count")
    private Integer contributorsCount;

    @JsonProperty("contributors_loop")
    private List<SearchContributors> contributors = null;

    @JsonProperty("albums_count")
    private Integer albumsCount;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<SearchTracks> getTracksLoop() {
        return tracksLoop;
    }

    public void setTracksLoop(List<SearchTracks> tracksLoop) {
        this.tracksLoop = tracksLoop;
    }

    public Integer getTracksCount() {
        return tracksCount;
    }

    public void setTracksCount(Integer tracksCount) {
        this.tracksCount = tracksCount;
    }

    public Integer getContributorsCount() {
        return contributorsCount;
    }

    public void setContributorsCount(Integer contributorsCount) {
        this.contributorsCount = contributorsCount;
    }

    public List<SearchContributors> getContributors() {
        return contributors;
    }

    public void setContributors(List<SearchContributors> contributors) {
        this.contributors = contributors;
    }

    public Integer getAlbumsCount() {
        return albumsCount;
    }

    public void setAlbumsCount(Integer albumsCount) {
        this.albumsCount = albumsCount;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(count).append(tracksLoop).append(tracksCount).append(contributorsCount).append(contributors).append(albumsCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Search) == false) {
            return false;
        }
        Search rhs = ((Search) other);
        return new EqualsBuilder().append(count, rhs.count).append(tracksLoop, rhs.tracksLoop).append(tracksCount, rhs.tracksCount).append(contributorsCount, rhs.contributorsCount).append(contributors, rhs.contributors).append(albumsCount, rhs.albumsCount).isEquals();
    }

}