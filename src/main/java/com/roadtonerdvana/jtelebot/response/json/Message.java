package com.roadtonerdvana.jtelebot.response.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import com.roadtonerdvana.jtelebot.mapper.json.MapperHandler;

/**
 * 
 * This object represents a message.
 *
 */
public class Message extends Result {
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
	 * Conversation the message belongs to — user in case of a private message,
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
	private Integer forwardDate;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(final User fromUser) {
		this.fromUser = fromUser;
	}

	public int getUnixTimeDate() {
		return unixTimeDate;
	}

	public void setUnixTimeDate(final int unixTimeDate) {
		this.unixTimeDate = unixTimeDate;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(final JsonNode chat) {
		/**
		 * NOT SURE IF UGLY HACK 
		 * 
		 * http://meatified.com/wp-content/uploads/2013/10/futurama-fry-not-sure-if.jpg
		 * 
		 * OF GENIOUS 
		 */
		if(chat!=null){
			if(chat.asText()!=null&&chat.asText().contains("title")){//must be groupchat
				this.chat = MapperHandler.INSTANCE.getObjectMapper().convertValue(chat, GroupChat.class);
				return;
			}
			if(chat.asText()!=null&&chat.asText().contains("username")){//must be user
				this.chat = MapperHandler.INSTANCE.getObjectMapper().convertValue(chat, User.class);
				return;
			}
		}
	}

	public User getForwardFromUser() {
		return forwardFromUser;
	}

	public void setForwardFromUser(final User forwardFromUser) {
		this.forwardFromUser = forwardFromUser;
	}

	public Integer getForwardDate() {
		return forwardDate;
	}

	public void setForwardDate(final Integer forwardDate) {
		this.forwardDate = forwardDate;
	}

	public Message getReplyToMessage() {
		return replyToMessage;
	}

	public void setReplyToMessage(final Message replyToMessage) {
		this.replyToMessage = replyToMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(final Audio audio) {
		this.audio = audio;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(final Document document) {
		this.document = document;
	}

	public PhotoSize[] getPhoto() {
		return photo;
	}

	public void setPhoto(final PhotoSize[] photo) {
		this.photo = photo;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public void setSticker(final Sticker sticker) {
		this.sticker = sticker;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(final Contact contact) {
		this.contact = contact;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}

	public User getNewChatParticipantUser() {
		return newChatParticipantUser;
	}

	public void setNewChatParticipantUser(final User newChatParticipantUser) {
		this.newChatParticipantUser = newChatParticipantUser;
	}

	public User getLeftChatParticipantUser() {
		return leftChatParticipantUser;
	}

	public void setLeftChatParticipantUser(final User leftChatParticipantUser) {
		this.leftChatParticipantUser = leftChatParticipantUser;
	}

	public String getNewChatTitle() {
		return newChatTitle;
	}

	public void setNewChatTitle(final String newChatTitle) {
		this.newChatTitle = newChatTitle;
	}

	public PhotoSize[] getNewChatPhoto() {
		return newChatPhoto;
	}

	public void setNewChatPhoto(final PhotoSize[] newChatPhoto) {
		this.newChatPhoto = newChatPhoto;
	}

	public Boolean getDeleteChatPhoto() {
		return deleteChatPhoto;
	}

	public void setDeleteChatPhoto(final Boolean deleteChatPhoto) {
		this.deleteChatPhoto = deleteChatPhoto;
	}

	public Boolean getGroupChatCreated() {
		return groupChatCreated;
	}

	public void setGroupChatCreated(final Boolean groupChatCreated) {
		this.groupChatCreated = groupChatCreated;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", fromUser=" + fromUser
				+ ", unixTimeDate=" + unixTimeDate + ", chat=" + chat
				+ ", forwardFromUser=" + forwardFromUser + ", forwardDate="
				+ forwardDate + ", replyToMessage=" + replyToMessage
				+ ", text=" + text + ", audio=" + audio + ", document="
				+ document + ", photo=" + photo + ", sticker=" + sticker
				+ ", video=" + video + ", contact=" + contact + ", location="
				+ location + ", newChatParticipantUser="
				+ newChatParticipantUser + ", leftChatParticipantUser="
				+ leftChatParticipantUser + ", newChatTitle=" + newChatTitle
				+ ", newChatPhoto=" + newChatPhoto + ", deleteChatPhoto="
				+ deleteChatPhoto + ", groupChatCreated=" + groupChatCreated
				+ "]";
	}
}
