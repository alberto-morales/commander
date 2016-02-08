package com.hpe.commander.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.ServerDef;

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

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<ServerDef> getServerList() {
		return new ArrayList<ServerDef>();
	}

	private String id;
	private String description;

}
