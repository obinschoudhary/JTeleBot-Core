package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.server.CommandQueue;

public class DefaultCommandDispatcher extends AbstractCommandDispatcher {

	public DefaultCommandDispatcher() {
		super();
	}

	public DefaultCommandDispatcher(final int threadPoolSize, final long delay,
			final CommandQueue commandQueue) {
		super(threadPoolSize, delay, commandQueue);
	}

	@Override
	public void dispatchCommands() {
		try {
			for (int i = 0; i < commandQueue.size(); i++) {
				executor.execute(new DefaultCommandHandler(commandQueue.poll(),
						delay));
			}
		} catch (Exception e) {
			e.printStackTrace();
			executor.shutdown();
		}
	}

}
