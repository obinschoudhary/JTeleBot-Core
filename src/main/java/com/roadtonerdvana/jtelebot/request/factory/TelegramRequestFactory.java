package com.roadtonerdvana.jtelebot.request.factory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.roadtonerdvana.jtelebot.client.BroadcastActionType;
import com.roadtonerdvana.jtelebot.client.RequestType;
import com.roadtonerdvana.jtelebot.mapper.json.MapperHandler;
import com.roadtonerdvana.jtelebot.request.TelegramRequest;
import com.roadtonerdvana.jtelebot.response.json.CustomReplyKeyboard;


public final class TelegramRequestFactory {
	
	/**
	 * TODO:
	 * This factory have an awful lot of repeated code... lets just let it be like this and then return here to make it pretty 
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
	public static TelegramRequest createSendMessageRequest(final int chatId,final String text, final boolean disableWebPagePreview, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();

		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("text",text));
		basicNameValuePair.add(new BasicNameValuePair("disable_web_page_preview",String.valueOf(disableWebPagePreview)));
		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

		
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
	public static TelegramRequest createSendPhotoRequest(final int chatId,final File inputFile, final String caption, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		if(caption!=null){
			basicNameValuePair.add(new BasicNameValuePair("caption",caption));
		}
		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendPhotoRequest(final int chatId,final String photoId, final String caption, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("photo",photoId));

		if(caption!=null){
			basicNameValuePair.add(new BasicNameValuePair("caption",caption));
		}
		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendAudioRequest(final int chatId,final File inputFile, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendAudioRequest(final int chatId,final String audioId, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("audio",audioId));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendDocumentRequest(final int chatId,final File inputFile, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendDocumentRequest(final int chatId,final String documentId, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("document",documentId));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendStickerRequest(final int chatId,final File inputFile, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendStickerRequest(final int chatId,final String stickerId, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("sticker",stickerId));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendVideoRequest(final int chatId,final File inputFile, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendVideoRequest(final int chatId,final String videoId, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("video",videoId));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
	public static TelegramRequest createSendLocationRequest(final int chatId,final double latitude,final double longitude, final Integer replyToMessageId, final CustomReplyKeyboard customReplyKeyboard) throws JsonGenerationException, JsonMappingException, IOException{
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("latitude",String.valueOf(latitude)));
		basicNameValuePair.add(new BasicNameValuePair("longitude",String.valueOf(longitude)));

		if(replyToMessageId!=null){
			basicNameValuePair.add(new BasicNameValuePair("reply_to_message_id",replyToMessageId.toString()));
		}
		if(customReplyKeyboard!=null){
			final String jsonString = MapperHandler.INSTANCE.getObjectMapper().writeValueAsString(customReplyKeyboard);
			basicNameValuePair.add(new BasicNameValuePair("reply_markup",jsonString));
		}

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
		if(offset!=null){
			basicNameValuePair.add(new BasicNameValuePair("offset",offset.toString()));
		}
		if(limit!=null){
			basicNameValuePair.add(new BasicNameValuePair("limit",limit.toString()));
		}
		return new TelegramRequest(RequestType.GET_USER_PROFILE_PHOTOS,basicNameValuePair);
	}
}
