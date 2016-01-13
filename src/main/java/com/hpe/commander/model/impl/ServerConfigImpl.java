package com.hpe.commander.model.impl;

import com.hpe.commander.model.ServerConfig;

public class ServerConfigImpl implements ServerConfig {

	public ServerConfigImpl() {
	}

	public ServerConfigImpl(String id, String description, String address,
			String username, String password, String startScript,
			String stopScript) {
		super();
		this.id = id;
		this.description = description;
		this.address = address;
		this.username = username;
		this.password = password;
		this.startScript = startScript;
		this.stopScript = stopScript;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getStartScript() {
		return startScript;
	}

	@Override
	public String getStopScript() {
		return stopScript;
	}


	private String id;
	private String description;
	private String address;
	private String username;
	private String password;
	private String startScript;
	private String stopScript;

}
