package com.roadtonerdvana.jtelebot.server;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandDispatcher;
import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandQueue;
import com.roadtonerdvana.jtelebot.server.impl.DefaultCommandWatcher;

public class WatcherTest {

	private static final Logger LOG = Logger.getLogger(WatcherTest.class);

	private static final String TEST_TOKEN = "";
	private static final long RETRIEVAL_DELAY = 5000;

	private static final int THREAD_POOL = 3;
	private static final long CMD_EXEC_DELAY = 2000;

	private DefaultCommandWatcher commandWatcher;
	private DefaultCommandDispatcher commandDispatcher;

	@Before
	public void setUp() {
//		BasicConfigurator.configure();
		
		commandDispatcher = new DefaultCommandDispatcher(THREAD_POOL,
				CMD_EXEC_DELAY, new DefaultCommandQueue());
		commandDispatcher.startUp();

		commandWatcher = new DefaultCommandWatcher(RETRIEVAL_DELAY, TEST_TOKEN,
				commandDispatcher);
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commandWatcher.shutdown();
		commandDispatcher.shutdown();
	}

	@Test
	public void testStartAndStop() {
		LOG.debug("Testing watcher..");
		commandWatcher.startUp();
	}

}
