package eu.albertomorales.commander.model.impl;

import java.util.ArrayList;
import java.util.List;

import eu.albertomorales.commander.model.Catalog;
import eu.albertomorales.commander.model.EnvironmentDef;
import eu.albertomorales.commander.model.Server;
import eu.albertomorales.commander.model.ServerDef;
import eu.albertomorales.commander.model.Startable;

public class StartableFactoryImpl implements StartableFactory {

	@Override
	public Startable createStartable(ServerDef serverDef) {
		if (serverDef == null) {
			throw new IllegalArgumentException("serverDef can't be null");
		}
		Server server = new ServerImpl(serverDef);
		return server;
	}

	@Override
	public Startable createStartable(EnvironmentDef environmentDef) {
		if (environmentDef == null) {
			throw new IllegalArgumentException("environmentDef can't be null");
		}
		List<Server> serverList = new ArrayList<Server>();
		for (String serverId : environmentDef.getServerList()) {
			ServerDef serverDef = catalog.getServerDefByID(serverId);
			Server server = (Server) createStartable(serverDef);
			serverList.add(server);
		}
		EnvironmentImpl environment = new EnvironmentImpl(serverList);
		return environment;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

    private Catalog catalog;

}
