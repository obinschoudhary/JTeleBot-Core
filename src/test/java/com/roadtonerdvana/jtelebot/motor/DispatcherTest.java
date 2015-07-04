package com.roadtonerdvana.jtelebot.motor;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.server.Command;
import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandDispatcher;
import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandQueue;

public class DispatcherTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "";

	private static final int THREAD_POOL = 3;
	private static final long CMD_EXEC_DELAY = 5000;

	private DefaultCommandDispatcher dispatcher;

	@Before
	public void setup() {
		dispatcher = new DefaultCommandDispatcher(THREAD_POOL, CMD_EXEC_DELAY,
				new DefaultCommandQueue());
	}

	@Test
	public void testStartAndStop() {

		dispatcher.enqueueCommand(new Command() {
			@Override
			public void execute() {
				System.out.println("\tRunning Test Command ");
			}

			@Override
			public String toString() {
				return "<TestCommand>";
			}
		});

		dispatcher.startUp();
		Assert.assertTrue(dispatcher.isAlive());

		pause(10000);

		dispatcher.shutdown();
		Assert.assertFalse(dispatcher.isAlive());

		pause(5000);

		dispatcher.startUp();
		Assert.assertTrue(dispatcher.isAlive());

		pause(10000);

		dispatcher.shutdown();
		Assert.assertFalse(dispatcher.isAlive());

	}

	private void pause(final long delayInMillis) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Just waiting for a while
		}
	}
}
