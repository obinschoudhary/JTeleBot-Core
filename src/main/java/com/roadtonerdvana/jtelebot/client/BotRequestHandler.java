package com.roadtonerdvana.jtelebot.client;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;

public interface BotRequestHandler {

	public String sendRequest(RequestType requestType, List<BasicNameValuePair> parameters);

}
