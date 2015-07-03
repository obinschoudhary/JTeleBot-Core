package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReplyKeyboardHide implements CustomReplyKeyboard{

	/**
	 * Requests clients to hide the custom keyboard
	 * */
	@JsonProperty("hide_keyboard")
	private Boolean hideKeyboard;

	/**
	 * Optional. Use this parameter if you want to hide keyboard for specific
	 * users only. Targets: 1) users that are @mentioned in the text of the
	 * Message object; 2) if the bot's message is a reply (has
	 * reply_to_message_id), sender of the original message.
	 * 
	 * Example: A user votes in a poll, bot returns confirmation message in
	 * reply to the vote and hides keyboard for that user, while still showing
	 * the keyboard with poll options to users who haven't voted yet.
	 * */
	@JsonProperty("selective")
	private Boolean selective;

	public Boolean isHideKeyboard() {
		return hideKeyboard;
	}

	public void setHideKeyboard(Boolean hideKeyboard) {
		this.hideKeyboard = hideKeyboard;
	}

	public Boolean isSelective() {
		return selective;
	}

	public void setSelective(Boolean selective) {
		this.selective = selective;
	}

	@Override
	public String toString() {
		return "ReplyKeyboardHide [hideKeyboard=" + hideKeyboard
				+ ", selective=" + selective + "]";
	}

}
