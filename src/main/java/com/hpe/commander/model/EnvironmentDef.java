package com.hpe.commander.model;

import java.util.List;

public interface EnvironmentDef {

	/**
	 * @return environment's ID
	 */
	public abstract String getId();

	/**
	 * @return environment's description
	 */
	public abstract String getDescription();

	/**
	 * @return home URL
	 */
	public abstract String getHomeURL();

	/**
	 * @return list of server-IDs the environment is made up of
	 */
	public abstract List<String> getServerList();

	/**
	 * add a server-ID to the Environment's server list
	 *
	 * @param serverId server ID to be added
	 */
	public abstract void addServer(String serverId);

}
