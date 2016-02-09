package com.hpe.commander.model;

import java.util.List;

public interface Catalog {

	/**
	 * @return whole server definitions catalog
	 */
	public abstract List<ServerDef> getServerDefs();

	/**
	 * @return a server definition with a given ID
	 */
	public abstract ServerDef getServerDefByID(String id);

	/**
	 * @return whole environment definitions catalog
	 */
	public abstract List<EnvironmentDef> getEnvironmentDefs();

	/**
	 * @return a environment definition with a given ID
	 */
	public abstract EnvironmentDef getEnvironmentDefByID(String id);

	/**
	 * Reload the servers and environments catalog from file
	 */
	public abstract void reload();

}
