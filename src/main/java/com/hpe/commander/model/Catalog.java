package com.hpe.commander.model;

import java.util.List;

public interface Catalog {

	/**
	 * @return whole servers catalog
	 */
	public abstract List<ServerConfig> getAll();

	/**
	 * @return a server with a given ID
	 */
	public abstract ServerConfig getByID(String id);

	/**
	 * Reload the servers catalog from file
	 *
	 * @param title
	 * @param iSBN
	 * @return the added book
	 */
	public abstract void reload();

}
