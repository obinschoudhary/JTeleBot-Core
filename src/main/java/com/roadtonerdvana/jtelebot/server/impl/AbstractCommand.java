package com.roadtonerdvana.jtelebot.server.impl;

import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.server.Command;

public abstract class AbstractCommand implements Command {

	private Update update;

	public AbstractCommand(final Update update) {
		this.update = update;
	}

	@Override
	public void execute() {
		if (update != null) {

		}
	}

}
