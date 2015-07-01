package com.roadtonerdvana.jtelebot.motor;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.RequestType;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;

public class RequestHandlerTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	private BotRequestHandler handler;
	
	@Before
	public void setUp() {
		handler = new DefaultBotRequestHandler(TEST_TOKEN);
	}
	
	@Test
	public void testGetMeService() {
		System.out.println("********[ testGetMeService ]********");
		final String jsonResponse = handler.sendRequest(RequestType.getMe, new ArrayList<BasicNameValuePair>());
	}
	
	@Test
	public void testGetUpdatesService() {
		System.out.println("********[ testGetUpdatesService ]********");
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("offset", "0"));
		parameters.add(new BasicNameValuePair("limit", "100"));
		parameters.add(new BasicNameValuePair("timeout", "0"));
		
		final String jsonResponse = handler.sendRequest(RequestType.getUpdates, parameters);
	}

}
