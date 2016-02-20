package com.hpe.commander.model;

public interface ServerDef {

	/**
	 * @return server's ID
	 */
	public abstract String getId();

	/**
	 * @return server's description
	 */
	public abstract String getDescription();

	/**
	 * @return start script (full path)
	 */
	public abstract String getStartScript();

	/**
	 * @return stop script (full path)
	 */
	public abstract String getStopScript();

	/**
	 * @return deploy script (full path)
	 */
	public abstract String getDeployScript();

	/**
	 * @return alive script (full path)
	 */
	public abstract String getAliveScript();

	/**
	 * @return version script (full path)
	 */
	public abstract String getVersionScript();

	/**
	 * @return home URL
	 */
	public abstract String getHomeURL();

	/**
	 * @return Host Configuration
	 */
	public abstract HostConfig getHostConfig();

}
