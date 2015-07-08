/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixtabyte.telegram.jtelebot.server;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.nixabyte.telegram.jtelebot.client.RequestHandler;
import com.nixabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import com.nixabyte.telegram.jtelebot.response.json.Message;
import com.nixabyte.telegram.jtelebot.server.impl.AbstractCommand;

public class DummyCommandImpl extends AbstractCommand{

	public DummyCommandImpl(Message message, RequestHandler requestHandler) {
		super(message, requestHandler);
	}

	@Override
	public void execute() {
		System.out.println("\t*** Executing CustomCommandImpl");
		try {
			requestHandler.sendRequest(TelegramRequestFactory
					.createSendMessageRequest(message.getChat().getId(),
							"Command response: " + message.getText(), false,
							message.getId(), null));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
