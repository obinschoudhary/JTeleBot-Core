package com.roadtonerdvana.jtelebot.motor;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.RequestType;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;

public class RequestHandlerTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "";
	
	private BotRequestHandler handler;
	
	@Before
	public void setUp() {
		handler = new DefaultBotRequestHandler(TEST_TOKEN);
	}
	
	@Test
	public void testGetMeService() {
		System.out.println("********[ testGetMeService ]********");
		final TelegramResponse<?> jsonResponse = handler.sendRequest(RequestType.GET_ME, new ArrayList<BasicNameValuePair>());
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
