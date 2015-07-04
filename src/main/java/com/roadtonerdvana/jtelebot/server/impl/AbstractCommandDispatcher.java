package com.roadtonerdvana.jtelebot.server.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.roadtonerdvana.jtelebot.server.Command;
import com.roadtonerdvana.jtelebot.server.CommandQueue;
import com.roadtonerdvana.jtelebot.server.Service;

public abstract class AbstractCommandDispatcher implements Service, Runnable {

	protected ExecutorService executor;
	protected CommandQueue commandQueue;

	protected boolean alive;
	protected int threadPoolSize;
	protected long delay;

	private Thread thread;

	public AbstractCommandDispatcher() {
		this(5, 0, new DefaultCommandQueue());
	}

	public AbstractCommandDispatcher(final int threadPoolSize,
			final long delay, final CommandQueue commandQueue) {
		this.threadPoolSize = threadPoolSize;
		this.delay = delay;
		this.commandQueue = commandQueue;
	}

	@Override
	public void startUp() {
		System.out.println("** Starting up command dispatcher...");
		alive = true;
		executor = Executors.newFixedThreadPool(threadPoolSize);
		if (thread == null) {
			thread = new Thread(this);
		}
		if (!thread.isAlive()) {
			thread.start();
		}
	}

	@Override
	public void shutdown() {
		System.out.println("** Shutting down command dispatcher...");
		alive = false;
		executor.shutdown();
	}

	@Override
	public boolean isAlive() {
		System.out.println("Command dispatcher " + (alive ? "is" : "is not")
				+ " alive...");
		return alive;
	}

	@Override
	public void run() {
		while (alive) {
			dispatchCommands();
		}
	}

	public void enqueueCommand(final Command command) {
		commandQueue.add(command);
	}

	/**
	 * This method must to be overridden in order to implement the business
	 * logic to dispatch every Command from the Queue
	 * */
	public abstract void dispatchCommands();

	public CommandQueue getCommandQueue() {
		return commandQueue;
	}

	public void setCommandQueue(final CommandQueue commandQueue) {
		this.commandQueue = commandQueue;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(final long delay) {
		this.delay = delay;
	}
}
