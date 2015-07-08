/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.jtelebot.server;

import io.github.nixtabyte.jtelebot.client.RequestHandler;
import io.github.nixtabyte.jtelebot.response.json.Message;
import io.github.nixtabyte.jtelebot.server.Command;
import io.github.nixtabyte.jtelebot.server.CommandFactory;

public class DummyCommandFactoryImpl implements CommandFactory{

	@Override
	public Command createCommand(Message message, RequestHandler requestHandler) {
		return new DummyCommandImpl(message,requestHandler);
	}

}
