package com.roadtonerdvana.jtelebot.server;

public interface CommandDispatcher {

	public void enqueueCommand(Command command);

	public void dispatchCommands();
}
