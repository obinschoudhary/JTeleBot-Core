/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixabyte.telegram.jtelebot.server;

public interface Service {

	public void startUp();

	public void shutdown();

	public boolean isAlive();
}
