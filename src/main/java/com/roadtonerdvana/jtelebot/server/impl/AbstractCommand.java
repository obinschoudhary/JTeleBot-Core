package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.server.Command;

public abstract class AbstractCommand implements Command {

	protected Message message;
	protected BotRequestHandler requestHandler;

	public AbstractCommand(final Message message,
			final BotRequestHandler requestHandler) {
		this.message = message;
		this.requestHandler = requestHandler;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public BotRequestHandler getRequestHandler() {
		return requestHandler;
	}

	public void setRequestHandler(BotRequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	@Override
	public abstract void execute();

}
