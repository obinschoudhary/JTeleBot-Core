/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixtabyte.telegram.jtelebot.server;

import com.nixabyte.telegram.jtelebot.client.RequestHandler;
import com.nixabyte.telegram.jtelebot.response.json.Message;
import com.nixabyte.telegram.jtelebot.server.Command;
import com.nixabyte.telegram.jtelebot.server.CommandFactory;

public class DummyCommandFactoryImpl implements CommandFactory{

	@Override
	public Command createCommand(Message message, RequestHandler requestHandler) {
		return new DummyCommandImpl(message,requestHandler);
	}

}
