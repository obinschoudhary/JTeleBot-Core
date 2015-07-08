/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.jtelebot.server.impl;

import io.github.nixtabyte.jtelebot.server.CommandWatcher;
import io.github.nixtabyte.jtelebot.server.Service;

import org.apache.log4j.Logger;

public abstract class AbstractCommandWatcher implements CommandWatcher,
		Service, Runnable {

	private static final Logger LOG = Logger
			.getLogger(AbstractCommandWatcher.class);

	protected boolean alive;
	protected long delay;

	private Thread thread;

	public AbstractCommandWatcher() {
		this(0);
	}

	public AbstractCommandWatcher(final long delayInMillis) {
		this.delay = delayInMillis;
	}

	@Override
	public void startUp() {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		LOG.info(">> Starting up command watcher...");
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		alive = true;

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void shutdown() {
		LOG.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		LOG.info("<< Shutting down command watcher...");
		LOG.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		alive = false;
	}

	@Override
	public boolean isAlive() {
		LOG.debug("Command watcher " + (alive ? "is" : "is not") + " alive...");
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
			retrieveCommands();
		}

		thread = null;
	}

	@Override
	public abstract void retrieveCommands();

}
