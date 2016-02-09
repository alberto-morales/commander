package com.hpe.commander.model.impl;

import java.util.List;

import com.hpe.commander.model.Environment;
import com.hpe.commander.model.Server;

public class EnvironmentImpl implements Environment {

	public EnvironmentImpl(List<Server> serverList) {
		super();
		this.serverList = serverList;
	}

	@Override
	public String start() {
		String resultado = "";
		for (Server server : serverList) {
			resultado += "\n\rStarting "+server.getDescription()+"\n\r";
			resultado += server.start();
			resultado += "\n\r"+server.getDescription()+" started \n\r";
		}
		return resultado;
	}

	@Override
	public String stop() {
		String resultado = "";
		for (Server server : serverList) {
			resultado += "\n\rStoping "+server.getDescription()+"\n\r";
			resultado += server.stop();
			resultado += "\n\r"+server.getDescription()+" stoped \n\r";
		}
		return resultado;
	}

	private List<Server> serverList = null;
}
