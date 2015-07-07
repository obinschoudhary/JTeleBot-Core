/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.roadtonerdvana.jtelebot.mapper.json;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.response.json.Audio;
import com.roadtonerdvana.jtelebot.response.json.Contact;
import com.roadtonerdvana.jtelebot.response.json.Document;
import com.roadtonerdvana.jtelebot.response.json.ForceReply;
import com.roadtonerdvana.jtelebot.response.json.GroupChat;
import com.roadtonerdvana.jtelebot.response.json.Location;
import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.response.json.PhotoSize;
import com.roadtonerdvana.jtelebot.response.json.ReplyKeyboardHide;
import com.roadtonerdvana.jtelebot.response.json.ReplyKeyboardMarkup;
import com.roadtonerdvana.jtelebot.response.json.Sticker;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.response.json.User;
import com.roadtonerdvana.jtelebot.response.json.UserProfilePhotos;
import com.roadtonerdvana.jtelebot.response.json.Video;

public class MapperTest {

	
	private String originalAudioString = "{\"duration\":100,\"file_id\":\"my audio file id\",\"mime_type\":\"mime type\",\"file_size\":254}";
	private String originalContactString = "{\"phone_number\":\"user's phone number\",\"first_name\":\"first name\",\"last_name\":\"last name\",\"user_id\":\"userID\"}";
	private String originalPhotoSizeString = "{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125}";
	private String originalDocumentString = "{\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"document id\",\"file_name\":\"document file name\",\"mime_type\":\"the mime type\",\"file_size\":165}";
	private String originalForceReplyString = "{\"selective\":false,\"force_reply\":true}";
	private String originalGroupChatString= "{\"id\":1241,\"title\":\"group chat title\"}";
	private String originalLocationString = "{\"longitude\":4674.3632,\"latitude\":124124.12341}";
	private String originalKeyboardHideString = "{\"selective\":false,\"hide_keyboard\":true}";
	private String originalKeyboardMarkupString = "{\"keyboard\":[[\"first\",\"second\"],[\"third\"],[\"fourth\"]],\"selective\":true,\"resize_keyboard\":true,\"one_time_keyboard\":false}";
	private String originalStickerString = "{\"width\":5656,\"height\":12314,\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"Sticker id\",\"file_size\":165}";
	private String originalUserString = "{\"id\":21451,\"username\":\"user name\",\"first_name\":\"first name\",\"last_name\":\"last name\"}";
	private String originalVideoString = "{\"width\":5656,\"height\":12314,\"duration\":151,\"thumb\":null,\"caption\":\"video caption\",\"file_id\":\"Video id\",\"mime_type\":\"mime type\",\"file_size\":165}";
	private String originalUserProfilePhotosString = "{\"photos\":[[{\"width\":34,\"height\":62,\"file_id\":\"PhotoSize id0\",\"file_size\":621}],[{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id1\",\"file_size\":125},{\"width\":773,\"height\":4567,\"file_id\":\"PhotoSize id4\",\"file_size\":3221}],[{\"width\":123,\"height\":35,\"file_id\":\"PhotoSize id2\",\"file_size\":88},{\"width\":57,\"height\":732,\"file_id\":\"PhotoSize id3\",\"file_size\":111}]],\"total_count\":10}";
	private String originalMessageString ="{\"chat\":{\"id\":1241,\"title\":\"group chat title\"},\"text\":\"text text text\",\"audio\":{\"duration\":100,\"file_id\":\"my audio file id\",\"mime_type\":\"mime type\",\"file_size\":254},\"document\":{\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"document id\",\"file_name\":\"document file name\",\"mime_type\":\"the mime type\",\"file_size\":165},\"photo\":[{\"width\":57,\"height\":732,\"file_id\":\"PhotoSize id3\",\"file_size\":111},{\"width\":773,\"height\":4567,\"file_id\":\"PhotoSize id4\",\"file_size\":3221}],\"sticker\":{\"width\":5656,\"height\":12314,\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"Sticker id\",\"file_size\":165},\"video\":{\"width\":5656,\"height\":12314,\"duration\":151,\"thumb\":null,\"caption\":\"video caption\",\"file_id\":\"Video id\",\"mime_type\":\"mime type\",\"file_size\":165},\"contact\":{\"phone_number\":\"user's phone number\",\"first_name\":\"first name\",\"last_name\":\"last name\",\"user_id\":\"userID\"},\"location\":{\"longitude\":4674.3632,\"latitude\":124124.12341},\"message_id\":352345,\"from\":{\"id\":121451,\"username\":\"user name01\",\"first_name\":\"first name01\",\"last_name\":\"last name01\"},\"date\":2325252,\"forward_from\":{\"id\":21451,\"username\":\"user name0\",\"first_name\":\"first name0\",\"last_name\":\"last name0\"},\"forward_date\":235254,\"reply_to_message\":{\"chat\":null,\"text\":\"its gonna rain rain rain\",\"audio\":null,\"document\":null,\"photo\":null,\"sticker\":null,\"video\":null,\"contact\":null,\"location\":null,\"message_id\":325,\"from\":null,\"date\":0,\"forward_from\":null,\"forward_date\":null,\"reply_to_message\":null,\"new_chat_participant\":null,\"left_chat_participant\":null,\"new_chat_title\":null,\"new_chat_photo\":null,\"delete_chat_photo\":null,\"group_chat_created\":null},\"new_chat_participant\":{\"id\":1214512,\"username\":\"user name03\",\"first_name\":\"first name03\",\"last_name\":\"last name03\"},\"left_chat_participant\":{\"id\":1214512,\"username\":\"user name02\",\"first_name\":\"first name02\",\"last_name\":\"last name02\"},\"new_chat_title\":\"new chat title\",\"new_chat_photo\":[{\"width\":34,\"height\":62,\"file_id\":\"PhotoSize id0\",\"file_size\":621},{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id1\",\"file_size\":125},{\"width\":123,\"height\":35,\"file_id\":\"PhotoSize id2\",\"file_size\":88}],\"delete_chat_photo\":true,\"group_chat_created\":false}";
	private String originalUpdateString = "{\"message\":{\"chat\":{\"id\":1241,\"title\":\"group chat title\"},\"text\":\"text text text\",\"audio\":{\"duration\":100,\"file_id\":\"my audio file id\",\"mime_type\":\"mime type\",\"file_size\":254},\"document\":{\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"document id\",\"file_name\":\"document file name\",\"mime_type\":\"the mime type\",\"file_size\":165},\"photo\":[{\"width\":57,\"height\":732,\"file_id\":\"PhotoSize id3\",\"file_size\":111},{\"width\":773,\"height\":4567,\"file_id\":\"PhotoSize id4\",\"file_size\":3221}],\"sticker\":{\"width\":5656,\"height\":12314,\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"Sticker id\",\"file_size\":165},\"video\":{\"width\":5656,\"height\":12314,\"duration\":151,\"thumb\":null,\"caption\":\"video caption\",\"file_id\":\"Video id\",\"mime_type\":\"mime type\",\"file_size\":165},\"contact\":{\"phone_number\":\"user's phone number\",\"first_name\":\"first name\",\"last_name\":\"last name\",\"user_id\":\"userID\"},\"location\":{\"longitude\":4674.3632,\"latitude\":124124.12341},\"message_id\":352345,\"from\":{\"id\":121451,\"username\":\"user name01\",\"first_name\":\"first name01\",\"last_name\":\"last name01\"},\"date\":2325252,\"forward_from\":{\"id\":21451,\"username\":\"user name0\",\"first_name\":\"first name0\",\"last_name\":\"last name0\"},\"forward_date\":235254,\"reply_to_message\":{\"chat\":null,\"text\":\"its gonna rain rain rain\",\"audio\":null,\"document\":null,\"photo\":null,\"sticker\":null,\"video\":null,\"contact\":null,\"location\":null,\"message_id\":325,\"from\":null,\"date\":0,\"forward_from\":null,\"forward_date\":null,\"reply_to_message\":null,\"new_chat_participant\":null,\"left_chat_participant\":null,\"new_chat_title\":null,\"new_chat_photo\":null,\"delete_chat_photo\":null,\"group_chat_created\":null},\"new_chat_participant\":{\"id\":1214512,\"username\":\"user name03\",\"first_name\":\"first name03\",\"last_name\":\"last name03\"},\"left_chat_participant\":{\"id\":1214512,\"username\":\"user name02\",\"first_name\":\"first name02\",\"last_name\":\"last name02\"},\"new_chat_title\":\"new chat title\",\"new_chat_photo\":[{\"width\":34,\"height\":62,\"file_id\":\"PhotoSize id0\",\"file_size\":621},{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id1\",\"file_size\":125},{\"width\":123,\"height\":35,\"file_id\":\"PhotoSize id2\",\"file_size\":88}],\"delete_chat_photo\":true,\"group_chat_created\":false},\"update_id\":524352}";
	private String originalTelegramResponseString ="{\"description\":\"description of the response\",\"result\":[{\"message\":{\"chat\":{\"id\":1241,\"title\":\"group chat title\"},\"text\":\"text text text\",\"audio\":{\"duration\":100,\"file_id\":\"my audio file id\",\"mime_type\":\"mime type\",\"file_size\":254},\"document\":{\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"document id\",\"file_name\":\"document file name\",\"mime_type\":\"the mime type\",\"file_size\":165},\"photo\":[{\"width\":57,\"height\":732,\"file_id\":\"PhotoSize id3\",\"file_size\":111},{\"width\":773,\"height\":4567,\"file_id\":\"PhotoSize id4\",\"file_size\":3221}],\"sticker\":{\"width\":5656,\"height\":12314,\"thumb\":{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id\",\"file_size\":125},\"file_id\":\"Sticker id\",\"file_size\":165},\"video\":{\"width\":5656,\"height\":12314,\"duration\":151,\"thumb\":null,\"caption\":\"video caption\",\"file_id\":\"Video id\",\"mime_type\":\"mime type\",\"file_size\":165},\"contact\":{\"phone_number\":\"user's phone number\",\"first_name\":\"first name\",\"last_name\":\"last name\",\"user_id\":\"userID\"},\"location\":{\"longitude\":4674.3632,\"latitude\":124124.12341},\"message_id\":352345,\"from\":{\"id\":121451,\"username\":\"user name01\",\"first_name\":\"first name01\",\"last_name\":\"last name01\"},\"date\":2325252,\"forward_from\":{\"id\":21451,\"username\":\"user name0\",\"first_name\":\"first name0\",\"last_name\":\"last name0\"},\"forward_date\":235254,\"reply_to_message\":{\"chat\":null,\"text\":\"its gonna rain rain rain\",\"audio\":null,\"document\":null,\"photo\":null,\"sticker\":null,\"video\":null,\"contact\":null,\"location\":null,\"message_id\":325,\"from\":null,\"date\":0,\"forward_from\":null,\"forward_date\":null,\"reply_to_message\":null,\"new_chat_participant\":null,\"left_chat_participant\":null,\"new_chat_title\":null,\"new_chat_photo\":null,\"delete_chat_photo\":null,\"group_chat_created\":null},\"new_chat_participant\":{\"id\":1214512,\"username\":\"user name03\",\"first_name\":\"first name03\",\"last_name\":\"last name03\"},\"left_chat_participant\":{\"id\":1214512,\"username\":\"user name02\",\"first_name\":\"first name02\",\"last_name\":\"last name02\"},\"new_chat_title\":\"new chat title\",\"new_chat_photo\":[{\"width\":34,\"height\":62,\"file_id\":\"PhotoSize id0\",\"file_size\":621},{\"width\":123,\"height\":124,\"file_id\":\"PhotoSize id1\",\"file_size\":125},{\"width\":123,\"height\":35,\"file_id\":\"PhotoSize id2\",\"file_size\":88}],\"delete_chat_photo\":true,\"group_chat_created\":false},\"update_id\":524352}],\"ok\":true,\"error_code\":0}";

	
	private Update originalUpdate;
	private Document originalDocument;
	private Sticker originalSticker;
	private Video   originalVideo;
	private Audio	originalAudio;
	private User originalUser;
	private User originalUser0;
	private User originalUser1;
	private User originalUser2;
	private User originalUser3;

	private PhotoSize originalPhotoSize;
	private PhotoSize originalPhotoSize0;
	private PhotoSize originalPhotoSize1;
	private PhotoSize originalPhotoSize2;
	private PhotoSize originalPhotoSize3;
	private PhotoSize originalPhotoSize4;
	private ForceReply originalForceReply;
	private Contact originalContact;
	private GroupChat originalGroupChat;
	private Location originalLocation;
	private ReplyKeyboardHide originalReplyKeyboardHide;
	private ReplyKeyboardMarkup originalReplyKeyboardMarkup;
	private Message originalMessage;
	private Message originalMessage0;
	private UserProfilePhotos originalUserProfilePhotos;
	public TelegramResponse<?> originalTelegramResponse;
	public MapperTest(){
		originalVideo = new Video();
		originalVideo.setFileId("Video id");
		originalVideo.setHeight(12314);
		originalVideo.setWidth(5656);
		originalVideo.setThumb(originalPhotoSize);
		originalVideo.setFileSize(165);
		originalVideo.setDuration(151);
		originalVideo.setCaption("video caption");
		originalVideo.setMimeType("mime type");
		originalAudio = new Audio();
		originalAudio.setDuration(100);
		originalAudio.setFileId("my audio file id");
		originalAudio.setFileSize(254);
		originalAudio.setMimeType("mime type");
		originalContact = new Contact();
		originalContact.setUserId("userID");
		originalContact.setLastName("last name");
		originalContact.setFirstName("first name");
		originalContact.setPhoneNumber("user's phone number");
		originalPhotoSize = new PhotoSize();
		originalPhotoSize.setFileId("PhotoSize id");
		originalPhotoSize.setWidth(123);
		originalPhotoSize.setHeight(124);
		originalPhotoSize.setFileSize(125);
		originalPhotoSize0 = new PhotoSize();
		originalPhotoSize0.setFileId("PhotoSize id0");
		originalPhotoSize0.setWidth(34);
		originalPhotoSize0.setHeight(62);
		originalPhotoSize0.setFileSize(621);
		originalPhotoSize1 = new PhotoSize();
		originalPhotoSize1.setFileId("PhotoSize id1");
		originalPhotoSize1.setWidth(123);
		originalPhotoSize1.setHeight(124);
		originalPhotoSize1.setFileSize(125);
		originalPhotoSize2 = new PhotoSize();
		originalPhotoSize2.setFileId("PhotoSize id2");
		originalPhotoSize2.setWidth(123);
		originalPhotoSize2.setHeight(35);
		originalPhotoSize2.setFileSize(88);
		originalPhotoSize3 = new PhotoSize();
		originalPhotoSize3.setFileId("PhotoSize id3");
		originalPhotoSize3.setWidth(57);
		originalPhotoSize3.setHeight(732);
		originalPhotoSize3.setFileSize(111);
		originalPhotoSize4 = new PhotoSize();
		originalPhotoSize4.setFileId("PhotoSize id4");
		originalPhotoSize4.setWidth(773);
		originalPhotoSize4.setHeight(4567);
		originalPhotoSize4.setFileSize(3221);
		originalDocument = new Document();
		originalDocument.setFileId("document id");
		originalDocument.setThumb(originalPhotoSize);
		originalDocument.setFileName("document file name");
		originalDocument.setMimeType("the mime type");
		originalDocument.setFileSize(165);
		originalForceReply = new ForceReply();
		originalForceReply.setForceReply(true);
		originalForceReply.setSelective(false);
		originalGroupChat = new GroupChat();
		originalGroupChat.setTitle("group chat title");
		originalGroupChat.setId(1241);
		originalLocation = new Location();
		originalLocation.setLatitude(124124.12341);
		originalLocation.setLongitude(4674.3632);
		originalReplyKeyboardHide = new ReplyKeyboardHide();
		originalReplyKeyboardHide.setSelective(false);
		originalReplyKeyboardHide.setHideKeyboard(true);
		originalReplyKeyboardMarkup = new ReplyKeyboardMarkup();
		originalReplyKeyboardMarkup.setOneTimeKeyboard(false);
		originalReplyKeyboardMarkup.setResizeKeyboard(true);
		originalReplyKeyboardMarkup.setSelective(true);
		originalReplyKeyboardMarkup.setKeyboard(new String[][]{{"first","second"},{"third"},{"fourth"}});
		originalSticker = new Sticker();
		originalSticker.setFileId("Sticker id");
		originalSticker.setHeight(12314);
		originalSticker.setWidth(5656);
		originalSticker.setThumb(originalPhotoSize);
		originalSticker.setFileSize(165);
		originalUser = new User();
		originalUser.setId(21451);
		originalUser.setFirstName("first name");
		originalUser.setLastName("last name");
		originalUser.setUsername("user name");
		originalUser0 = new User();
		originalUser0.setId(21451);
		originalUser0.setFirstName("first name0");
		originalUser0.setLastName("last name0");
		originalUser0.setUsername("user name0");
		originalUser1 = new User();
		originalUser1.setId(121451);
		originalUser1.setFirstName("first name01");
		originalUser1.setLastName("last name01");
		originalUser1.setUsername("user name01");
		originalUser2 = new User();
		originalUser2.setId(1214512);
		originalUser2.setFirstName("first name02");
		originalUser2.setLastName("last name02");
		originalUser2.setUsername("user name02");
		originalUser3 = new User();
		originalUser3.setId(1214512);
		originalUser3.setFirstName("first name03");
		originalUser3.setLastName("last name03");
		originalUser3.setUsername("user name03");
		originalMessage = new Message();
		originalMessage.setAudio(originalAudio);
		originalMessage.setChat(originalGroupChat);
		originalMessage.setContact(originalContact);
		originalMessage.setDeleteChatPhoto(true);
		originalMessage.setDocument(originalDocument);
		originalMessage.setForwardDate(235254L);
		originalMessage.setForwardFromUser(originalUser0);
		originalMessage.setFromUser(originalUser1);
		originalMessage.setGroupChatCreated(false);
		originalMessage.setId(352345L);
		originalMessage.setLeftChatParticipantUser(originalUser2);
		originalMessage.setLocation(originalLocation);
		originalMessage.setNewChatParticipantUser(originalUser3);
		originalMessage.setNewChatPhoto(new PhotoSize[]{originalPhotoSize0, originalPhotoSize1, originalPhotoSize2});
		originalMessage.setNewChatTitle("new chat title");
		originalMessage.setPhoto(new PhotoSize[]{originalPhotoSize3, originalPhotoSize4});
		originalMessage0 = new Message();
		originalMessage0.setId(325L);
		originalMessage0.setText("its gonna rain rain rain");
		originalMessage0.setUnixTimeDate(0L);
		originalMessage.setReplyToMessage(originalMessage0);
		originalMessage.setSticker(originalSticker);
		originalMessage.setText("text text text");
		originalMessage.setUnixTimeDate(2325252L);
		originalMessage.setVideo(originalVideo);
		originalUpdate = new Update();
		originalUpdate.setMessage(originalMessage);
		originalUpdate.setUpdateId(524352L);
		originalUserProfilePhotos = new UserProfilePhotos();
		originalUserProfilePhotos.setTotalCount(10);
		originalUserProfilePhotos.setPhotos(new PhotoSize[][]{{originalPhotoSize0},{originalPhotoSize1,originalPhotoSize4},{originalPhotoSize2,originalPhotoSize3}});
		originalTelegramResponse = new TelegramResponse<Update>();
		originalTelegramResponse.setDescription("description of the response");
		originalTelegramResponse.setErrorCode(0);
		List <Update>sel = new ArrayList<Update>();
		sel.add(originalUpdate);
		helper(sel);
		originalTelegramResponse.setSuccessful(true);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void helper(List list) {
		  originalTelegramResponse.setResult(list);
		}
	
	@Test
	public void testAudio() throws JsonGenerationException, JsonMappingException, IOException{
		String jsonAudio = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalAudio);
		System.out.println(jsonAudio);
		assertEquals(originalAudioString,jsonAudio);
		Audio mappedAudio = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonAudio, Audio.class);
		assertEquals(originalAudio, mappedAudio);
	}
	
	@Test
	public void testContact() throws JsonParseException, JsonMappingException, IOException{
		String jsonContact = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalContact);
		System.out.println(jsonContact);
		assertEquals(originalContactString,jsonContact);
		Contact mappedContact = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonContact, Contact.class);
		assertEquals(originalContact, mappedContact);		
	}
	
	@Test
	public void testPhotoSize() throws JsonParseException, JsonMappingException, IOException{
		String jsonPhotoSize = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalPhotoSize);
		System.out.println(jsonPhotoSize);
		assertEquals(originalPhotoSizeString,jsonPhotoSize);
		PhotoSize mappedPhotoSize = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonPhotoSize, PhotoSize.class);	
		assertEquals(originalPhotoSize, mappedPhotoSize);
	}
	
	@Test
	public void testDocument() throws JsonParseException, JsonMappingException, IOException{
		String jsonDocument = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalDocument);
		System.out.println(jsonDocument);
		assertEquals(originalDocumentString,jsonDocument);
		Document mappedDocument = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonDocument, Document.class);
		assertEquals(originalDocument, mappedDocument);
	}
	
	@Test
	public void testForceReply() throws JsonParseException, JsonMappingException, IOException{
		String jsonForceReply = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalForceReply);
		System.out.println(jsonForceReply);
		assertEquals(originalForceReplyString,jsonForceReply);
		ForceReply mappedForceReply = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonForceReply, ForceReply.class);
		assertEquals(originalForceReply, mappedForceReply);
	}
	
	@Test
	public void testGroupChat() throws JsonParseException, JsonMappingException, IOException{
		String jsonGroupChat = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalGroupChat);
		System.out.println(jsonGroupChat);
		assertEquals(originalGroupChatString,jsonGroupChat);
		GroupChat mappedGroupChat = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonGroupChat, GroupChat.class);
		assertEquals(originalGroupChat, mappedGroupChat);
	}
	
	@Test
	public void testLocation() throws JsonParseException, JsonMappingException, IOException{
		String jsonLocation = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalLocation);
		System.out.println(jsonLocation);
		assertEquals(originalLocationString,jsonLocation);
		Location mappedLocation = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonLocation, Location.class);
		assertEquals(originalLocation, mappedLocation);
	}
	
	@Test
	public void testReplyKeyboardHide() throws JsonParseException, JsonMappingException, IOException{
		String jsonReplyKeyboardHide = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalReplyKeyboardHide);
		System.out.println(jsonReplyKeyboardHide);
		assertEquals(originalKeyboardHideString,jsonReplyKeyboardHide);
		ReplyKeyboardHide mappedReplyKeyboardHide = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonReplyKeyboardHide, ReplyKeyboardHide.class);
		assertEquals(originalReplyKeyboardHide, mappedReplyKeyboardHide);
	}
	
	@Test
	public void testReplyKeyboardMarkup() throws JsonParseException, JsonMappingException, IOException{
		String jsonReplyKeyboardMarkup = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalReplyKeyboardMarkup);
		System.out.println(jsonReplyKeyboardMarkup);
		assertEquals(originalKeyboardMarkupString,jsonReplyKeyboardMarkup);
		ReplyKeyboardMarkup mappedReplyKeyboardMarkup = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonReplyKeyboardMarkup, ReplyKeyboardMarkup.class);
		assertEquals(originalReplyKeyboardMarkup, mappedReplyKeyboardMarkup);
	}
	
	@Test
	public void testSticker() throws JsonParseException, JsonMappingException, IOException{
		String jsonSticker = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalSticker);
		System.out.println(jsonSticker);
		assertEquals(originalStickerString,jsonSticker);
		Sticker mappedSticker = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonSticker, Sticker.class);
		assertEquals(originalSticker, mappedSticker);
	}
	
	
	@Test
	public void testUser() throws JsonParseException, JsonMappingException, IOException{
		String jsonUser = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalUser);
		System.out.println(jsonUser);
		assertEquals(originalUserString,jsonUser);
		User mappedUser = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonUser, User.class);
		assertEquals(originalUser, mappedUser);
	}
	
	
	@Test
	public void testVideo() throws JsonParseException, JsonMappingException, IOException{
		String jsonVideo = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalVideo);
		System.out.println(jsonVideo);
		assertEquals(originalVideoString,jsonVideo);
		Video mappedVideo = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonVideo, Video.class);
		assertEquals(originalVideo, mappedVideo);
	}
	
	@Test
	public void testUserProfilePhotos() throws JsonGenerationException, JsonMappingException, IOException{
		String jsonUserProfilePhotos = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalUserProfilePhotos);
		System.out.println(jsonUserProfilePhotos);
		assertEquals(originalUserProfilePhotosString,jsonUserProfilePhotos);
		UserProfilePhotos mappedUserProfilePhotos = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonUserProfilePhotos, UserProfilePhotos.class);
		assertEquals(originalUserProfilePhotos, mappedUserProfilePhotos);
	}
	
	
	@Test
	public void testMessage() throws JsonGenerationException, JsonMappingException, IOException{
		String jsonMessage = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalMessage);
		System.out.println(jsonMessage);
		assertEquals(originalMessageString,jsonMessage);
		Message mappedMessage = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonMessage, Message.class);
		assertEquals(originalMessage, mappedMessage);
	}
	
	@Test
	public void testUpdate() throws JsonGenerationException, JsonMappingException, IOException{
		String jsonUpdate = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalUpdate);
		System.out.println(jsonUpdate);
		assertEquals(originalUpdateString,jsonUpdate);
		Update mappedUpdate = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonUpdate, Update.class);
		assertEquals(originalUpdate, mappedUpdate);
	}
	
	@Test
	public void testTelegramResponse() throws JsonGenerationException, JsonMappingException, IOException{
		String jsonTelegramResponse = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(originalTelegramResponse);
		System.out.println(jsonTelegramResponse);
		assertEquals(originalTelegramResponseString,jsonTelegramResponse);
		TelegramResponse<Update> mappedTelegramResponse = MapperHandler.INSTANCE.getObjectMapper().readValue(jsonTelegramResponse, MapperHandler.INSTANCE.getObjectMapper().getTypeFactory().constructParametricType(TelegramResponse.class, Update.class));
		assertEquals(originalTelegramResponse, mappedTelegramResponse);
	}
}
