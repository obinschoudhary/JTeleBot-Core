/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
import io.github.nixtabyte.telegram.jtelebot.exception.TelegramServerException;
import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommand;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

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
		} catch (JsonParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelegramServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
