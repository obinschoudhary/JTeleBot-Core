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
import io.github.nixtabyte.telegram.jtelebot.server.CommandTask;

import java.util.Observable;

import org.apache.log4j.Logger;

/**
 * Abstract component that extends {@link Observable} and implements
 * {@link CommandTask} and {@link Runnable} in order to handle the execution of
 * every individual {@link Command} into a separated runnable
 * thread.</br></br>It allows to notify all Observer classes when it has
 * finished processing the corresponding Command.
 * 
 * @see Command
 * @see CommandTask
 * @see Observable
 * @see Runnable
 * @since 0.0.1
 * */
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

	@Override
	public abstract void processCommand();

	/**
	 * Method used to notify all the hooked {@link Observer} clients when this
	 * Observable object had finished processing the Command.
	 * */
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
