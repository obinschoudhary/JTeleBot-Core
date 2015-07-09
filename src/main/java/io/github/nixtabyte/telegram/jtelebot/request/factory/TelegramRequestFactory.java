/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.request.factory;

import io.github.nixtabyte.telegram.jtelebot.client.BroadcastActionType;
import io.github.nixtabyte.telegram.jtelebot.client.RequestType;
import io.github.nixtabyte.telegram.jtelebot.mapper.json.MapperHandler;
import io.github.nixtabyte.telegram.jtelebot.request.TelegramRequest;
import io.github.nixtabyte.telegram.jtelebot.response.json.CustomReplyKeyboard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * 
 * This class is a Factory of TelegramRequest objects
 *
 */
public final class TelegramRequestFactory {
	/**
	 * TODO:
	 * Validation class...
	 * 
	 */
	
	private TelegramRequestFactory(){}
	/**
	 * 
	 * @return
	 */
	public static TelegramRequest createGetMeRequest(){
		return new TelegramRequest(RequestType.GET_ME,new ArrayList<BasicNameValuePair>());
	}
	/**
	 * 
	 * @param chatId
	 * @param text
	 * @param disableWebPagePreview
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendMessageRequest(final long chatId,final String text, final boolean disableWebPagePreview, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("text",text));
		basicNameValuePair.add(new BasicNameValuePair("disable_web_page_preview",String.valueOf(disableWebPagePreview)));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_MESSAGE,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param fromChatId
	 * @param messageId
	 * @return
	 */
	public static TelegramRequest createForwardMessageRequest(final int chatId,final int fromChatId,final int messageId){
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("from_chat_id",String.valueOf(fromChatId)));
		basicNameValuePair.add(new BasicNameValuePair("message_id",String.valueOf(messageId)));
		return new TelegramRequest(RequestType.FORWARD_MESSAGE,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param inputFile
	 * @param caption
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendPhotoRequest(final int chatId,final File inputFile, final String caption, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		TelegramRequestFactory.addIfNotNull("caption",caption,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_PHOTO,basicNameValuePair,inputFile,"photo");
	}
	/**
	 * 
	 * @param chatId
	 * @param photoId
	 * @param caption
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendPhotoRequest(final int chatId,final String photoId, final String caption, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("photo",photoId));
		TelegramRequestFactory.addIfNotNull("caption",caption,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_PHOTO,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param inputFile
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendAudioRequest(final int chatId,final File inputFile, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_AUDIO,basicNameValuePair,inputFile,"audio");
	}
	/**
	 * 
	 * @param chatId
	 * @param audioId
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendAudioRequest(final int chatId,final String audioId, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("audio",audioId));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_AUDIO,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param inputFile
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendDocumentRequest(final int chatId,final File inputFile, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_DOCUMENT,basicNameValuePair,inputFile,"document");
	}
	/**
	 * 
	 * @param chatId
	 * @param documentId
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendDocumentRequest(final int chatId,final String documentId, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("document",documentId));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_DOCUMENT,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param inputFile
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendStickerRequest(final int chatId,final File inputFile, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_STICKER,basicNameValuePair,inputFile,"sticker");
	}
	/**
	 * 
	 * @param chatId
	 * @param stickerId
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendStickerRequest(final int chatId,final String stickerId, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("sticker",stickerId));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_STICKER,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param inputFile
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendVideoRequest(final int chatId,final File inputFile, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_VIDEO,basicNameValuePair,inputFile,"video");
	}
	/**
	 * 
	 * @param chatId
	 * @param videoId
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendVideoRequest(final int chatId,final String videoId, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("video",videoId));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_VIDEO,basicNameValuePair);
	}
	
	/**
	 * 
	 * @param chatId
	 * @param latitude
	 * @param longitude
	 * @param replyToMessageId
	 * @param customReplyKeyboard
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static TelegramRequest createSendLocationRequest(final int chatId,final double latitude,final double longitude, final Long replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("latitude",String.valueOf(latitude)));
		basicNameValuePair.add(new BasicNameValuePair("longitude",String.valueOf(longitude)));
		TelegramRequestFactory.addIfNotNull("reply_to_message_id",replyToMessageId,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("reply_markup",customReplyKeyboard,basicNameValuePair);
		return new TelegramRequest(RequestType.SEND_LOCATION,basicNameValuePair);
	}
	/**
	 * 
	 * @param chatId
	 * @param broadcastActionType
	 * @return
	 */
	public static TelegramRequest createSendChatActionRequest(final int chatId,final BroadcastActionType broadcastActionType){
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("action",broadcastActionType.getActionToBroadcast()));
		return new TelegramRequest(RequestType.SEND_CHAT_ACTION,basicNameValuePair);
	}
	/**
	 * 
	 * @param userId
	 * @param offset
	 * @param limit
	 * @return
	 */
	public static TelegramRequest createGetUserProfilePhotosRequest(final int userId,final Integer offset, final Integer limit){
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("user_id",String.valueOf(userId)));
		TelegramRequestFactory.addIfNotNull("offset",offset,basicNameValuePair);
		TelegramRequestFactory.addIfNotNull("limit",limit,basicNameValuePair);
		return new TelegramRequest(RequestType.GET_USER_PROFILE_PHOTOS,basicNameValuePair);
	}
	/**
	 * 
	 * @param offset
	 * @param limit
	 * @param timeout
	 * @return
	 */
	public static TelegramRequest createGetUpdatesRequest(final Long offset, final Long limit, final Long timeout){
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("offset",String.valueOf(offset)));
		basicNameValuePair.add(new BasicNameValuePair("limit",String.valueOf(limit)));
		basicNameValuePair.add(new BasicNameValuePair("timeout",String.valueOf(timeout)));
		return new TelegramRequest(RequestType.GET_UPDATES,basicNameValuePair);
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static TelegramRequest createSetWebhookRequest(final String url){
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("url",String.valueOf(url)));
		return new TelegramRequest(RequestType.SET_WEBHOOK,basicNameValuePair);
	}
	
	private static void addIfNotNull(final String name, final String value, List <BasicNameValuePair>basicNameValuePair){
		if(value!=null){
			basicNameValuePair.add(new BasicNameValuePair(name,value));
		}
	}
	private static void addIfNotNull(final String name, final Integer value, List <BasicNameValuePair>basicNameValuePair){
		if(value!=null){
			basicNameValuePair.add(new BasicNameValuePair(name,value.toString()));
		}
	}
	
	private static void addIfNotNull(final String name, final Long value, List <BasicNameValuePair>basicNameValuePair){
		if(value!=null){
			basicNameValuePair.add(new BasicNameValuePair(name,value.toString()));
		}
	}
	
	private static void addIfNotNull(final String name, final CustomReplyKeyboard customReplyKeyboard, List <BasicNameValuePair>basicNameValuePair) throws JsonGenerationException, JsonMappingException, IOException{
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair(name,jsonString));
		}
	}
}
