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
	public void start() {
		commandRunner.run(serverConfiguration.getStartScript(),
						  serverConfiguration.getHostConfig());
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		commandRunner.run(serverConfiguration.getStopScript(),
						  serverConfiguration.getHostConfig());
	}

	private ServerDef serverConfiguration;
	private CommandRunner commandRunner = new CommandRunnerImpl();

}
