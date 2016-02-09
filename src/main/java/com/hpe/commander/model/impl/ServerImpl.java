package com.hpe.commander.model.impl;

import com.hpe.commander.model.CommandRunner;
import com.hpe.commander.model.Server;
import com.hpe.commander.model.ServerDef;

public class ServerImpl implements Server {

	public ServerImpl(ServerDef serverConfiguration) {
		super();
		this.serverConfiguration = serverConfiguration;
	}

	@Override
	public String start() {
		return commandRunner.run(serverConfiguration.getStartScript(),
						  		 serverConfiguration.getHostConfig());
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return commandRunner.run(serverConfiguration.getStopScript(),
						  		 serverConfiguration.getHostConfig());
	}

	@Override
	public String getDescription() {
		return serverConfiguration == null ? "" : serverConfiguration.getDescription();
	}

	private ServerDef serverConfiguration;
	private CommandRunner commandRunner = new CommandRunnerImpl();

}
