package com.roadtonerdvana.jtelebot.client;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.request.TelegramRequest;
public interface BotRequestHandler {

	public TelegramResponse<?> sendRequest(RequestType requestType, List<BasicNameValuePair> parameters);

	
	public TelegramResponse<?> sendRequest(final TelegramRequest telegramRequest);

}
