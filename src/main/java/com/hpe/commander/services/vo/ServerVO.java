package com.hpe.commander.services.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="server")
public class ServerVO implements Serializable {

	public ServerVO() {
	}

	public ServerVO(String id,
					String description,
					String address,
					String username,
					String password,
					String startScript,
					String stopScript,
					String aliveScript,
					String versionScript,
					String homeURL) {
		super();
		this.id = id;
		this.description = description;
		this.address = address;
		this.username = username;
		this.password = password;
		this.startScript = startScript;
		this.stopScript = stopScript;
		this.aliveScript = aliveScript;
		this.versionScript = versionScript;
		this.homeURL = homeURL;
	}

	@XmlElement(name="aliveScript")
	public String getAliveScript() {
		return aliveScript;
	}

	public void setAliveScript(String aliveScript) {
		this.aliveScript = aliveScript;
	}

	@XmlElement(name="versionScript")
	public String getVersionScript() {
		return versionScript;
	}

	public void setVersionScript(String versionScript) {
		this.versionScript = versionScript;
	}

	@XmlElement(name="homeURL")
	public String getHomeURL() {
		return homeURL;
	}

	public void setHomeURL(String homeURL) {
		this.homeURL = homeURL;
	}

	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*
	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}
	*/

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement(name="startScript")
	public String getStartScript() {
		return startScript;
	}

	public void setStartScript(String startScript) {
		this.startScript = startScript;
	}

	@XmlElement(name="stopScript")
	public String getStopScript() {
		return stopScript;
	}

	public void setStopScript(String stopScript) {
		this.stopScript = stopScript;
	}

	@XmlElement(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String id;
	private String description;
	private String address;
	private String username;
	@SuppressWarnings("unused")
	private String password;
	private String startScript;
	private String stopScript;
	private String aliveScript;
	private String versionScript;
	private String homeURL;
	private static final long serialVersionUID = 1L;

}
