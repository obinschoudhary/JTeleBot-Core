package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class Contact {

	/**
	 * Contact's phone number
	 * */
	@JsonProperty("phone_number")
	private String phoneNumber;

	/**
	 * Contact's first name
	 * */
	@JsonProperty("first_name")
	private String firstName;

	/**
	 * Optional. Contact's last name
	 * */
	@JsonProperty("last_name")
	private String lastName;

	/**
	 * Optional. Contact's user identifier in Telegram
	 * */
	@JsonProperty("user_id")
	private String userId;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Contact [phoneNumber=" + phoneNumber + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userId=" + userId
				+ "]";
	}
}
