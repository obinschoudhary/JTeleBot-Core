package com.roadtonerdvana.jtelebot.server;

import com.roadtonerdvana.jtelebot.client.RequestHandler;
import com.roadtonerdvana.jtelebot.response.json.Message;

public interface CommandFactory {
	
	
	public Command createCommand(final Message message, final RequestHandler requestHandler);
}
