package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * This object represents a message.
 *
 */
public class Message extends Result{
	/**
	 * Unique message identifier
	 */
	@JsonProperty("message_id")
	private int id;
	/**
	 * Sender
	 */
	@JsonProperty("from")
	private User fromUser;
	/**
	 * Date the message was sent in Unix time
	 */
	@JsonProperty("date")
	private int unixTimeDate;
	/**
	 * Conversation the message belongs to — user in case of a private message, GroupChat in case of a group
	 */
	@JsonProperty("chat")
	private Chat chat;
	/**
	 * Optional. For forwarded messages, sender of the original message
	 */
	@JsonProperty("forward_from")
	private User forwardFromUser;
	/**
	 * Optional. For forwarded messages, date the original message was sent in Unix time
	 */
	@JsonProperty("forward_date")
	private Integer forwardDate;
	/**
	 * Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
	 */
	@JsonProperty("reply_to_message")
	private Message replyToMessage;
	/**
	 * Optional. For text messages, the actual UTF-8 text of the message
	 */
	@JsonProperty("text")
	private String text;
/**	
 * TODO: 
 * put following fields 
audio	Audio	Optional. Message is an audio file, information about the file
document	Document	Optional. Message is a general file, information about the file
photo	Array of PhotoSize	Optional. Message is a photo, available sizes of the photo
sticker	Sticker	Optional. Message is a sticker, information about the sticker
video	Video	Optional. Message is a video, information about the video
contact	Contact	Optional. Message is a shared contact, information about the contact
location	Location	Optional. Message is a shared location, information about the location
*/
	
	/**
	 * Optional. A new member was added to the group, information about them (this member may be bot itself)
	 */
	@JsonProperty("new_chat_participant")
	private User newChatParticipantUser;
	/**
	 * Optional. A member was removed from the group, information about them (this member may be bot itself)
	 */
	@JsonProperty("left_chat_participant")
	private User leftChatParticipantUser;
	/**
	 * Optional. A group title was changed to this value
	 */
	@JsonProperty("new_chat_title")
	private String newChatTitle;

/**
 * TODO: put this property
new_chat_photo	Array of PhotoSize	Optional. A group photo was change to this value
 */
	/**
	 * Optional. Informs that the group photo was deleted
	 */
	@JsonProperty("delete_chat_photo")
	private Boolean deleteChatPhoto;
	/**
	 * Optional. Informs that the group has been created
	 */
	@JsonProperty("group_chat_created")
	private Boolean groupChatCreated;
}
