package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * 	This object represents a sticker.

 *
 */
public class Sticker{
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String fileId;
	/**
	 * Sticker width
	 */
	@JsonProperty("width")
	private Integer width;
	/**
	 * Sticker height
	 */
	@JsonProperty("height")
	private Integer height;
	/**
	 * Sticker thumbnail in .webp or .jpg format
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;
	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
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
	public PhotoSize getThumb() {
		return thumb;
	}
	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "Sticker [fileId=" + fileId + ", width=" + width + ", height="
				+ height + ", thumb=" + thumb + ", fileSize=" + fileSize + "]";
	}

}
