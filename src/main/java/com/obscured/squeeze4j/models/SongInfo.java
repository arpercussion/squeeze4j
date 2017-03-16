package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"title",
		"artist",
		"album",
		"genre",
		"coverid"
})
public class SongInfo {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("artist")
	private String artist;
	@JsonProperty("album")
	private String album;
	@JsonProperty("genre")
	private String genre;
	@JsonProperty("coverid")
	private String coverId;

	private String coverUrl;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("artist")
	public String getArtist() {
		return artist;
	}

	@JsonProperty("artist")
	public void setArtist(String artist) {
		this.artist = artist;
	}

	@JsonProperty("album")
	public String getAlbum() {
		return album;
	}

	@JsonProperty("album")
	public void setAlbum(String album) {
		this.album = album;
	}

	@JsonProperty("genre")
	public String getGenre() {
		return genre;
	}

	@JsonProperty("genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonProperty("coverid")
	public String getCoverId() {
		return coverId;
	}

	@JsonProperty("coverid")
	public void setCoverId(String coverId) {
		this.coverId = coverId;
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
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof SongInfo) == false) {
			return false;
		}
		SongInfo rhs = ((SongInfo) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(title, rhs.title)
		                          .append(artist, rhs.artist)
		                          .append(album, rhs.album)
		                          .append(genre, rhs.genre)
		                          .append(coverId, rhs.coverId)
		                          .isEquals();
	}
}
