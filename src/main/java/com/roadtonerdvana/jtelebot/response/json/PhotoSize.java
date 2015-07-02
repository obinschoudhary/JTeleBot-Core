package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * 	This object represents one size of a photo or a file / sticker thumbnail.

 *
 */
public class PhotoSize{
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String fileId;
	/**
	 * Photo width
	 */
	@JsonProperty("width")
	private Integer width;
	/**
	 * Photo height
	 */
	@JsonProperty("height")
	private Integer height;

	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	private Integer file_size;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getFile_size() {
		return file_size;
	}

	public void setFile_size(Integer file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "PhotoSize [fileId=" + fileId + ", width=" + width + ", height="
				+ height + ", file_size=" + file_size + "]";
	}
	
	


}
