/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixabyte.telegram.jtelebot.client;



import com.nixabyte.telegram.jtelebot.request.TelegramRequest;
import com.nixabyte.telegram.jtelebot.response.json.TelegramResponse;
public interface RequestHandler {
	
	public TelegramResponse<?> sendRequest(final TelegramRequest telegramRequest);

}
