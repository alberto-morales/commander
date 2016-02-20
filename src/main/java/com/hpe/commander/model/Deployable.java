package com.hpe.commander.model;

public interface Deployable {

	/**
	 * Deploy app to the server instance
	 * @return operation result
	 */
	public String deploy();

}
