package com.roadtonerdvana.jtelebot.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandDispatcher;
import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandQueue;
import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandWatcher;

public class WatcherTest {

	// PUT YOUR TEST TOKEN HERE...
	private static final String TEST_TOKEN = "";

	// Polling Telegram Updates (Watcher)
	private static final long POLLING_DELAY = 10000;
	private static final int CACHE_CAPACITY = 1000;

	private static final int DEFAULT_INITIAL_OFFSET = 0;
	private static final int DEFAULT_UPDATES_LIMIT = 100;
	private static final int DEFAULT_TIMEOUT = 0;

	// Thread-Pool Executor (Dispatcher)
	private static final int THREAD_POOL_SIZE = 1;
	private static final long CMD_EXEC_DELAY = 0;

	private static final long OVERALL_TEST_DURATION = 120000;

	private DefaultCommandWatcher commandWatcher;
	private DefaultCommandDispatcher commandDispatcher;

	@Before
	public void setUp() {
		// Init first the Dispatcher...
		DefaultCommandQueue defaultCommandQueue = new  DefaultCommandQueue();
		commandDispatcher = new DefaultCommandDispatcher(THREAD_POOL_SIZE,
				CMD_EXEC_DELAY, defaultCommandQueue);
		commandDispatcher.startUp();

		// Init the Watcher and bypass a reference to Dispatcher
		commandWatcher = new DefaultCommandWatcher(POLLING_DELAY,
				CACHE_CAPACITY, TEST_TOKEN, commandDispatcher,DummyCommandC.class);
		commandWatcher.setOffset(DEFAULT_INITIAL_OFFSET);
		commandWatcher.setLimit(DEFAULT_UPDATES_LIMIT);
		commandWatcher.setTimeout(DEFAULT_TIMEOUT);
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(OVERALL_TEST_DURATION);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commandWatcher.shutdown();
		commandDispatcher.shutdown();
	}

	@Test
	public void testStartAndStop() {
		// LOG.debug("Testing watcher..");
		commandWatcher.startUp();
	}

}
