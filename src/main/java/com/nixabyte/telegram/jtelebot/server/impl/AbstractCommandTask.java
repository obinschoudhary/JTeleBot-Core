/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixabyte.telegram.jtelebot.server.impl;

import java.util.Observable;

import org.apache.log4j.Logger;

import com.nixabyte.telegram.jtelebot.server.Command;
import com.nixabyte.telegram.jtelebot.server.CommandTask;

public abstract class AbstractCommandTask extends Observable implements
		CommandTask, Runnable {

	private static final Logger LOG = Logger
			.getLogger(AbstractCommandTask.class);

	protected Command command;
	protected long delay;

	public AbstractCommandTask(final Command command) {
		this(command, 0);
	}

	public AbstractCommandTask(final Command command, final long delayInMillis) {
		this.command = command;
		this.delay = delayInMillis;
	}

	@Override
	public void run() {
		processCommand();
		notifyObserver();
	}

	/**
	 * This method must be overridden in order to implement the business logic
	 * while processing the command.
	 * */
	@Override
	public abstract void processCommand();

	public abstract void notifyObserver();

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "[" + command + ", delay: " + delay + " ms]";
	}

}
