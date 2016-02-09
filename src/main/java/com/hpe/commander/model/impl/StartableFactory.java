package com.hpe.commander.model.impl;

import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.model.Startable;

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
