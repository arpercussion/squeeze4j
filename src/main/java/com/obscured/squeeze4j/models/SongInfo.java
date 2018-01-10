package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.obscured.squeeze4j.converters.ListOfStringToString;
import com.obscured.squeeze4j.converters.ListOfIntToString;
import com.obscured.squeeze4j.converters.StringToListOfInt;
import com.obscured.squeeze4j.converters.StringToListOfString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tracknum",
        "artist",
        "year",
        "album",
        "artwork_track_id",
        "title",
        "artist_id",
        "genre_ids",
        "genre_id",
        "url",
        "artist_ids",
        "duration",
        "coverid",
        "genres",
        "genre",
        "album_id",
        "id",
        "band",
        "band_ids"
})
public class SongInfo {

    @JsonProperty("tracknum")
    private Integer tracknum;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("album")
    private String album;
    @JsonProperty("artwork_track_id")
    private String artworkTrackId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("artist_id")
    private Integer artistId;
    @JsonProperty("genre_ids")
    @JsonSerialize(using = ListOfIntToString.class)
    @JsonDeserialize(using = StringToListOfInt.class)
    private List<Integer> genreIds;
    @JsonProperty("genre_id")
    private Integer genreId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("artist_ids")
    @JsonSerialize(using = ListOfIntToString.class)
    @JsonDeserialize(using = StringToListOfInt.class)
    private List<Integer> artistIds;
    @JsonProperty("duration")
    private Double duration;
    @JsonProperty("coverid")
    private String coverId;
    @JsonProperty("genres")
    @JsonSerialize(using = ListOfStringToString.class)
    @JsonDeserialize(using = StringToListOfString.class)
    private List<String> genres;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("album_id")
    private Integer albumId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("band")
    private String band;
    @JsonProperty("band_ids")
    @JsonSerialize(using = ListOfIntToString.class)
    @JsonDeserialize(using = StringToListOfInt.class)
    private List<Integer> bandIds;

    private String coverUrl;

    public Integer getTracknum() {
        return tracknum;
    }

    public void setTracknum(Integer tracknum) {
        this.tracknum = tracknum;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtworkTrackId() {
        return artworkTrackId;
    }

    public void setArtworkTrackId(String artworkTrackId) {
        this.artworkTrackId = artworkTrackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(List<Integer> artistIds) {
        this.artistIds = artistIds;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public List<Integer> getBandIds() {
        return bandIds;
    }

    public void setBandIds(List<Integer> bandIds) {
        this.bandIds = bandIds;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id)
                .append(title)
                .append(artist)
                .append(album)
                .append(genre)
                .append(coverId)
                .append(url)
                .append(tracknum)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SongInfo)) {
            return false;
        }
        SongInfo rhs = ((SongInfo) other);
        return new EqualsBuilder().append(id, rhs.id)
                .append(title, rhs.title)
                .append(artist, rhs.artist)
                .append(album, rhs.album)
                .append(genre, rhs.genre)
                .append(coverId, rhs.coverId)
                .append(url, rhs.url)
                .append(tracknum, rhs.tracknum)
                .isEquals();
    }
}
