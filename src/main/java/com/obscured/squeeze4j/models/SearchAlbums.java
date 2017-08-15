package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "album",
        "album_id",
        "artwork"
})
public class SearchAlbums {

    @JsonProperty("album")
    private String album;

    @JsonProperty("album_id")
    private Integer albumId;

    @JsonProperty("artwork")
    private String artwork;

    @JsonProperty("album")
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(album).append(albumId).append(artwork).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SearchAlbums)) {
            return false;
        }
        SearchAlbums rhs = ((SearchAlbums) other);
        return new EqualsBuilder().append(album, rhs.album).append(albumId, rhs.albumId).append(artwork, rhs.artwork).isEquals();
    }

}