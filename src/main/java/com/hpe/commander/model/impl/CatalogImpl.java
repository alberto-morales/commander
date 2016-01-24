package com.hpe.commander.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hpe.commander.model.Catalog;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.util.Configuration;

public class CatalogImpl implements Catalog {

    @Override
    public List<ServerDef> getAll() {
        synchronized (allServers) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return new ArrayList<ServerDef>(allServers.values());
        }
    }

    @Override
    public ServerDef getByID(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id can not be null");
        }
        synchronized (allServers) {
            if (allServers.isEmpty()) {
            	reload();
            }
            for (ServerDef server : allServers.values()) {
                if (id.equals(server.getId())) {
                    return server;
                }
            }
            return null;
        }
    }

    @Override
    public void reload() {
        synchronized (allServers) {
        	allServers = configuration.getServerDefinitions();
        }
    }

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

    private Map<String, ServerDef> allServers =  new HashMap<String, ServerDef> ();
    private Configuration configuration;

}
