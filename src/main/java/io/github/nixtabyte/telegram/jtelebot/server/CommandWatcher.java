/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server;

import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.response.json.Update;

/**
 * This interface represents a listener component that sends polling requests to
 * the Telegram Bot API service in order to fetch new {@link Updates} for the
 * corresponding Bot. Every {@link Update} object contains a {@link Message}
 * instance that is encapsulated into a {@link Command} object. </br></br> For
 * this reason the CommandWatcher is responsible for retrieving all available
 * Telegram User commands to manipulate the corresponding Bot.
 * 
 * */
public interface CommandWatcher {

	/**
	 * This method is used to perform the Telegram polling service in order to
	 * retrieve all available commands for the Bot manipulation.
	 * */
	public void retrieveCommands();

}
