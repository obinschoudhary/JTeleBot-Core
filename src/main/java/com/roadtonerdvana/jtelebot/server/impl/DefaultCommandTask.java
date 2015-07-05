package com.roadtonerdvana.jtelebot.server.impl;

import org.apache.log4j.Logger;

import com.roadtonerdvana.jtelebot.server.Command;

public class DefaultCommandTask extends AbstractCommandTask {

	private static final Logger LOG = Logger
			.getLogger(DefaultCommandTask.class);

	public DefaultCommandTask(final Command command) {
		super(command);
	}

	public DefaultCommandTask(final Command command, final long delayInMillis) {
		super(command, delayInMillis);
	}

	@Override
	public void processCommand() {
		try {
			LOG.debug("\tSTART processing command {" + command + "}");
			Thread.sleep(delay);
			command.execute();
			LOG.debug("\tEND processing command {" + command + "}");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void notifyObserver() {
		setChanged();
		notifyObservers();
	}

}
