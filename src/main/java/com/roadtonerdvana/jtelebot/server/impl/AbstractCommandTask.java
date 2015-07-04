package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.server.Command;
import com.roadtonerdvana.jtelebot.server.CommandTask;

public abstract class AbstractCommandTask implements CommandTask, Runnable {

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
	}

	/**
	 * This method must be overridden in order to implement the business logic
	 * while processing the command.
	 * */
	@Override
	public abstract void processCommand();

	@Override
	public String toString() {
		return "[" + command + ", delay: " + delay + " ms]";
	}

}
