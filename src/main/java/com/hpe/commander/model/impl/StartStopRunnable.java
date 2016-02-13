package com.hpe.commander.model.impl;

import com.hpe.commander.model.Server;

enum Operation {
    START, STOP
}

public class StartStopRunnable implements Runnable {

	public StartStopRunnable(Server server, Operation operation) {
		super();
		this.server = server;
		this.operation = operation;
	}

	public String getDescription() {
		return server.getDescription();
	}

	public String getResult() {
		return result;
	}

	public boolean isStarted() {
		return started;
	}

	public boolean isFinished() {
		return finished;
	}

	@Override
	public void run() {
		started = true;
		if (operation.equals(Operation.START)) {
			result = server.start();
		} else if (operation.equals(Operation.STOP)) {
			result = server.stop();
		}
		finished = true;
	}

	private final Server server;
	private final Operation operation;
	private String result = "Nothing done!!!";
	private boolean started = false;
	private boolean finished = false;

}
