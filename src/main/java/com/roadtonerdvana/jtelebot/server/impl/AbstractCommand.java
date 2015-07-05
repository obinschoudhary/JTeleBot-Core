package com.roadtonerdvana.jtelebot.server.impl;

import org.apache.log4j.Logger;

import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.server.Command;

public abstract class AbstractCommand implements Command {

	private static final Logger LOG = Logger.getLogger(AbstractCommand.class);

	protected Message message;

	public AbstractCommand(final Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public abstract void execute();

}
