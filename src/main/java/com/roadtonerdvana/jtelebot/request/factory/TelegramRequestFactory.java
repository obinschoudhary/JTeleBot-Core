package com.roadtonerdvana.jtelebot.request.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.roadtonerdvana.jtelebot.client.RequestType;
import com.roadtonerdvana.jtelebot.mapper.json.MapperHandler;
import com.roadtonerdvana.jtelebot.request.TelegramRequest;
import com.roadtonerdvana.jtelebot.response.json.CustomReplyKeyboard;


public final class TelegramRequestFactory {
	private TelegramRequestFactory(){}
	
	public static TelegramRequest createGetMeRequest(){
		return new TelegramRequest(RequestType.GET_ME,new ArrayList<BasicNameValuePair>());
	}
	
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
	
	public static TelegramRequest createForwardMessageRequest(final int chatId,final int fromChatId,final int messageId){
		List <BasicNameValuePair>basicNameValuePair = new ArrayList<BasicNameValuePair>();
		basicNameValuePair.add(new BasicNameValuePair("chat_id",String.valueOf(chatId)));
		basicNameValuePair.add(new BasicNameValuePair("from_chat_id",String.valueOf(fromChatId)));
		basicNameValuePair.add(new BasicNameValuePair("message_id",String.valueOf(messageId)));
		return new TelegramRequest(RequestType.FORWARD_MESSAGE,basicNameValuePair);

	}
}
