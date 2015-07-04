package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.server.Command;

public class DefaultCommandTask extends AbstractCommandTask {

	public DefaultCommandTask(final Command command) {
		super(command);
	}

	public DefaultCommandTask(final Command command, final long delayInMillis) {
		super(command, delayInMillis);
	}

	@Override
	public void processCommand() {
		try {
			System.out.println("Start processing command {" + command + "}");
			Thread.sleep(delay);
			command.execute();
			System.out.println("End processing command {" + command + "}");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
