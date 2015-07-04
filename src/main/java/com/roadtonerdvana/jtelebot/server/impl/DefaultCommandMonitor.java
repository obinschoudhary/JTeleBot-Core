package com.roadtonerdvana.jtelebot.server.impl;



import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.impl.DefaultBotRequestHandler;
import com.roadtonerdvana.jtelebot.request.factory.TelegramRequestFactory;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.server.Service;

@Deprecated
public class DefaultCommandMonitor implements Service, Runnable {

	private static final long SLEEP_TIME = 5000;

	private Thread thread;

	private BotRequestHandler handler;

	private boolean alive;

	public DefaultCommandMonitor(final String token) {
		System.out.println(">>>> CommandMonitor has been instantiated <<<<");
		thread = new Thread(this);
		handler = new DefaultBotRequestHandler(token);
	}

	@Override
	public void startUp() {
		System.out.println("** CommandMonitor Started...");
		alive = true;
		if (thread == null || !thread.isAlive()) {
			thread = new Thread(this);
		}
		thread.run();
	}

	@Override
	public void shutdown() {
		System.out.println("** Stopping CommandMonitor...");
		alive = false;
		if (thread != null && thread.isAlive()) {
			thread.interrupt();
		}
	}

	@Override
	public boolean isAlive() {
		if (thread == null || !thread.isAlive()) {
			return false;
		}

		return thread.isAlive();
	}

	@Override
	public void run() {
		while (alive) {
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// Don't know what to do here...
				e.printStackTrace();
			}

			System.out.println("\t..Resuming CommandMonitor");
			TelegramResponse<?> response = handler.sendRequest(TelegramRequestFactory.createGetUpdatesRequest(0, 100, 0));

			handleUpdates(response);

		}
	}

	private void handleUpdates(final TelegramResponse<?> response) {
		if (response.isSuccessful()) {
			for (final Object updateObj : response.getResult()) {
				final Update update = (Update) updateObj;
				System.out.println("UpdateId:" + update.getUpdateId()
						+ " - MessageID:" + update.getMessage().getId() + " - "
						+ update.getMessage().getFromUser().getId() + ":"
						+ update.getMessage().getFromUser().getUsername());
				System.out.println(update.getMessage());

			}

			System.out
					.println("\t"
							+ response.getResult().size()
							+ " updates fetched ...update counter to fetch next slot of updates...");
		}
	}


	public BotRequestHandler getHandler() {
		return handler;
	}

	public void setHandler(BotRequestHandler handler) {
		this.handler = handler;
	}

}
