package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReplyKeyboardMarkup implements CustomReplyKeyboard{

	/**
	 * Array of button rows, each represented by an Array of Strings
	 * */
	@JsonProperty("keyboard")
	private String[][] keyboard;

	/**
	 * Optional. Requests clients to resize the keyboard vertically for optimal
	 * fit (e.g., make the keyboard smaller if there are just two rows of
	 * buttons). Defaults to false, in which case the custom keyboard is always
	 * of the same height as the app's standard keyboard.
	 * */
	@JsonProperty("resize_keyboard")
	private Boolean resizeKeyboard;

	/**
	 * Optional. Requests clients to hide the keyboard as soon as it's been
	 * used. Defaults to false.
	 * */
	@JsonProperty("one_time_keyboard")
	private Boolean oneTimeKeyboard;

	/**
	 * Optional. Use this parameter if you want to show the keyboard to specific
	 * users only. Targets: 1) users that are @mentioned in the text of the
	 * Message object; 2) if the bot's message is a reply (has
	 * reply_to_message_id), sender of the original message.
	 * 
	 * Example: A user requests to change the bot���s language, bot replies to the
	 * request with a keyboard to select the new language. Other users in the
	 * group don���t see the keyboard.
	 * */
	@JsonProperty("selective")
	private Boolean selective;

	public String[][] getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(final String[][] keyboard) {
		this.keyboard = keyboard;
	}

	public Boolean getResizeKeyboard() {
		return resizeKeyboard;
	}

	public void setResizeKeyboard(final Boolean resizeKeyboard) {
		this.resizeKeyboard = resizeKeyboard;
	}

	public Boolean getOneTimeKeyboard() {
		return oneTimeKeyboard;
	}

	public void setOneTimeKeyboard(final Boolean oneTimeKeyboard) {
		this.oneTimeKeyboard = oneTimeKeyboard;
	}

	public Boolean getSelective() {
		return selective;
	}

	public void setSelective(final Boolean selective) {
		this.selective = selective;
	}

	@Override
	public String toString() {
		return "ReplyKeyboardMarkup [keyboard=" + keyboard
				+ ", resizeKeyboard=" + resizeKeyboard + ", oneTimeKeyboard="
				+ oneTimeKeyboard + ", selective=" + selective + "]";
	}
}
