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
 * This interface represents a generic Telegram Bot command triggered by a
 * User, and can be executed in order to make the Bot to perform a particular
 * action.
 * 
 * @since 0.0.1
 * */
public interface Command {

	/**
	 * Method to execute the main business logic associated to this command.
	 * */
	public void execute();

}
