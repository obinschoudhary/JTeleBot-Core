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

	private long offset;
	private long limit;
	private long timeout;

	private ConcurrentMap<String, Message> cache;

	public DefaultCommandWatcher() {
		this(0, MAX_CACHE_CAPACITY, null, null);
	}

	public DefaultCommandWatcher(final long delayInMillis,
			final long cacheCapacity, final String telegramToken,
			CommandDispatcher commandDispatcher) {
		super(delayInMillis);
		this.commandDispatcher = commandDispatcher;
		this.requestHandler = new DefaultBotRequestHandler(telegramToken);

		// TODO These parameters must be persisted (i.e. DB,
		// configuration file, etc.), and the offset must be incremented as per
		// new updates received
		this.offset = 0;
		this.limit = 100;
		this.timeout = 0;

		cache = new ConcurrentLinkedHashMap.Builder<String, Message>()
				.maximumWeightedCapacity(cacheCapacity).build();
	}

	@Override
	public void retrieveCommands() {
		LOG.debug("\tPolling Telegram updates (offset:" + offset + ", limit:"
				+ limit + ", timeout=" + timeout + ")...");
		TelegramResponse<?> response = requestHandler
				.sendRequest(TelegramRequestFactory.createGetUpdatesRequest(offset, limit, timeout));
		if (response.isSuccessful()) {
			handleUpdates(response);
		} else {
			// TODO decide what to do in case of unsuccessful response
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
				
				// Update offset in order to fetch a new slot the next time
				offset = update.getUpdateId().longValue() + 1L;
			}
		}

		LOG.info("\tFound " + response.getResult().size() + " updates, "
				+ newUpdatesCounter
				+ " new updates added - History cache size: " + cache.size());
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

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

}
