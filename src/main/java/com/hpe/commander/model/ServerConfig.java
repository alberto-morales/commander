package com.hpe.commander.model;

public interface ServerConfig {

	/**
	 * @return server's ID
	 */
	public abstract String getId();

	/**
	 * @return server's description
	 */
	public abstract String getDescription();

	/**
	 * @return server's address
	 */
	public abstract String getAddress();

	/**
	 * @return server's administrative username
	 */
	public abstract String getUsername();


	/**
	 * @return server's administrative password
	 */
	public abstract String getPassword();

	/**
	 * @return start script (full path)
	 */
	public abstract String getStartScript();

	/**
	 * @return stop script (full path)
	 */
	public abstract String getStopScript();

}
