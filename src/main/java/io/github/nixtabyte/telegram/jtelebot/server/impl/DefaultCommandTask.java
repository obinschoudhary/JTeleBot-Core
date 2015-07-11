/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server.impl;

import io.github.nixtabyte.telegram.jtelebot.server.Command;

import org.apache.log4j.Logger;

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
			LOG.trace("\tSTART processing command {" + command + "}");
			Thread.sleep(delay);
			command.execute();
			LOG.trace("\tEND processing command {" + command + "}");
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}

	@Override
	public void notifyObserver() {
		setChanged();
		notifyObservers();
	}

}
