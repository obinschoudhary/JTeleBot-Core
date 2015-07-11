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
import io.github.nixtabyte.telegram.jtelebot.server.CommandDispatcher;
import io.github.nixtabyte.telegram.jtelebot.server.CommandQueue;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

/**
 * Main implementation of {@link CommandDispatcher} that extends the
 * {@link AbstractCommandDispatcher} behavior in order to handle a sort of
 * {@link DefaultCommandTask} instances as part of a ThreadPoolExecutor.
 * </br></br>The DefaultCommandDispatcher registers itself as an
 * {@link Observer} on every {@link Observable} DefaultCommandTask instantiated
 * in such a way to be notified when each of them had finished processing their
 * corresponding {@link Command}.
 * 
 * @see Command
 * @see CommandDispatcher
 * @see AbstractCommandDispatcher
 * @see DefaultCommandTask
 * @see Observer
 * @see Observable
 * @since 0.0.1
 * */
public class DefaultCommandDispatcher extends AbstractCommandDispatcher {

	private ConcurrentMap<String, DefaultCommandTask> taskList;

	private static final Logger LOG = Logger
			.getLogger(DefaultCommandDispatcher.class);

	public DefaultCommandDispatcher() {
		this(5, 1000, new DefaultCommandQueue());
	}

	public DefaultCommandDispatcher(final CommandQueue commandQueue) {
		this(5, 1000, 1000, commandQueue);
	}

	public DefaultCommandDispatcher(final int threadPoolSize, final long delay,
			final CommandQueue commandQueue) {
		this(threadPoolSize, 1000, delay, commandQueue);
	}

	public DefaultCommandDispatcher(final int threadPoolSize,
			final long taskListCapacity, final long delay,
			final CommandQueue commandQueue) {

		super(threadPoolSize, delay, commandQueue);
		taskList = new ConcurrentLinkedHashMap.Builder<String, DefaultCommandTask>()
				.maximumWeightedCapacity(taskListCapacity).build();
	}

	@Override
	public void dispatchCommands() {
		// LOG.debug("CommandQueue: " + commandQueue.toString());
		while (!commandQueue.isEmpty()) {
			LOG.trace("About to dispatch " + commandQueue.size()
					+ " commands enqueued...");
				final DefaultCommandTask task = new DefaultCommandTask(
					commandQueue.poll(), delay);
			task.addObserver(this);
			taskList.put(String.valueOf(task.getCommand().hashCode()), task);
			// LOG.debug(taskList.keySet());

			executor.execute(task);
		}
	}

	@Override
	public void update(final Observable observableTask, final Object arg) {
		final DefaultCommandTask task = (DefaultCommandTask) observableTask;
		final String observableKey = String.valueOf(task.getCommand()
				.hashCode());
		if (taskList.containsKey(observableKey)) {
			taskList.remove(observableKey);
			LOG.debug("Pending tasks: " + taskList.size() + "...");
		} else {
			LOG.error("Could not find {Task:" + observableKey + "} in taskList");
		}
	}
}
