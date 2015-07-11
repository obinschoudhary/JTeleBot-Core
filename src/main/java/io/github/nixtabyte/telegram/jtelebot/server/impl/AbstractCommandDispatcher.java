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
import io.github.nixtabyte.telegram.jtelebot.server.Service;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

/**
 * Abstract implementation of {@link CommandDispatcher}, {@link Observer},
 * {@link Service} and {@link Runnable} which uses a runnable thread with a
 * service pattern behavior (start|stop) in order to enqueue {@link Command}
 * objects and then execute them one by one. </br></br>It also implements an
 * Observer pattern behavior in order to be able to "observe" or be aware when
 * an observable object changes its current state. In a common Observer
 * scenario, the observable object would send a notification to every Observer
 * class hooked and this way the Observer would be able to perform a particular
 * action after the signal.
 * 
 * @see Command
 * @see CommandDispatcher
 * @see Observer
 * @see Service
 * @see Runnable
 * @since 0.0.1
 * */
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
				LOG.error(e);
			}
			try{
				dispatchCommands();
			}
			catch(Exception e){
				LOG.error(e);
			}
		}

		thread = null;
	}

	@Override
	public void enqueueCommand(final Command command) {
		commandQueue.add(command);
	}

	@Override
	public abstract void dispatchCommands();

	/**
	 * Method used by the Observable object in order to notify this Observer
	 * class about any particular change event on the Observable side.
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
