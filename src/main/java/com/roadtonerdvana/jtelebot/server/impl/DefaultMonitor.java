package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.server.Monitor;

public class DefaultMonitor implements Monitor, Runnable {

	private Thread thread;

	private BotRequestHandler handler;
	
	private String token;

	public DefaultMonitor() {
		//TODO It should get the TOKEN from configuration
		token = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
		
		thread = new Thread(this);
		handler = new DefaultBotRequestHandler(token);
	}

	@Override
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
		}
		thread.run();
	}

	@Override
	public void stop() {
		if (thread != null && thread.isAlive()) {
			thread.interrupt();
		}
	}

	@Override
	public void run() {

		//TODO Infinite loop with sleep intervals 
		
	}

}
