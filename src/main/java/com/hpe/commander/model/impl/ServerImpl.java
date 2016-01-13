package com.hpe.commander.model.impl;

import com.hpe.commander.model.Server;
import com.hpe.commander.model.ServerConfig;

public class ServerImpl implements Server {

	public ServerImpl(ServerConfig serverConfiguration) {
		super();
		this.serverConfiguration = serverConfiguration;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Starting "+serverConfiguration.getId());
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stoping "+serverConfiguration.getId());
	}

	private ServerConfig serverConfiguration;

}
