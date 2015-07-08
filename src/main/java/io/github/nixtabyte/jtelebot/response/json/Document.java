/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * 	This object represents a general file (as opposed to photos and audio files).

 *
 */
public class Document{
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
	public void setFileId(final String fileId) {
		this.fileId = fileId;
	}
	public PhotoSize getThumb() {
		return thumb;
	}
	public void setThumb(final PhotoSize thumb) {
		this.thumb = thumb;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(final Integer fileSize) {
		this.fileSize = fileSize;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result
				+ ((mimeType == null) ? 0 : mimeType.hashCode());
		result = prime * result + ((thumb == null) ? 0 : thumb.hashCode());
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
		Document other = (Document) obj;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (mimeType == null) {
			if (other.mimeType != null)
				return false;
		} else if (!mimeType.equals(other.mimeType))
			return false;
		if (thumb == null) {
			if (other.thumb != null)
				return false;
		} else if (!thumb.equals(other.thumb))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Document [fileId=" + fileId + ", thumb=" + thumb
				+ ", fileName=" + fileName + ", mimeType=" + mimeType
				+ ", fileSize=" + fileSize + "]";
	}
	
	

}
