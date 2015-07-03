package com.roadtonerdvana.jtelebot.motor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.RequestType;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.ReplyKeyboardHide;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;

public class RequestHandlerTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "toke here plizz";
	
	private BotRequestHandler handler;
	
	@Before
	public void setUp() {
		handler = new DefaultBotRequestHandler(TEST_TOKEN);   
	}///Users/buzz/Documents/testImg.jpg
	
	@Test
	public void testGetMeService() {
		System.out.println("********[ testGetMeService ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createGetMeRequest());
		System.out.println(jsonResponse);
	}
	@Test
	public void testSendPhoto() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendPhoto ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendPhotoRequest(-7155093, new File("/Users/buzz/Documents/testImg.jpg"), null, null, null));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testSendAudio() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendAudio ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendAudioRequest(-7155093, new File("/Users/buzz/Documents/testAudio.m4a"), null, null));
		System.out.println(jsonResponse);
	}
	
	
	@Test
	public void testSendMessageService() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendMessageService ]********");
		/*
		ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
		keyboard.setKeyboard(new String[][] { { "yes", "double yes" },
				{ "no" }, { "robert" } });
		keyboard.setOneTimeKeyboard(true);
		keyboard.setResizeKeyboard(false);
		keyboard.setSelective(false);
		*/
		ReplyKeyboardHide keyboard = new ReplyKeyboardHide();
		keyboard.setHideKeyboard(true);
		keyboard.setSelective(false);
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendMessageRequest(-7155093, "hi you", true, null, keyboard));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testGetUpdatesService() {
		System.out.println("********[ testGetUpdatesService ]********");
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("offset", "0"));
		parameters.add(new BasicNameValuePair("limit", "100"));
		parameters.add(new BasicNameValuePair("timeout", "0"));
		
		final TelegramResponse<?> jsonResponse = handler.sendRequest(RequestType.GET_UPDATES, parameters);
		System.out.println(jsonResponse);

	}
	
	@Test
	public void testSendChatAction() {
		System.out.println("********[ testSendChatAction ]********");
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("chat_id", "-7155093"));
		parameters.add(new BasicNameValuePair("action", "upload_document"));
		
		final TelegramResponse<?> jsonResponse = handler.sendRequest(RequestType.SEND_CHAT_ACTION, parameters);
		System.out.println(jsonResponse);
		System.out.println(jsonResponse.getResult().get(0).getClass());

	}
	
}
