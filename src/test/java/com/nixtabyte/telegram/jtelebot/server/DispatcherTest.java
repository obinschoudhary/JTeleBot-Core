/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixtabyte.telegram.jtelebot.server;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.nixabyte.telegram.jtelebot.server.Command;
import com.nixabyte.telegram.jtelebot.server.impl.DefaultCommandDispatcher;
import com.nixabyte.telegram.jtelebot.server.impl.DefaultCommandQueue;

public class DispatcherTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "";

	private static final int THREAD_POOL = 3;
	private static final long CMD_EXEC_DELAY = 5000;

	private DefaultCommandDispatcher commandDispatcher;

	@Before
	public void setup() {
		commandDispatcher = new DefaultCommandDispatcher(THREAD_POOL, CMD_EXEC_DELAY,
				new DefaultCommandQueue());
	}

	@Test
	public void testStartAndStop() {

		commandDispatcher.enqueueCommand(new Command() {
			@Override
			public void execute() {
				System.out.println("\tRunning Test Command ");
			}

			@Override
			public String toString() {
				return "<TestCommand>";
			}
		});

		commandDispatcher.startUp();
		Assert.assertTrue(commandDispatcher.isAlive());

		pause(10000);

		commandDispatcher.shutdown();
		Assert.assertFalse(commandDispatcher.isAlive());

		pause(5000);

		commandDispatcher.startUp();
		Assert.assertTrue(commandDispatcher.isAlive());

		pause(10000);

		commandDispatcher.shutdown();
		Assert.assertFalse(commandDispatcher.isAlive());

	}

	private void pause(final long delayInMillis) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Just waiting for a while
		}
	}
}
