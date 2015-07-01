package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * 	This object represents a general file (as opposed to photos and audio files).

 *
 */
public class Document extends Result{
	/**
	 * Unique file identifier
	 */
	@JsonProperty("file_id")
	private String fileId;
	/**
	 * Document thumbnail as defined by sender
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;
	/**
	 * Original filename as defined by sender
	 */
	@JsonProperty("file_name")
	private String fileName;
	/**
	 * Optional. MIME type of the file as defined by sender
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
	public PhotoSize getThumb() {
		return thumb;
	}
	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		return "Document [fileId=" + fileId + ", thumb=" + thumb
				+ ", fileName=" + fileName + ", mimeType=" + mimeType
				+ ", fileSize=" + fileSize + "]";
	}
	
	

}
