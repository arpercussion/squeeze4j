package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.obscured.squeeze4j.converters.ListToString;
import com.obscured.squeeze4j.converters.StringToList;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "playlist index",
        "id",
        "title",
        "coverid",
        "genre",
        "artist",
        "band",
        "composer",
        "album_id",
        "album",
        "duration",
        "tracknum",
        "year",
        "bitrate",
        "artist_ids",
        "band_ids",
        "composer_ids",
        "url",
        "type",
        "artwork_track_id"
})
public class StatusPlaylists {

    @JsonProperty("playlist index")
    private String playlistIndex;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("coverid")
    private String coverid;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("artist")
    private String artist;

    @JsonProperty("band")
    private String band;

    @JsonProperty("composer")
    private String composer;

    @JsonProperty("album_id")
    private String albumId;

    @JsonProperty("album")
    private String album;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("tracknum")
    private String tracknum;

    @JsonProperty("year")
    private String year;

    @JsonProperty("bitrate")
    private String bitrate;

    @JsonProperty("artist_ids")
    @JsonSerialize(using = ListToString.class)
    @JsonDeserialize(using = StringToList.class)
    private List<Integer> artistIds;

    @JsonProperty("band_ids")
    @JsonSerialize(using = ListToString.class)
    @JsonDeserialize(using = StringToList.class)
    private List<Integer> bandIds;

    @JsonProperty("composer_ids")
    @JsonSerialize(using = ListToString.class)
    @JsonDeserialize(using = StringToList.class)
    private List<Integer> composerIds;

    @JsonProperty("url")
    private String url;

    @JsonProperty("type")
    private String type;

    @JsonProperty("artwork_track_id")
    private String artworkTrackId;

    public String getPlaylistIndex() {
        return playlistIndex;
    }

    public void setPlaylistIndex(String playlistIndex) {
        this.playlistIndex = playlistIndex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverid() {
        return coverid;
    }

    public void setCoverid(String coverid) {
        this.coverid = coverid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTracknum() {
        return tracknum;
    }

    public void setTracknum(String tracknum) {
        this.tracknum = tracknum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public List<Integer> getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(List<Integer> artistIds) {
        this.artistIds = artistIds;
    }

    public List<Integer> getBandIds() {
        return bandIds;
    }

    public void setBandIds(List<Integer> bandIds) {
        this.bandIds = bandIds;
    }

    public List<Integer> getComposerIds() {
        return composerIds;
    }

    public void setComposerIds(List<Integer> composerIds) {
        this.composerIds = composerIds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtworkTrackId() {
        return artworkTrackId;
    }

    public void setArtworkTrackId(String artworkTrackId) {
        this.artworkTrackId = artworkTrackId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playlistIndex).append(id).append(title).append(coverid).append(genre).append(artist).append(band).append(composer).append(albumId).append(album).append(duration).append(tracknum).append(year).append(bitrate).append(artistIds).append(bandIds).append(composerIds).append(url).append(type).append(artworkTrackId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof StatusPlaylists)) {
            return false;
        }
        StatusPlaylists rhs = ((StatusPlaylists) other);
        return new EqualsBuilder().append(playlistIndex, rhs.playlistIndex).append(id, rhs.id).append(title, rhs.title).append(coverid, rhs.coverid).append(genre, rhs.genre).append(artist, rhs.artist).append(band, rhs.band).append(composer, rhs.composer).append(albumId, rhs.albumId).append(album, rhs.album).append(duration, rhs.duration).append(tracknum, rhs.tracknum).append(year, rhs.year).append(bitrate, rhs.bitrate).append(artistIds, rhs.artistIds).append(bandIds, rhs.bandIds).append(composerIds, rhs.composerIds).append(url, rhs.url).append(type, rhs.type).append(artworkTrackId, rhs.artworkTrackId).isEquals();
    }

}