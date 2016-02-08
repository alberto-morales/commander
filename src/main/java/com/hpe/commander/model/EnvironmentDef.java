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
	 * @return list of servers the environment is made up of
	 */
	public abstract List<ServerDef> getServerList();

}
