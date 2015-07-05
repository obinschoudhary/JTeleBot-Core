package com.roadtonerdvana.jtelebot.server.impl;

import org.apache.log4j.Logger;

import com.roadtonerdvana.jtelebot.response.json.Message;

//TODO This class must be implemented in a higher level by the API user. It still needs to be decoupled from business logic.
public class DefaultCommand extends AbstractCommand {

	private static final Logger LOG = Logger.getLogger(DefaultCommand.class);

	public DefaultCommand(Message message) {
		super(message);
	}

	@Override
	public void execute() {
		if (message != null) {
			LOG.debug(message.toString());
		}
	}

	@Override
	public String toString() {
		return "MessageID:" + message.getId();
	}
}
