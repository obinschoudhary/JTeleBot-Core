package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.server.CommandDispatcher;

public class DefaultCommandWatcher extends AbstractCommandWatcher {

	private CommandDispatcher commandDispatcher;
	private BotRequestHandler requestHandler;

	private int offset;
	private int limit;
	private int timeout;

	public DefaultCommandWatcher() {
		this(0, null);
	}

	public DefaultCommandWatcher(final long delayInMillis,
			final String telegramToken) {
		super(delayInMillis);
		this.requestHandler = new DefaultBotRequestHandler(telegramToken);

		// TODO These parameters must be persistent (i.e. cache, DB, file, etc.)
		this.offset = 0;
		this.limit = 100;
		this.timeout = 0;
	}

	@Override
	public void retrieveCommands() {
		TelegramResponse<?> response = requestHandler
				.sendRequest(TelegramRequestFactory.createGetUpdatesRequest(
						offset, limit, timeout));
		handleUpdates(response);
	}

	private void handleUpdates(final TelegramResponse<?> response) {
		if (response.isSuccessful()) {
			for (final Object updateObj : response.getResult()) {
				final Update update = (Update) updateObj;
				System.out.println("UpdateId:" + update.getUpdateId()
						+ " - MessageID:" + update.getMessage().getId() + " - "
						+ update.getMessage().getFromUser().getId() + ":"
						+ update.getMessage().getFromUser().getUsername());
				System.out.println(update.getMessage().getChat());

				// TODO Assert that UpdateId has not been dispatched before (check in cache or history)..
				
				// TODO Instantiate a Command, insert the Update object, enqueue
				// the Command via Dispatcher
			}

			System.out.println("\t" + response.getResult().size()
					+ " updates fetched ...");
		}
	}

	public CommandDispatcher getCommandDispatcher() {
		return commandDispatcher;
	}

	public void setCommandDispatcher(CommandDispatcher commandDispatcher) {
		this.commandDispatcher = commandDispatcher;
	}

	public BotRequestHandler getRequestHandler() {
		return requestHandler;
	}

	public void setRequestHandler(BotRequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

}
