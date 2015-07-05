package com.roadtonerdvana.jtelebot.server.impl;

import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.server.CommandDispatcher;

public class DefaultCommandWatcher extends AbstractCommandWatcher {

	private static final Logger LOG = Logger
			.getLogger(DefaultCommandWatcher.class);

	private static final long MAX_CACHE_CAPACITY = 1000;

	private CommandDispatcher commandDispatcher;
	private BotRequestHandler requestHandler;

	private int offset;
	private int limit;
	private int timeout;

	private ConcurrentMap<String, Message> cache;

	public DefaultCommandWatcher() {
		this(0, null, null);
	}

	public DefaultCommandWatcher(final long delayInMillis,
			final String telegramToken, CommandDispatcher commandDispatcher) {
		super(delayInMillis);
		this.commandDispatcher = commandDispatcher;
		this.requestHandler = new DefaultBotRequestHandler(telegramToken);

		// TODO These parameters must be persisted (i.e. DB,
		// configuration file, etc.)
		this.offset = 0;
		this.limit = 100;
		this.timeout = 0;

		cache = new ConcurrentLinkedHashMap.Builder<String, Message>()
				.maximumWeightedCapacity(MAX_CACHE_CAPACITY).build();
	}

	@Override
	public void retrieveCommands() {
		LOG.debug("\tPolling Telegram updates...");
		TelegramResponse<?> response = requestHandler
				.sendRequest(TelegramRequestFactory.createGetUpdatesRequest(
						offset, limit, timeout));
		if (response.isSuccessful()) {
			handleUpdates(response);
		} else {
			// TODO ELSE decide what to do in case of unsuccessful response
			LOG.error("Telegram response was unsuccessful: ["
					+ response.getErrorCode() + "] "
					+ response.getDescription());
		}
	}

	private void handleUpdates(final TelegramResponse<?> response) {
		int newUpdatesCounter = 0;
		for (final Object updateObj : response.getResult()) {
			final Update update = (Update) updateObj;

			LOG.debug("Watching... UpdateId:" + update.getUpdateId()
					+ " - MessageID:" + update.getMessage().getId() + " - "
					+ update.getMessage().getFromUser().getId() + ":"
					+ update.getMessage().getFromUser().getUsername());

			// Assert that UpdateId has not been dispatched before by reviewing
			// in cache..
			// LOG.debug(cache.keySet());
			if (!cache.containsKey(update.getUpdateId().toString())) {
				cache.put(update.getUpdateId().toString(), update.getMessage());
				newUpdatesCounter++;
				// Instantiate a new Command, attach the Message object, enqueue
				// Command via the Dispatcher
				commandDispatcher.enqueueCommand(new DefaultCommand(update
						.getMessage()));
			}
		}
		LOG.info("\tFound " + response.getResult().size() + " updates, "
				+ newUpdatesCounter + " new updates added - History cache size: "
				+ cache.size());
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
