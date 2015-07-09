/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server;

import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandDispatcher;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandQueue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DispatcherIntegrationTest {

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
