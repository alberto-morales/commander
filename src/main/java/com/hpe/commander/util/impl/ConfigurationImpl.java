package com.hpe.commander.util.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hpe.commander.model.ServerConfig;
import com.hpe.commander.model.impl.ServerConfigImpl;
import com.hpe.commander.util.Configuration;

public class ConfigurationImpl implements Configuration {

	@Override
	public Map<String, ServerConfig> getServerDefinitions() {
		Map<String, ServerConfig> result = new HashMap<String, ServerConfig>();

		try {
			//Get Document Builder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			//Build Document
			String configFilePath = getConfigFilePath();
			Document document = builder.parse(new File(configFilePath));

			//Normalize the XML Structure; It's just too important !!
			document.getDocumentElement().normalize();

			//Here comes the root node
			Element root = document.getDocumentElement();

			//Get all servers
			NodeList nList = document.getElementsByTagName("server");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node node = nList.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
				    //Print each server's detail
					Element eElement = (Element) node;
					String id = eElement.getAttribute("id");
					String description = eElement.getElementsByTagName("description").item(0).getTextContent();
					String address = eElement.getElementsByTagName("address").item(0).getTextContent();
					String username = eElement.getElementsByTagName("username").item(0).getTextContent();
					String password = eElement.getElementsByTagName("password").item(0).getTextContent();
					String startScript = eElement.getElementsByTagName("startScript").item(0).getTextContent();
					String stopScript = eElement.getElementsByTagName("stopScript").item(0).getTextContent();
					ServerConfig newServer = new ServerConfigImpl(id, description, address, username, password, startScript, stopScript);
					result.put(id,  newServer);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getPythonPath() {
		return System.getProperty("com.hpe.commander.python", "commander-config.xml");
	}

	private String getConfigFilePath() {
		return System.getProperty("com.hpe.commander.config-file", "commander-config.xml");
	}

}
