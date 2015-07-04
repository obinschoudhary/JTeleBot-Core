package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.server.Command;
import com.roadtonerdvana.jtelebot.server.CommandHandler;

public class DefaultCommandHandler implements CommandHandler, Runnable {

	private Command command;
	private long delay;

	public DefaultCommandHandler(final Command command, final long delayInMillis) {
		this.command = command;
		this.delay = delayInMillis;
	}

	@Override
	public void run() {
		System.out.println("Start executing command {" + command + "}");
		processCommand();
		System.out.println("End executing command {" + command + "}");
	}

	@Override
	public void processCommand() {
		try {
			Thread.sleep(delay);
			command.execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "[" + command + ", " + delay + " ms]";
	}

}
