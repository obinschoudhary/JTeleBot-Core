package com.roadtonerdvana.jtelebot.client;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;

public interface BotRequestHandler {

	public TelegramResponse<?> sendRequest(RequestType requestType, List<BasicNameValuePair> parameters);

}
