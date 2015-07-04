package com.roadtonerdvana.jtelebot.client;

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
import com.roadtonerdvana.jtelebot.client.BroadcastActionType;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.ReplyKeyboardHide;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;

public class RequestHandlerTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "put token here";
	
	private BotRequestHandler handler;
	
	@Before
	public void setUp() {
		handler = new DefaultBotRequestHandler(TEST_TOKEN);   
	}
	
	@Test
	public void testGetMeService() {
		System.out.println("********[ testGetMeService ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createGetMeRequest());
		System.out.println(jsonResponse);
	}
	

	
	@Test
	public void testSendPhoto() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendPhoto ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendPhotoRequest(-7155093, new File("/path/to/testImg.jpg"), null, null, null));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testSendVideo() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendVideo ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendVideoRequest(-7155093, new File("/path/to/testVideo.mp4"), null, null));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testSendSticker() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendSticker ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendStickerRequest(-7155093, new File("/path/to/testSticker.webp"), null, null));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testSendDocument() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendDocument ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendDocumentRequest(-7155093, new File("/path/to/testDocument.ppt"), null, null));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testSendLocation() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendLocation ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendLocationRequest(-7155093, 53.478542, -2.248833, null, null));
		System.out.println(jsonResponse);
	}
	
	@Test
	public void testSendAudio() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("********[ testSendAudio ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendAudioRequest(-7155093, new File("/path/to/testAudio.m4a"), null, null));
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
		
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createGetUpdatesRequest(0, 100, 0));
		System.out.println(jsonResponse);

	}
	
	@Test
	public void testSendChatAction() {
		System.out.println("********[ testSendChatAction ]********");
		
		final TelegramResponse<?> jsonResponse = handler.sendRequest(TelegramRequestFactory.createSendChatActionRequest(-7155093, BroadcastActionType.FIND_LOCATION));
		System.out.println(jsonResponse);
		System.out.println(jsonResponse.getResult().get(0).getClass());

	}
	
}
