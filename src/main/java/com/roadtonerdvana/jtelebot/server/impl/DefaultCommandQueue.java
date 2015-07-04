package com.roadtonerdvana.jtelebot.server.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.roadtonerdvana.jtelebot.server.Command;
import com.roadtonerdvana.jtelebot.server.CommandQueue;

public class DefaultCommandQueue implements CommandQueue {

	private Queue<Command> commandQueue;

	public DefaultCommandQueue() {
		commandQueue = new ConcurrentLinkedQueue<Command>();
	}

	@Override
	public void add(Command command) {
		commandQueue.add(command);
	}

	@Override
	public Command poll() {
		return commandQueue.poll();
	}
	
	@Override
	public boolean isEmpty() {
		return commandQueue.isEmpty();
	}

	@Override
	public int size() {
		return commandQueue.size();
	}

	@Override
	public boolean contains(Command command) {
		return commandQueue.contains(command);
	}

}
