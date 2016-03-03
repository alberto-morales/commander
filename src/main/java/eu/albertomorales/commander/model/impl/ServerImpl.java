package eu.albertomorales.commander.model.impl;

import eu.albertomorales.commander.model.CommandRunner;
import eu.albertomorales.commander.model.Server;
import eu.albertomorales.commander.model.ServerDef;

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
		return commandRunner.run(serverConfiguration.getStopScript(),
						  		 serverConfiguration.getHostConfig());
	}


	@Override
	public String deploy() {
		return commandRunner.run(serverConfiguration.getDeployScript(),
						  		 serverConfiguration.getHostConfig());
	}

	@Override
	public String getDescription() {
		return serverConfiguration == null ? "" : serverConfiguration.getDescription();
	}

	private ServerDef serverConfiguration;
	private CommandRunner commandRunner = new CommandRunnerImpl();

}
