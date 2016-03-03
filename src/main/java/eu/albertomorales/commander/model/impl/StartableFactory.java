package eu.albertomorales.commander.model.impl;

import eu.albertomorales.commander.model.EnvironmentDef;
import eu.albertomorales.commander.model.ServerDef;
import eu.albertomorales.commander.model.Startable;

public interface StartableFactory {

	/**
	 * creates a startable from a server definition
	 *
	 * @param serverDef
	 * @return
	 */
	public abstract Startable createStartable(ServerDef serverDef);

	/**
	 * Creates a startable from an environment definition
	 *
	 * @param environmentDef
	 * @return
	 */
	public abstract Startable createStartable(EnvironmentDef environmentDef);

}
