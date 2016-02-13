package com.hpe.commander.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.hpe.commander.services.vo.EnvironmentVO;
import com.hpe.commander.services.vo.ServerVO;
import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.model.Catalog;
import com.hpe.commander.model.Startable;
import com.hpe.commander.model.impl.StartableFactory;
import com.hpe.commander.services.builder.impl.EnvironmentBuilder;
import com.hpe.commander.services.builder.impl.ServerBuilder;
import com.hpe.commander.util.EncDecrypter;

public class ServerService {

    @GET
    @Path("/passwords/{plainPassword}/encrypt")
    @Produces("text/plain")
    @Consumes("text/plain")
    public String encryptPassword(@PathParam("plainPassword") String plainPassword) {
    	return encDecrypter.encrypt(plainPassword);
    }

    @POST
    @Path("/passwords/{encryptedPassword}/decrypt")
    @Produces("text/plain")
    @Consumes("text/plain")
    public String decryptPassword(@PathParam("encryptedPassword") String encryptedPassword) {
    	return encDecrypter.decrypt(encryptedPassword);
    }

    @GET
    @Path("/catalogs/reload")
    @Produces("text/plain")
    public String reloadCatalogs() {
    	catalog.reload();
		return "Servers & environments definition file reloaded";
    }

    @GET
    @Path("/servers")
    @Produces("application/json")
    public List<ServerVO> getServers() {
    	List<ServerDef> serverConfigList = catalog.getServerDefs();
    	List<ServerVO> result = serverBuilder.build(serverConfigList);
		return result;
	}

    @GET
    @Path("/servers/{serverId}/")
    @Produces("application/json")
    @Consumes("application/json")
    public ServerVO getServer(@PathParam("serverId") String serverId) {
    	ServerDef serverConfig = getServerDefinition(serverId);
    	if (serverConfig == null) return null;
    	ServerVO result = serverBuilder.build(serverConfig);
		return result;
    }

    @GET
    @Path("/servers/{serverId}/start")
    @Produces("text/plain")
    @Consumes("application/json")
    public String startServer(@PathParam("serverId") String serverId) {
    	ServerDef serverDef = getServerDefinition(serverId);
    	Startable server = startableFactory.createStartable(serverDef);
    	String result = server.start();
		return result;
    }

    @GET
    @Path("/servers/{serverId}/stop")
    @Produces("text/plain")
    @Consumes("application/json")
    public String stopServer(@PathParam("serverId") String serverId) {
    	ServerDef serverDef = getServerDefinition(serverId);
    	Startable server = startableFactory.createStartable(serverDef);
    	String result = server.stop();
		return result;
    }

    @GET
    @Path("/environments")
    @Produces("application/json")
    public List<EnvironmentVO> getEnvironments() {
    	List<EnvironmentDef> environmentConfigList = catalog.getEnvironmentDefs();
    	List<EnvironmentVO> result = environmentBuilder.build(environmentConfigList);
		return result;
	}

    @GET
    @Path("/environments/{environmentId}/")
    @Produces("application/json")
    @Consumes("application/json")
    public EnvironmentVO getEnvironment(@PathParam("environmentId") String environmentId) {
    	EnvironmentDef environmentDefinition = getEnvironmentDefinition(environmentId);
    	if (environmentDefinition == null) return null;
    	EnvironmentVO result = environmentBuilder.build(environmentDefinition);
		return result;
    }

    @GET
    @Path("/environments/{environmentId}/start")
    @Produces("text/plain")
    @Consumes("application/json")
    public String startEnvironment(@PathParam("environmentId") String environmentId) {
    	EnvironmentDef environmentDef = getEnvironmentDefinition(environmentId);
    	Startable environment = startableFactory.createStartable(environmentDef);
    	String result = environment.start();
		return result;
    }

    @GET
    @Path("/environments/{environmentId}/stop")
    @Produces("text/plain")
    @Consumes("application/json")
    public String stopEnvironment(@PathParam("environmentId") String environmentId) {
    	EnvironmentDef environmentDef = getEnvironmentDefinition(environmentId);
    	Startable environment = startableFactory.createStartable(environmentDef);
    	String result = environment.stop();
		return result;
    }

    public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public void setServerBuilder(ServerBuilder serverBuilder) {
		this.serverBuilder = serverBuilder;
	}
	public void setEnvironmentBuilder(EnvironmentBuilder environmentBuilder) {
		this.environmentBuilder = environmentBuilder;
	}
	public void setStartableFactory(StartableFactory startableFactory) {
		this.startableFactory = startableFactory;
	}
	public void setEncDecrypter(EncDecrypter encDecrypter) {
		this.encDecrypter = encDecrypter;
	}

	private ServerDef getServerDefinition(String serverId) {
		if (serverId == null) return null;
    	ServerDef serverDefinition = catalog.getServerDefByID(serverId);
		return serverDefinition;
	}

	private EnvironmentDef getEnvironmentDefinition(String environmentId) {
		if (environmentId == null) return null;
    	EnvironmentDef environmentDefinition = catalog.getEnvironmentDefByID(environmentId);
		return environmentDefinition;
	}

    private Catalog catalog;
	private ServerBuilder serverBuilder;
	private EnvironmentBuilder environmentBuilder;
	private StartableFactory startableFactory;
	private EncDecrypter encDecrypter;

}
