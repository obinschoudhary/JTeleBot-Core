package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserProfilePhotos extends Result {

	/**
	 * Total number of profile pictures the target user has
	 * */
	@JsonProperty("total_count")
	private Integer totalCount;

	/**
	 * Requested profile pictures (in up to 4 sizes each)
	 * */
	@JsonProperty("photos")
	private PhotoSize[][] photos;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(final Integer totalCount) {
		this.totalCount = totalCount;
	}

	public PhotoSize[][] getPhotos() {
		return photos;
	}

	public void setPhotos(final PhotoSize[][] photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "UserProfilePhotos [totalCount=" + totalCount + ", photos="
				+ photos + "]";
	}
}
