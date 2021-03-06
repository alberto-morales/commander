package eu.albertomorales.commander.services.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="environment")
public class EnvironmentVO implements Serializable {

	public EnvironmentVO() {
	}

	public EnvironmentVO(String id, String description, String homeURL) {
		super();
		this.id = id;
		this.description = description;
		this.homeURL = homeURL;
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

	@XmlElement(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name="servers")
	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	private String id;
	private String description;
	private String homeURL;

	private List<String> servers = new ArrayList<String>();

	private static final long serialVersionUID = 1L;

}
