package eu.albertomorales.commander.model.impl;

import eu.albertomorales.commander.model.HostConfig;

public class HostConfigImpl implements HostConfig  {

	public HostConfigImpl() {
		super();
	}

	public HostConfigImpl(String address,
						  Integer SSHPort,
						  String username,
						  String password) {
		super();
		this.address = address;
		this.username = username;
		this.password = password;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public Integer getSSHPort() {
		return SSHPort;
	}

	public void setSSHPort(Integer SSHPort) {
		this.SSHPort = SSHPort;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String address;
	private Integer SSHPort;
	private String username;
	private String password;

}
