package com.hpe.commander.util;

import java.util.Map;

import com.hpe.commander.model.ServerDef;

public interface Configuration {

	/**
	 * @return collection of servers definitions from configuration file
	 */
	public abstract Map<String, ServerDef> getServerDefinitions();

}
