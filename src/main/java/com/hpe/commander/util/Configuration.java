package com.hpe.commander.util;

import java.util.Map;

import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.ServerDef;

public interface Configuration {

	/**
	 * @return collection of server definition from configuration file
	 */
	public abstract Map<String, ServerDef> getServerDefinitions();

	/**
	 * @return collection of environment definition from configuration file
	 */
	public abstract Map<String, EnvironmentDef> getEnvironmentDefinitions();

}
