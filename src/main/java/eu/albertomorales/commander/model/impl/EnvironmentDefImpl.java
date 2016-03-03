package eu.albertomorales.commander.model.impl;

import java.util.ArrayList;
import java.util.List;

import eu.albertomorales.commander.model.EnvironmentDef;

public class EnvironmentDefImpl implements EnvironmentDef {

	public EnvironmentDefImpl(String id,
							  String description,
							  String homeURL) {
		super();
		this.id = id;
		this.description = description;
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

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.model.EnvironmentDef#getHomeURL()
	 */
	public String getHomeURL() {
		return homeURL;
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
	private String homeURL;
	private List<String> serverList = new ArrayList<String>();

}
