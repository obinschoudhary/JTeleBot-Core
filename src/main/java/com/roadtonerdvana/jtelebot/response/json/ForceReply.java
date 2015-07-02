package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class ForceReply{

	/**
	 * Shows reply interface to the user, as if they manually selected the bot���s
	 * message and tapped ���Reply'
	 * */
	@JsonProperty("force_reply")
	private Boolean forceReply;

	/**
	 * Optional. Use this parameter if you want to force reply from specific
	 * users only. Targets: 1) users that are mentioned in the text of the
	 * Message object; 2) if the bot's message is a reply (has
	 * reply_to_message_id), sender of the original message
	 * */
	@JsonProperty("selective")
	private Boolean selective;

	public Boolean isForceReply() {
		return forceReply;
	}

	public void setForceReply(final Boolean forceReply) {
		this.forceReply = forceReply;
	}

	public Boolean isSelective() {
		return selective;
	}

	public void setSelective(final Boolean selective) {
		this.selective = selective;
	}

	@Override
	public String toString() {
		return "ForceReply [forceReply=" + forceReply + ", selective="
				+ selective + "]";
	}
}
