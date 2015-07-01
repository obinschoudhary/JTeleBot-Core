package com.roadtonerdvana.jtelebot.response.json;
/**
 * 
 * This object represents a message.
 *
 */
public class Message {
	
/**
 * 

Field	Type	Description
message_id	Integer	Unique message identifier
from	User	Sender
date	Integer	Date the message was sent in Unix time
chat	User or GroupChat	Conversation the message belongs to — user in case of a private message, GroupChat in case of a group
forward_from	User	Optional. For forwarded messages, sender of the original message
forward_date	Integer	Optional. For forwarded messages, date the original message was sent in Unix time
reply_to_message	Message	Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
text	String	Optional. For text messages, the actual UTF-8 text of the message
audio	Audio	Optional. Message is an audio file, information about the file
document	Document	Optional. Message is a general file, information about the file
photo	Array of PhotoSize	Optional. Message is a photo, available sizes of the photo
sticker	Sticker	Optional. Message is a sticker, information about the sticker
video	Video	Optional. Message is a video, information about the video
contact	Contact	Optional. Message is a shared contact, information about the contact
location	Location	Optional. Message is a shared location, information about the location
new_chat_participant	User	Optional. A new member was added to the group, information about them (this member may be bot itself)
left_chat_participant	User	Optional. A member was removed from the group, information about them (this member may be bot itself)
new_chat_title	String	Optional. A group title was changed to this value
new_chat_photo	Array of PhotoSize	Optional. A group photo was change to this value
delete_chat_photo	True	Optional. Informs that the group photo was deleted
group_chat_created	True	Optional. Informs that the group has been created
 */
}
