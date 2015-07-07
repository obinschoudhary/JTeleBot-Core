/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.roadtonerdvana.jtelebot.server.impl;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.roadtonerdvana.jtelebot.server.Command;
import com.roadtonerdvana.jtelebot.server.CommandDispatcher;
import com.roadtonerdvana.jtelebot.server.CommandQueue;
import com.roadtonerdvana.jtelebot.server.Service;

public abstract class AbstractCommandDispatcher implements CommandDispatcher,
		Observer, Service, Runnable {

	private static final Logger LOG = Logger
			.getLogger(AbstractCommandDispatcher.class);

	protected ExecutorService executor;
	protected CommandQueue commandQueue;

	protected boolean alive;
	protected int threadPoolSize;
	protected long delay;

	private Thread thread;

	public AbstractCommandDispatcher() {
		this(5, 1000, new DefaultCommandQueue());
	}

	public AbstractCommandDispatcher(final int threadPoolSize,
			final long delay, final CommandQueue commandQueue) {
		this.threadPoolSize = threadPoolSize;
		this.delay = delay;
		this.commandQueue = commandQueue;
	}

	@Override
	public void startUp() {
		LOG.info("*************************************");
		LOG.info("** Starting up command dispatcher...");
		LOG.info("*************************************");
		alive = true;
		executor = Executors.newFixedThreadPool(threadPoolSize);

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void shutdown() {
		LOG.info("***************************************");
		LOG.info("** Shutting down command dispatcher...");
		LOG.info("***************************************");
		alive = false;
		executor.shutdown();
	}

	@Override
	public boolean isAlive() {
		LOG.debug("Command dispatcher " + (alive ? "is" : "is not")
				+ " alive...");
		return alive;
	}

	@Override
	public void run() {
		while (alive) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dispatchCommands();
		}

		thread = null;
	}

	@Override
	public void enqueueCommand(final Command command) {
		commandQueue.add(command);
	}

	/**
	 * This method must to be overridden in order to implement the business
	 * logic to dispatch every Command from the Queue
	 * */
	@Override
	public abstract void dispatchCommands();

	/**
	 * Method used by the Observable object in order to notify this Observer
	 * class about any particular change event in Observable side.
	 * */
	@Override
	public abstract void update(Observable observableTask, Object arg);

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
