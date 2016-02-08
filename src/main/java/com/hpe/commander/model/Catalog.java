package com.hpe.commander.model;

import java.util.List;

public interface Catalog {

	/**
	 * @return whole servers catalog
	 */
	public abstract List<ServerDef> getServers();

	/**
	 * @return a server with a given ID
	 */
	public abstract ServerDef getServerByID(String id);

	/**
	 * @return whole environments catalog
	 */
	public abstract List<EnvironmentDef> getEnvironments();

	/**
	 * @return a environment with a given ID
	 */
	public abstract EnvironmentDef getEnvironmentByID(String id);

	/**
	 * Reload the servers and environments catalog from file
	 */
	public abstract void reload();

}
