package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * This object represents a group chat.
 *
 */
public class GroupChat extends Chat {

	/**
	 * Group name
	 */
	@JsonProperty("title")
	private String title;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "GroupChat [id="+this.getId()+" title=" + title + "]";
	}


}
