package com.roadtonerdvana.jtelebot.server;

import com.roadtonerdvana.jtelebot.client.RequestHandler;
import com.roadtonerdvana.jtelebot.response.json.Message;

public class DummyCommandFactoryImpl implements CommandFactory{

	@Override
	public Command createCommand(Message message, RequestHandler requestHandler) {
		return new DummyCommandImpl(message,requestHandler);
	}

}
