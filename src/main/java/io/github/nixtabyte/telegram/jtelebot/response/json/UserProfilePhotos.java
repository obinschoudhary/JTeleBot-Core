/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.response.json;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserProfilePhotos{

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(photos);
		result = prime * result
				+ ((totalCount == null) ? 0 : totalCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfilePhotos other = (UserProfilePhotos) obj;
		if (!Arrays.deepEquals(photos, other.photos))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfilePhotos [totalCount=" + totalCount + ", photos="
				+ photos + "]";
	}
}
