package com.roadtonerdvana.jtelebot.client;



import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.request.TelegramRequest;
public interface BotRequestHandler {
	
	public TelegramResponse<?> sendRequest(final TelegramRequest telegramRequest);

}
