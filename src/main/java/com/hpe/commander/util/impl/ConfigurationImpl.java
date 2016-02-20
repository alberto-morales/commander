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

	private static final String ENV_TAG_SERVER_REF = "server-ref";
	private static final String ENV_TAG_ID = "id";
	private static final String ENV_TAG_ENVIRONMENT = "environment";
	private static final String ENV_TAG_DESCRIPTION = "description";
	private static final String ENV_TAG_HOME_URL = "homeURL";

	private static final String SERVER_TAG_HOME_URL = "homeURL";
	private static final String SERVER_TAG_VERSION_SCRIPT = "versionScript";
	private static final String SERVER_TAG_ALIVE_SCRIPT = "aliveScript";
	private static final String SERVER_TAG_DEPLOY_SCRIPT = "deployScript";
	private static final String SERVER_TAG_STOP_SCRIPT = "stopScript";
	private static final String SERVER_TAG_START_SCRIPT = "startScript";
	private static final String SERVER_TAG_PASSWORD = "password";
	private static final String SERVER_TAG_USERNAME = "username";
	private static final String SERVER_TAG_SSH_PORT = "SSHPort";
	private static final String SERVER_TAG_ADDRESS = "address";
	private static final String SERVER_TAG_DESCRIPTION = "description";
	private static final String SERVER_TAG_SERVER = "server";

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
			NodeList nList = document.getElementsByTagName(SERVER_TAG_SERVER);

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
				    //Deal with each server's detail
					Element eElement = (Element) node;
					String id = eElement.getAttribute(ENV_TAG_ID);
					String description = eElement.getElementsByTagName(SERVER_TAG_DESCRIPTION).item(0).getTextContent();
					String address = eElement.getElementsByTagName(SERVER_TAG_ADDRESS).item(0).getTextContent();
					String SSHPort = eElement.getElementsByTagName(SERVER_TAG_SSH_PORT).item(0).getTextContent();
					String username = eElement.getElementsByTagName(SERVER_TAG_USERNAME).item(0).getTextContent();
					String encryptedPassword = eElement.getElementsByTagName(SERVER_TAG_PASSWORD).item(0).getTextContent();
					String password = encDecrypter.decrypt(encryptedPassword);
					String startScript = eElement.getElementsByTagName(SERVER_TAG_START_SCRIPT).item(0).getTextContent();
					String stopScript = eElement.getElementsByTagName(SERVER_TAG_STOP_SCRIPT).item(0).getTextContent();
					String deployScript = eElement.getElementsByTagName(SERVER_TAG_DEPLOY_SCRIPT).item(0).getTextContent();
					String aliveScript = eElement.getElementsByTagName(SERVER_TAG_ALIVE_SCRIPT).item(0).getTextContent();
					String versionScript = eElement.getElementsByTagName(SERVER_TAG_VERSION_SCRIPT).item(0).getTextContent();
					String homeURL = eElement.getElementsByTagName(SERVER_TAG_HOME_URL).item(0).getTextContent();
					ServerDef newServer = new ServerDefImpl(id,
															description,
															address,
															Integer.valueOf(SSHPort),
															username,
															password,
															startScript,
															stopScript,
															deployScript,
															aliveScript,
															versionScript,
															homeURL);
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
			NodeList nList = document.getElementsByTagName(ENV_TAG_ENVIRONMENT);

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
				    //Deal with each environment's detail
					Element eElement = (Element) node;
					String id = eElement.getAttribute(ENV_TAG_ID);
					String description = eElement.getElementsByTagName(ENV_TAG_DESCRIPTION).item(0).getTextContent();
					String homeURL = eElement.getElementsByTagName(ENV_TAG_HOME_URL).item(0).getTextContent();
					EnvironmentDef newEnvironment = new EnvironmentDefImpl(id, description, homeURL);
					NodeList children = eElement.getElementsByTagName(ENV_TAG_SERVER_REF);
					for (int j = 0; j < children.getLength(); j++) {
						Node child = children.item(j);
						if (child.getNodeType() == Node.ELEMENT_NODE) {
							Element eChild = (Element) child;
							String idServer = eChild.getElementsByTagName(ENV_TAG_ID).item(0).getTextContent();
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
