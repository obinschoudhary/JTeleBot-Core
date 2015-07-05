package com.roadtonerdvana.jtelebot.server;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.Message;

public class DummyCommandC implements Command{

	private Message message;
	private BotRequestHandler botRequestHandler;
	
	public DummyCommandC(final Message message, final BotRequestHandler botRequestHandler){
		this.message = message;
		this.botRequestHandler = botRequestHandler;
	}	
	
	@Override
	public void execute() {
		try {
			botRequestHandler.sendRequest(TelegramRequestFactory.createSendMessageRequest(message.getChat().getId(), message.getText(), false, message.getId(), null));
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
