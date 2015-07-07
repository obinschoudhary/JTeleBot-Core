/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.roadtonerdvana.jtelebot.client;



import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.request.TelegramRequest;
public interface RequestHandler {
	
	public TelegramResponse<?> sendRequest(final TelegramRequest telegramRequest);

}
