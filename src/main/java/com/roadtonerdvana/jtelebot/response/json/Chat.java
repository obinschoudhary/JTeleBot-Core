package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class Chat extends Result{

	/**
	 * Unique identifier for this group chat
	 */
	@JsonProperty("id")
	private Integer id;
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Chat [id=" + id + "]";
	}
	
	
}
