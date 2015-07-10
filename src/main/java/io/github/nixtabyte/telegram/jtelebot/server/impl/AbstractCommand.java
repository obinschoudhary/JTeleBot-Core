/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server.impl;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.Command;

/**
 * Abstract implementation of {@link Command} in order to contain a
 * {@link Message} and {@link RequestHandler} for further manipulation of the
 * Bot.
 * 
 * @see Command
 * @see Message
 * @see RequestHandler
 * @since 0.0.1
 * */
public abstract class AbstractCommand implements Command {

	protected Message message;
	protected RequestHandler requestHandler;

	public AbstractCommand(final Message message,
			final RequestHandler requestHandler) {
		this.message = message;
		this.requestHandler = requestHandler;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public RequestHandler getRequestHandler() {
		return requestHandler;
	}

	public void setRequestHandler(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	@Override
	public abstract void execute();

}
