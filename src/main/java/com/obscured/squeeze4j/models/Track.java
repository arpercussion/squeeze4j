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
		"id",
		"title",
		"artist_id",
		"album_id",
		"url",
		"artist_ids",
		"albumartist_ids",
		"band_ids",
		"conductor_ids",
		"composer_ids",
		"trackartist_ids",
		"genre_id"
})
public class Track {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("artist_id")
	private String artistId;

	@JsonProperty("album_id")
	private String albumId;

	@JsonProperty("url")
	private String url;

	@JsonProperty("artist_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> artistIds;

	@JsonProperty("albumartist_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> albumArtistIds;

	@JsonProperty("band_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> bandIds;

	@JsonProperty("conductor_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> conductorIds;

	@JsonProperty("composer_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> composerIds;

	@JsonProperty("trackartist_ids")
	@JsonSerialize(using = ListToString.class)
	@JsonDeserialize(using = StringToList.class)
	private List<Integer> trackArtistIds;

	@JsonProperty("genre_id")
	private String genreId;

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

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
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

	public List<Integer> getAlbumArtistIds() {
		return albumArtistIds;
	}

	public void setAlbumArtistIds(List<Integer> albumArtistIds) {
		this.albumArtistIds = albumArtistIds;
	}

	public List<Integer> getBandIds() {
		return bandIds;
	}

	public void setBandIds(List<Integer> bandIds) {
		this.bandIds = bandIds;
	}

	public List<Integer> getConductorIds() {
		return conductorIds;
	}

	public void setConductorIds(List<Integer> conductorIds) {
		this.conductorIds = conductorIds;
	}

	public List<Integer> getComposerIds() {
		return composerIds;
	}

	public void setComposerIds(List<Integer> composerIds) {
		this.composerIds = composerIds;
	}

	public List<Integer> getTrackArtistIds() {
		return trackArtistIds;
	}

	public void setTrackArtistIds(List<Integer> trackArtistIds) {
		this.trackArtistIds = trackArtistIds;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
		                            .append(title)
		                            .append(artistId)
		                            .append(albumId)
		                            .append(url)
		                            .append(artistIds)
		                            .append(albumArtistIds)
		                            .append(bandIds)
		                            .append(conductorIds)
		                            .append(composerIds)
		                            .append(trackArtistIds)
		                            .append(genreId)
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Track)) {
			return false;
		}
		Track rhs = ((Track) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(title, rhs.title)
		                          .append(artistId, rhs.artistId)
		                          .append(albumId, rhs.albumId)
		                          .append(url, rhs.url)
		                          .append(artistIds, rhs.artistIds)
		                          .append(albumArtistIds, rhs.albumArtistIds)
		                          .append(bandIds, rhs.bandIds)
		                          .append(conductorIds, rhs.conductorIds)
		                          .append(composerIds, rhs.composerIds)
		                          .append(trackArtistIds, rhs.trackArtistIds)
		                          .append(genreId, rhs.genreId)
		                          .isEquals();
	}

}
