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

	private DefaultCommandDispatcher dispatcher;

	@Before
	public void setup() {
		dispatcher = new DefaultCommandDispatcher(3, 5000,
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

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// Just waiting for a while
		}

		dispatcher.shutdown();
		Assert.assertFalse(dispatcher.isAlive());

	}
}
