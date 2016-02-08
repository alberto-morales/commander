package com.hpe.commander.services.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="environment")
public class EnvironmentVO implements Serializable {

	public EnvironmentVO() {
	}

	public EnvironmentVO(String id, String description) {
		super();
		this.id = id;
		this.description = description;
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

	private String id;
	private String description;
	private static final long serialVersionUID = 1L;

}
