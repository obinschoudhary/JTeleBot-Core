/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;

/**
 * This interface represents the centralized Factory class that would serve to
 * create new {@link Command} instances when needed.
 * 
 * @see Command
 * @since 0.0.1
 * */
public interface CommandFactory {

	/**
	 * Method that creates a new Command instance.
	 * 
	 * @param message
	 *            Is the message polled from Telegram Bot API service which has
	 *            been already translated from JSON to POJO. It could be used
	 *            internally by the {@link Command} implementation.
	 * @param requestHandler
	 *            Is the component used for sending further HTTP requests to the
	 *            Telegram Bot API service.
	 * @return The new {@link Command} instance containing the Message and
	 *         RequestHandler reference inside.
	 * */
	public Command createCommand(Message message, RequestHandler requestHandler);
}
