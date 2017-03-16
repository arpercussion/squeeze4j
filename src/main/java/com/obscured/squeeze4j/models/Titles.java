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
		"artist_id",
		"album_id",
		"url",
		"artist_ids",
		"genre_id"
})
public class Titles {

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
	private String artistIds;

	@JsonProperty("genre_id")
	private String genreId;

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

	@JsonProperty("artist_id")
	public String getArtistId() {
		return artistId;
	}

	@JsonProperty("artist_id")
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	@JsonProperty("album_id")
	public String getAlbumId() {
		return albumId;
	}

	@JsonProperty("album_id")
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("artist_ids")
	public String getArtistIds() {
		return artistIds;
	}

	@JsonProperty("artist_ids")
	public void setArtistIds(String artistIds) {
		this.artistIds = artistIds;
	}

	@JsonProperty("genre_id")
	public String getGenreId() {
		return genreId;
	}

	@JsonProperty("genre_id")
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
		                            .append(genreId)
		                            .toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Titles)) {
			return false;
		}
		Titles rhs = ((Titles) other);
		return new EqualsBuilder().append(id, rhs.id)
		                          .append(title, rhs.title)
		                          .append(artistId, rhs.artistId)
		                          .append(albumId, rhs.albumId)
		                          .append(url, rhs.url)
		                          .append(artistIds, rhs.artistIds)
		                          .append(genreId, rhs.genreId)
		                          .isEquals();
	}

}
