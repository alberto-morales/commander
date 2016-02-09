package com.hpe.commander.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.hpe.commander.model.EnvironmentDef;

public class EnvironmentDefImpl implements EnvironmentDef {

	public EnvironmentDefImpl(String id, String description) {
		super();
		this.id = id;
		this.description = description;
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
	public List<String> getServerList() {
		return serverList;
	}

	@Override
	public void addServer(String serverId) {
		serverList.add(serverId);
	}

	private String id;
	private String description;
	private List<String> serverList = new ArrayList<String>();


}
