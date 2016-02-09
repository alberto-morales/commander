package com.hpe.commander.model;

public interface Startable {

	/**
	 * Starts the server
	 * @return resultado de la operacion	 *
	 */
	public String start();

	/**
	 * Stops the server
	 * @return resultado de la operacion
	 */
	public String stop();
}
