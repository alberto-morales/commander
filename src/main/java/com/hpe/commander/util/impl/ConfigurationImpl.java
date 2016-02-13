package com.hpe.commander.util.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.model.impl.EnvironmentDefImpl;
import com.hpe.commander.model.impl.ServerDefImpl;
import com.hpe.commander.util.Configuration;
import com.hpe.commander.util.EncDecrypter;

public class ConfigurationImpl implements Configuration {

	/* (non-Javadoc)
	 * @see com.hpe.commander.util.Configuration#getServerDefinitions()
	 */
	@Override
	public Map<String, ServerDef> getServerDefinitions() {
		Map<String, ServerDef> result = new HashMap<String, ServerDef>();

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
			//Element root = document.getDocumentElement();

			//Get all servers
			NodeList nList = document.getElementsByTagName("server");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
				    //Deal with each server's detail
					Element eElement = (Element) node;
					String id = eElement.getAttribute("id");
					String description = eElement.getElementsByTagName("description").item(0).getTextContent();
					String address = eElement.getElementsByTagName("address").item(0).getTextContent();
					String SSHPort = eElement.getElementsByTagName("SSHPort").item(0).getTextContent();
					String username = eElement.getElementsByTagName("username").item(0).getTextContent();
					String encryptedPassword = eElement.getElementsByTagName("password").item(0).getTextContent();
					String password = encDecrypter.decrypt(encryptedPassword);
					String startScript = eElement.getElementsByTagName("startScript").item(0).getTextContent();
					String stopScript = eElement.getElementsByTagName("stopScript").item(0).getTextContent();
					ServerDef newServer = new ServerDefImpl(id, description,
															address, Integer.valueOf(SSHPort),
															username, password,
															startScript, stopScript);
					result.put(id,  newServer);
				}
			}

		} catch (Exception e) {
			log.error("Error dealing with servers definitions",e);
			throw new RuntimeException("Error dealing with servers definitions",e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hpe.commander.util.Configuration#getEnvironmentDefinitions()
	 */
	@Override
	public Map<String, EnvironmentDef> getEnvironmentDefinitions() {
		Map<String, EnvironmentDef> result = new HashMap<String, EnvironmentDef>();

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
			//Element root = document.getDocumentElement();

			//Get all servers
			NodeList nList = document.getElementsByTagName("environment");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
				    //Deal with each environment's detail
					Element eElement = (Element) node;
					String id = eElement.getAttribute("id");
					String description = eElement.getElementsByTagName("description").item(0).getTextContent();
					EnvironmentDef newEnvironment = new EnvironmentDefImpl(id, description);
					NodeList children = eElement.getElementsByTagName("server-ref");
					for (int j = 0; j < children.getLength(); j++) {
						Node child = children.item(j);
						if (child.getNodeType() == Node.ELEMENT_NODE) {
							Element eChild = (Element) child;
							String idServer = eChild.getElementsByTagName("id").item(0).getTextContent();
							newEnvironment.addServer(idServer);
						}
					}
					result.put(id,  newEnvironment);
				}
			}

		} catch (Exception e) {
			log.error("Error dealing with environment definitions",e);
			throw new RuntimeException("Error dealing with environment definitions",e);
		}
		return result;
	}

	private String getConfigFilePath() {
		return System.getProperty("com.hpe.commander.config-file", "commander-config.xml");
	}

	public void setEncDecrypter(EncDecrypter encDecrypter) {
		this.encDecrypter = encDecrypter;
	}

	private EncDecrypter encDecrypter;

	private static Log log = LogFactory.getLog(ConfigurationImpl.class);

}
