package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.server.CommandWatcher;
import com.roadtonerdvana.jtelebot.server.Service;

public abstract class AbstractCommandWatcher implements CommandWatcher,
		Service, Runnable {

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
		System.out.println("** Starting up command watcher...");
		alive = true;

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void shutdown() {
		System.out.println("** Shutting down command watcher...");
		alive = false;
	}

	@Override
	public boolean isAlive() {
		System.out.println("Command watcher " + (alive ? "is" : "is not")
				+ " alive...");
		return alive;
	}

	@Override
	public void run() {
		while (alive) {
			retrieveCommands();
		}

		thread = null;
	}

	@Override
	public abstract void retrieveCommands();

}
