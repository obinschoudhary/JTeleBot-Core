package com.roadtonerdvana.jtelebot.server;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.roadtonerdvana.jtelebot.client.RequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.server.impl.AbstractCommand;

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
