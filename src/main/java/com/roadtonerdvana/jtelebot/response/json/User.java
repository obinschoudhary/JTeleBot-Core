package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * This object represents a Telegram user or bot.
 *
 */
public class User extends Result{
	

	
	/**
	 * Integer	Unique identifier for this user or bot
	 */
	@JsonProperty("id")
	private int id;
	/**
	 * String	User‘s or bot’s first name
	 */
	@JsonProperty("first_name")
	private String firstName;
	/**
	 * String	Optional. User‘s or bot’s last name
	 */
	@JsonProperty("last_name")
	private String lastName;	
	/**
	 * Optional. User‘s or bot’s username
	 */
	@JsonProperty("username")
	private String username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", username=" + username + "]";
	}
	
	
	
	
}
