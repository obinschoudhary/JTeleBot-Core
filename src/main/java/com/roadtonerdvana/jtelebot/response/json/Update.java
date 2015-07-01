package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * This object represents an incoming update.
 *
 */
public class Update extends Result{
	/**
	 * The update‘s unique identifier. 
	 * Update identifiers start from a certain positive number and increase sequentially. 
	 * This ID becomes especially handy if you’re using Webhooks, 
	 * since it allows you to ignore repeated updates or to restore the correct update sequence,
	 *  should they get out of order.
	 */
	@JsonProperty("update_id")
	private Integer updateId;
	/**
	 * Optional. New incoming message of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty("message")
	private Message message;
	public Integer getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Update [updateId=" + updateId + ", message=" + message + "]";
	}
	

}
