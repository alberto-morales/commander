package com.hpe.commander.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hpe.commander.model.Catalog;
import com.hpe.commander.model.ServerConfig;
import com.hpe.commander.util.Configuration;

public class CatalogImpl implements Catalog {

    @Override
    public List<ServerConfig> getAll() {
        synchronized (allServers) {
            if (allServers.isEmpty()) {
            	reload();
            }
            return new ArrayList<ServerConfig>(allServers.values());
        }
    }

    @Override
    public ServerConfig getByID(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id can not be null");
        }
        synchronized (allServers) {
            if (allServers.isEmpty()) {
            	reload();
            }
            for (ServerConfig server : allServers.values()) {
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

    private Map<String, ServerConfig> allServers =  new HashMap<String, ServerConfig> ();
    private Configuration configuration;

}
