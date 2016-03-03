package eu.albertomorales.commander.util;

import java.util.Map;

import eu.albertomorales.commander.model.EnvironmentDef;
import eu.albertomorales.commander.model.ServerDef;

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
