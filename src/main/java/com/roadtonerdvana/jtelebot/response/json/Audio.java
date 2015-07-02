package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * 	This object represents an audio file (voice note).

 *
 */
public class Audio{
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String fileId;
	/**
	 * Duration of the audio in seconds as defined by sender
	 */
	@JsonProperty("duration")
	private Integer duration;
	/**
	 *  Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty("mime_type")
	private String mimeType;
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
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
	@Override
	public String toString() {
		return "Audio [fileId=" + fileId + ", duration=" + duration
				+ ", mimeType=" + mimeType + ", fileSize=" + fileSize + "]";
	}

		
}
