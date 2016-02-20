package com.hpe.commander.model;

public interface Startable {

	/**
	 * Starts the server
	 * @return operation result
	 */
	public String start();

	/**
	 * Stops the server
	 * @return operation result
	 */
	public String stop();
}
