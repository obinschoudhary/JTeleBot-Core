/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server;

/**
 * This interface represents a class that will act as a server, allowing it to
 * be started or shut down.
 * 
 * @since 0.0.1
 * */
public interface Service {

	/**
	 * This method starts up the service
	 * */
	public void startUp();

	/**
	 * This method shuts down the service
	 * */
	public void shutdown();

	/**
	 * This method indicates whether the service is up and running or down.
	 * 
	 * @return boolean <b>true</b> if service is stil running. <b>false</b> if
	 *         service is halted.
	 * */
	public boolean isAlive();
}
