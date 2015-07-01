package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * This object represents a video file.
 *
 */
public class Video {
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String fileId;
	/**
	 * Video width as defined by sender
	 */
	@JsonProperty("width")
	private Integer width;
	/**
	 * Video height as defined by sender
	 */
	@JsonProperty("height")
	private Integer height;
	/**
	 * Duration of the video in seconds as defined by sender
	 */
	@JsonProperty("duration")
	private Integer duration;
	/**
	 * Video thumbnail
	 */
	@JsonProperty("thumb")
	private PhotoSize thumbnail;
	/**
	 * Optional. Mime type of a file as defined by sender
	 */
	@JsonProperty("mime_type")
	private String mimeType;
	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
	/**
	 * Optional. Text description of the video (usually empty)
	 */
	@JsonProperty("caption")
	private String caption;
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public PhotoSize getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(PhotoSize thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public String toString() {
		return "Video [fileId=" + fileId + ", width=" + width + ", height="
				+ height + ", duration=" + duration + ", thumbnail="
				+ thumbnail + ", mimeType=" + mimeType + ", fileSize="
				+ fileSize + ", caption=" + caption + "]";
	}
	
	
}


