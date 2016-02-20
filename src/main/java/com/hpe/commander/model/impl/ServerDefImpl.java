package com.hpe.commander.model.impl;

import com.hpe.commander.model.ServerDef;

public class ServerDefImpl implements ServerDef {

	public ServerDefImpl() {
	}

	public ServerDefImpl(String id,
						 String description,
						 String address,
						 Integer SSHPort,
						 String username,
						 String password,
						 String startScript,
						 String stopScript,
						 String deployScript,
						 String aliveScript,
						 String versionScript,
						 String homeURL) {
		super();
		this.id = id;
		this.description = description;
		hostConfig.setAddress(address);
		hostConfig.setSSHPort(SSHPort);
		hostConfig.setUsername(username);
		hostConfig.setPassword(password);
		this.startScript = startScript;
		this.stopScript = stopScript;
		this.deployScript = deployScript;
		this.aliveScript = aliveScript;
		this.versionScript = versionScript;
		this.homeURL = homeURL;
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
	public String getStartScript() {
		return startScript;
	}

	@Override
	public String getStopScript() {
		return stopScript;
	}

	@Override
	public String getDeployScript() {
		return deployScript;
	}

	@Override
	public String getAliveScript() {
		return aliveScript;
	}

	@Override
	public String getVersionScript() {
		return versionScript;
	}

	@Override
	public String getHomeURL() {
		return homeURL;
	}

	public HostConfigImpl getHostConfig() {
		return hostConfig;
	}

	private String id;
	private String description;
	private String startScript;
	private String stopScript;
	private String deployScript;
	private String aliveScript;
	private String versionScript;
	private String homeURL;
	private HostConfigImpl hostConfig = new HostConfigImpl();

}
