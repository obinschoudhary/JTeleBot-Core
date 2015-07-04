package com.roadtonerdvana.jtelebot.server;

public interface Service {

	public void startUp();

	public void shutdown();

	public boolean isAlive();
}
