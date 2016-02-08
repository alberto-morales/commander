package com.hpe.commander.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hpe.commander.model.Catalog;
import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.util.Configuration;

public class CatalogImpl implements Catalog {

    /* (non-Javadoc)
     * @see com.hpe.commander.model.Catalog#getServers()
     */
    @Override
    public List<ServerDef> getServers() {
        synchronized (configuration) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return new ArrayList<ServerDef>(allServers.values());
        }
    }

    /* (non-Javadoc)
     * @see com.hpe.commander.model.Catalog#getServerByID(java.lang.String)
     */
    @Override
    public ServerDef getServerByID(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id can not be null");
        }
        synchronized (configuration) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return allServers.get(id);
        }
    }

	/* (non-Javadoc)
	 * @see com.hpe.commander.model.Catalog#getEnvironments()
	 */
	@Override
	public List<EnvironmentDef> getEnvironments() {
        synchronized (configuration) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return new ArrayList<EnvironmentDef>(allEnvironments.values());
        }
	}

	/* (non-Javadoc)
	 * @see com.hpe.commander.model.Catalog#getEnvironmentByID(java.lang.String)
	 */
	@Override
	public EnvironmentDef getEnvironmentByID(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id can not be null");
        }
        synchronized (configuration) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return allEnvironments.get(id);
        }
	}

    /* (non-Javadoc)
     * @see com.hpe.commander.model.Catalog#reload()
     */
    @Override
    public void reload() {
        synchronized (configuration) {
        	allServers = configuration.getServerDefinitions();
        	allEnvironments = configuration.getEnvironmentDefinitions();
        }
    }

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

    private Map<String, ServerDef> allServers =  new HashMap<String, ServerDef> ();
    private Map<String, EnvironmentDef> allEnvironments =  new HashMap<String, EnvironmentDef> ();
    private Configuration configuration;

}
