/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.response.json;

import io.github.nixtabyte.telegram.jtelebot.mapper.json.MapperHandler;

import java.util.Arrays;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * This object represents a message.
 *
 * @since 0.0.1
 */
public class Message {
	/**
	 * Unique message identifier
	 */
	@JsonProperty("message_id")
	private Long id;
	/**
	 * Sender
	 */
	@JsonProperty("from")
	private User fromUser;
	/**
	 * Date the message was sent in Unix time
	 */
	@JsonProperty("date")
	private Long unixTimeDate;
	/**
	 * Conversation the message belongs to ????????? user in case of a private message,
	 * GroupChat in case of a group
	 */
	@JsonProperty("chat")
	private Chat chat;
	/**
	 * Optional. For forwarded messages, sender of the original message
	 */
	@JsonProperty("forward_from")
	private User forwardFromUser;
	/**
	 * Optional. For forwarded messages, date the original message was sent in
	 * Unix time
	 */
	@JsonProperty("forward_date")
	private Long forwardDate;
	/**
	 * Optional. For replies, the original message. Note that the Message object
	 * in this field will not contain further reply_to_message fields even if it
	 * itself is a reply.
	 */
	@JsonProperty("reply_to_message")
	private Message replyToMessage;
	/**
	 * Optional. For text messages, the actual UTF-8 text of the message
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * Optional. Message is an audio file, information about the file
	 * */
	@JsonProperty("audio")
	private Audio audio;

	/**
	 * Optional. Message is a general file, information about the file
	 * */
	@JsonProperty("document")
	private Document document;

	/**
	 * Optional. Message is a photo, available sizes of the photo
	 * */
	@JsonProperty("photo")
	private PhotoSize[] photo;

	/**
	 * Optional. Message is a sticker, information about the sticker
	 * */
	@JsonProperty("sticker")
	private Sticker sticker;

	/**
	 * Optional. Message is a video, information about the video
	 * */
	@JsonProperty("video")
	private Video video;

	/**
	 * Optional. Message is a shared contact, information about the contact
	 * */
	@JsonProperty("contact")
	private Contact contact;

	/**
	 * Optional. Message is a shared location, information about the location
	 * */
	@JsonProperty("location")
	private Location location;

	/**
	 * Optional. A new member was added to the group, information about them
	 * (this member may be bot itself)
	 */
	@JsonProperty("new_chat_participant")
	private User newChatParticipantUser;
	/**
	 * Optional. A member was removed from the group, information about them
	 * (this member may be bot itself)
	 */
	@JsonProperty("left_chat_participant")
	private User leftChatParticipantUser;
	/**
	 * Optional. A group title was changed to this value
	 */
	@JsonProperty("new_chat_title")
	private String newChatTitle;

	/**
	 * new_chat_photo Array of PhotoSize Optional. A group photo was change to
	 * this value
	 */
	@JsonProperty("new_chat_photo")
	private PhotoSize[] newChatPhoto;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/**
 * <p>Getter for the field <code>id</code>.</p>
 *
 * @return a {@link java.lang.Long} object.
 */

	public User getFromUser() {
		return fromUser;
	}
/**
 * <p>Setter for the field <code>id</code>.</p>
 *
 * @param id a {@link java.lang.Long} object.
 */

	public void setFromUser(final User fromUser) {
		this.fromUser = fromUser;
	}
/**
 * <p>Getter for the field <code>fromUser</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public Long getUnixTimeDate() {
		return unixTimeDate;
	}
/**
 * <p>Setter for the field <code>fromUser</code>.</p>
 *
 * @param fromUser a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public void setUnixTimeDate(final Long unixTimeDate) {
		this.unixTimeDate = unixTimeDate;
	}
/**
 * <p>Getter for the field <code>unixTimeDate</code>.</p>
 *
 * @return a {@link java.lang.Long} object.
 */

	public Chat getChat() {
		return chat;
	}
/**
 * <p>Setter for the field <code>unixTimeDate</code>.</p>
 *
 * @param unixTimeDate a {@link java.lang.Long} object.
 */

	@JsonProperty
	public void setChat(final JsonNode chat) {
		if (chat != null
				/**
				 * <p>Getter for the field <code>chat</code>.</p>
				 *
				 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Chat} object.
				 */
				&& (chat.toString() != null && chat.toString().length() != 0)) {
			if (chat.toString().contains("title")) {// must be groupchat
				this.chat = MapperHandler.INSTANCE.getObjectMapper()
						.convertValue(chat, GroupChat.class);
			/**
			 * <p>Setter for the field <code>chat</code>.</p>
			 *
			 * @param chat a {@link org.codehaus.jackson.JsonNode} object.
			 */
			} else if (chat.toString().contains("username")) {// must be user
				this.chat = MapperHandler.INSTANCE.getObjectMapper()
						.convertValue(chat, User.class);
			}
		}
	}

	public void setChat(final Chat chat) {
		this.chat = chat;
	}

	public User getForwardFromUser() {
		return forwardFromUser;
	}
/**
 * <p>Setter for the field <code>chat</code>.</p>
 *
 * @param chat a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Chat} object.
 */

	public void setForwardFromUser(final User forwardFromUser) {
		this.forwardFromUser = forwardFromUser;
	}
/**
 * <p>Getter for the field <code>forwardFromUser</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public Long getForwardDate() {
		return forwardDate;
	}
/**
 * <p>Setter for the field <code>forwardFromUser</code>.</p>
 *
 * @param forwardFromUser a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public void setForwardDate(final Long forwardDate) {
		this.forwardDate = forwardDate;
	}
/**
 * <p>Getter for the field <code>forwardDate</code>.</p>
 *
 * @return a {@link java.lang.Long} object.
 */

	public Message getReplyToMessage() {
		return replyToMessage;
	}
/**
 * <p>Setter for the field <code>forwardDate</code>.</p>
 *
 * @param forwardDate a {@link java.lang.Long} object.
 */

	public void setReplyToMessage(final Message replyToMessage) {
		this.replyToMessage = replyToMessage;
	}
/**
 * <p>Getter for the field <code>replyToMessage</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Message} object.
 */

	public String getText() {
		return text;
	}
/**
 * <p>Setter for the field <code>replyToMessage</code>.</p>
 *
 * @param replyToMessage a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Message} object.
 */

	public void setText(final String text) {
		this.text = text;
	}
/**
 * <p>Getter for the field <code>text</code>.</p>
 *
 * @return a {@link java.lang.String} object.
 */

	public Audio getAudio() {
		return audio;
	}
/**
 * <p>Setter for the field <code>text</code>.</p>
 *
 * @param text a {@link java.lang.String} object.
 */

	public void setAudio(final Audio audio) {
		this.audio = audio;
	}
/**
 * <p>Getter for the field <code>audio</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Audio} object.
 */

	public Document getDocument() {
		return document;
	}
/**
 * <p>Setter for the field <code>audio</code>.</p>
 *
 * @param audio a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Audio} object.
 */

	public void setDocument(final Document document) {
		this.document = document;
	}
/**
 * <p>Getter for the field <code>document</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Document} object.
 */

	public PhotoSize[] getPhoto() {
		return photo;
	}
/**
 * <p>Setter for the field <code>document</code>.</p>
 *
 * @param document a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Document} object.
 */

	public void setPhoto(final PhotoSize[] photo) {
		this.photo = photo;
	}
/**
 * <p>Getter for the field <code>photo</code>.</p>
 *
 * @return an array of {@link io.github.nixtabyte.telegram.jtelebot.response.json.PhotoSize} objects.
 */

	public Sticker getSticker() {
		return sticker;
	}
/**
 * <p>Setter for the field <code>photo</code>.</p>
 *
 * @param photo an array of {@link io.github.nixtabyte.telegram.jtelebot.response.json.PhotoSize} objects.
 */

	public void setSticker(final Sticker sticker) {
		this.sticker = sticker;
	}
/**
 * <p>Getter for the field <code>sticker</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Sticker} object.
 */

	public Video getVideo() {
		return video;
	}
/**
 * <p>Setter for the field <code>sticker</code>.</p>
 *
 * @param sticker a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Sticker} object.
 */

	public void setVideo(final Video video) {
		this.video = video;
	}
/**
 * <p>Getter for the field <code>video</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Video} object.
 */

	public Contact getContact() {
		return contact;
	}
/**
 * <p>Setter for the field <code>video</code>.</p>
 *
 * @param video a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Video} object.
 */

	public void setContact(final Contact contact) {
		this.contact = contact;
	}
/**
 * <p>Getter for the field <code>contact</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Contact} object.
 */

	public Location getLocation() {
		return location;
	}
/**
 * <p>Setter for the field <code>contact</code>.</p>
 *
 * @param contact a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Contact} object.
 */

	public void setLocation(final Location location) {
		this.location = location;
	}
/**
 * <p>Getter for the field <code>location</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Location} object.
 */

	public User getNewChatParticipantUser() {
		return newChatParticipantUser;
	}
/**
 * <p>Setter for the field <code>location</code>.</p>
 *
 * @param location a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Location} object.
 */

	public void setNewChatParticipantUser(final User newChatParticipantUser) {
		this.newChatParticipantUser = newChatParticipantUser;
	}
/**
 * <p>Getter for the field <code>newChatParticipantUser</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public User getLeftChatParticipantUser() {
		return leftChatParticipantUser;
	}
/**
 * <p>Setter for the field <code>newChatParticipantUser</code>.</p>
 *
 * @param newChatParticipantUser a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public void setLeftChatParticipantUser(final User leftChatParticipantUser) {
		this.leftChatParticipantUser = leftChatParticipantUser;
	}
/**
 * <p>Getter for the field <code>leftChatParticipantUser</code>.</p>
 *
 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public String getNewChatTitle() {
		return newChatTitle;
	}
/**
 * <p>Setter for the field <code>leftChatParticipantUser</code>.</p>
 *
 * @param leftChatParticipantUser a {@link io.github.nixtabyte.telegram.jtelebot.response.json.User} object.
 */

	public void setNewChatTitle(final String newChatTitle) {
		this.newChatTitle = newChatTitle;
	}
/**
 * <p>Getter for the field <code>newChatTitle</code>.</p>
 *
 * @return a {@link java.lang.String} object.
 */

	public PhotoSize[] getNewChatPhoto() {
		return newChatPhoto;
	}
/**
 * <p>Setter for the field <code>newChatTitle</code>.</p>
 *
 * @param newChatTitle a {@link java.lang.String} object.
 */

	public void setNewChatPhoto(final PhotoSize[] newChatPhoto) {
		this.newChatPhoto = newChatPhoto;
	}
/**
 * <p>Getter for the field <code>newChatPhoto</code>.</p>
 *
 * @return an array of {@link io.github.nixtabyte.telegram.jtelebot.response.json.PhotoSize} objects.
 */

	public Boolean getDeleteChatPhoto() {
		return deleteChatPhoto;
	}
/**
 * <p>Setter for the field <code>newChatPhoto</code>.</p>
 *
 * @param newChatPhoto an array of {@link io.github.nixtabyte.telegram.jtelebot.response.json.PhotoSize} objects.
 */

	public void setDeleteChatPhoto(final Boolean deleteChatPhoto) {
		this.deleteChatPhoto = deleteChatPhoto;
	}
/**
 * <p>Getter for the field <code>deleteChatPhoto</code>.</p>
 *
 * @return a {@link java.lang.Boolean} object.
 */

	public Boolean getGroupChatCreated() {
		return groupChatCreated;
	}
/**
 * <p>Setter for the field <code>deleteChatPhoto</code>.</p>
 *
 * @param deleteChatPhoto a {@link java.lang.Boolean} object.
 */

	public void setGroupChatCreated(final Boolean groupChatCreated) {
		this.groupChatCreated = groupChatCreated;
	}
/**
 * <p>Getter for the field <code>groupChatCreated</code>.</p>
 *
 * @return a {@link java.lang.Boolean} object.
 */

	@Override
	public int hashCode() {
		final int prime = 31;
		/**
		 * <p>Setter for the field <code>groupChatCreated</code>.</p>
		 *
		 * @param groupChatCreated a {@link java.lang.Boolean} object.
		 */
		int result = 1;
		result = prime * result + ((audio == null) ? 0 : audio.hashCode());
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		/** {@inheritDoc} */
		result = prime * result
				+ ((deleteChatPhoto == null) ? 0 : deleteChatPhoto.hashCode());
		result = prime * result
				+ ((document == null) ? 0 : document.hashCode());
		result = prime * result
				+ ((forwardDate == null) ? 0 : forwardDate.hashCode());
		result = prime * result
				+ ((forwardFromUser == null) ? 0 : forwardFromUser.hashCode());
		result = prime * result
				+ ((fromUser == null) ? 0 : fromUser.hashCode());
		result = prime
				* result
				+ ((groupChatCreated == null) ? 0 : groupChatCreated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((leftChatParticipantUser == null) ? 0
						: leftChatParticipantUser.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime
				* result
				+ ((newChatParticipantUser == null) ? 0
						: newChatParticipantUser.hashCode());
		result = prime * result + Arrays.hashCode(newChatPhoto);
		result = prime * result
				+ ((newChatTitle == null) ? 0 : newChatTitle.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result
				+ ((replyToMessage == null) ? 0 : replyToMessage.hashCode());
		result = prime * result + ((sticker == null) ? 0 : sticker.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result
				+ ((unixTimeDate == null) ? 0 : unixTimeDate.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			/** {@inheritDoc} */
			return false;
		Message other = (Message) obj;
		if (audio == null) {
			if (other.audio != null)
				return false;
		} else if (!audio.equals(other.audio))
			return false;
		if (chat == null) {
			if (other.chat != null)
				return false;
		} else if (!chat.equals(other.chat))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (deleteChatPhoto == null) {
			if (other.deleteChatPhoto != null)
				return false;
		} else if (!deleteChatPhoto.equals(other.deleteChatPhoto))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (forwardDate == null) {
			if (other.forwardDate != null)
				return false;
		} else if (!forwardDate.equals(other.forwardDate))
			return false;
		if (forwardFromUser == null) {
			if (other.forwardFromUser != null)
				return false;
		} else if (!forwardFromUser.equals(other.forwardFromUser))
			return false;
		if (fromUser == null) {
			if (other.fromUser != null)
				return false;
		} else if (!fromUser.equals(other.fromUser))
			return false;
		if (groupChatCreated == null) {
			if (other.groupChatCreated != null)
				return false;
		} else if (!groupChatCreated.equals(other.groupChatCreated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leftChatParticipantUser == null) {
			if (other.leftChatParticipantUser != null)
				return false;
		} else if (!leftChatParticipantUser
				.equals(other.leftChatParticipantUser))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (newChatParticipantUser == null) {
			if (other.newChatParticipantUser != null)
				return false;
		} else if (!newChatParticipantUser.equals(other.newChatParticipantUser))
			return false;
		if (!Arrays.equals(newChatPhoto, other.newChatPhoto))
			return false;
		if (newChatTitle == null) {
			if (other.newChatTitle != null)
				return false;
		} else if (!newChatTitle.equals(other.newChatTitle))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		if (replyToMessage == null) {
			if (other.replyToMessage != null)
				return false;
		} else if (!replyToMessage.equals(other.replyToMessage))
			return false;
		if (sticker == null) {
			if (other.sticker != null)
				return false;
		} else if (!sticker.equals(other.sticker))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (unixTimeDate == null) {
			if (other.unixTimeDate != null)
				return false;
		} else if (!unixTimeDate.equals(other.unixTimeDate))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", fromUser=" + fromUser
				+ ", unixTimeDate=" + unixTimeDate + ", chat=" + chat
				+ ", forwardFromUser=" + forwardFromUser + ", forwardDate="
				+ forwardDate + ", replyToMessage=" + replyToMessage
				+ ", text=" + text + ", audio=" + audio + ", document="
				/** {@inheritDoc} */
				+ document + ", photo=" + Arrays.toString(photo) + ", sticker="
				+ sticker + ", video=" + video + ", contact=" + contact
				+ ", location=" + location + ", newChatParticipantUser="
				+ newChatParticipantUser + ", leftChatParticipantUser="
				+ leftChatParticipantUser + ", newChatTitle=" + newChatTitle
				+ ", newChatPhoto=" + Arrays.toString(newChatPhoto)
				+ ", deleteChatPhoto=" + deleteChatPhoto
				+ ", groupChatCreated=" + groupChatCreated + "]";
	}

	
}
