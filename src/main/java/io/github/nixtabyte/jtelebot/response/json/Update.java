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
 * This object represents an incoming update.
 *
 */
public class Update {
	/**
	 * The update?????????s unique identifier. Update identifiers start from a certain
	 * positive number and increase sequentially. This ID becomes especially
	 * handy if you?????????re using Webhooks, since it allows you to ignore repeated
	 * updates or to restore the correct update sequence, should they get out of
	 * order.
	 */
	@JsonProperty("update_id")
	private Long updateId;
	/**
	 * Optional. New incoming message of any kind ????????? text, photo, sticker, etc.
	 */
	@JsonProperty("message")
	private Message message;

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(final Long updateId) {
		this.updateId = updateId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(final Message message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((updateId == null) ? 0 : updateId.hashCode());
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
		Update other = (Update) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (updateId == null) {
			if (other.updateId != null)
				return false;
		} else if (!updateId.equals(other.updateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Update [updateId=" + updateId + ", message=" + message + "]";
	}

}
