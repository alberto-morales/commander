package eu.albertomorales.commander.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.albertomorales.commander.model.Catalog;
import eu.albertomorales.commander.model.EnvironmentDef;
import eu.albertomorales.commander.model.ServerDef;
import eu.albertomorales.commander.util.Configuration;

public class CatalogImpl implements Catalog {

    /* (non-Javadoc)
     * @see eu.albertomorales.commander.model.Catalog#getServerDefs()
     */
    @Override
    public List<ServerDef> getServerDefs() {
        synchronized (configuration) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return new ArrayList<ServerDef>(allServers.values());
        }
    }


    /* (non-Javadoc)
     * @see eu.albertomorales.commander.model.Catalog#getServerDefByID(java.lang.String)
     */
    @Override
    public ServerDef getServerDefByID(String id) {
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
	 * @see eu.albertomorales.commander.model.Catalog#getEnvironmentDefs()
	 */
	@Override
	public List<EnvironmentDef> getEnvironmentDefs() {
        synchronized (configuration) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return new ArrayList<EnvironmentDef>(allEnvironments.values());
        }
	}

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.model.Catalog#getEnvironmentDefByID(java.lang.String)
	 */
	@Override
	public EnvironmentDef getEnvironmentDefByID(String id) {
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
     * @see eu.albertomorales.commander.model.Catalog#reload()
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
