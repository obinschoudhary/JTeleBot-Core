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
	public void setTitle(final String title) {
		this.title = title;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupChat other = (GroupChat) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GroupChat [id="+this.getId()+" title=" + title + "]";
	}


}
