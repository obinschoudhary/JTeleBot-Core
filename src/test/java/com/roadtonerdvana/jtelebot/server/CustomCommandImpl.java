package com.roadtonerdvana.jtelebot.server;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.server.impl.AbstractCommand;

public class CustomCommandImpl extends AbstractCommand {

	public CustomCommandImpl(final Message message,
			final BotRequestHandler requestHandler) {
		super(message, requestHandler);
	}

	@Override
	public void execute() {
		try {
			System.out.println("\t*** Executing CustomCommandImpl");
			requestHandler.sendRequest(TelegramRequestFactory
					.createSendMessageRequest(message.getChat().getId(),
							"Command response: " + message.getText(), false,
							message.getId(), null));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
