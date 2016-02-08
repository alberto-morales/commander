package com.hpe.commander.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.hpe.commander.services.vo.EnvironmentVO;
import com.hpe.commander.services.vo.ServerVO;
import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.model.Server;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.model.Catalog;
import com.hpe.commander.model.impl.ServerImpl;
import com.hpe.commander.services.builder.impl.EnvironmentBuilder;
import com.hpe.commander.services.builder.impl.ServerBuilder;

public class ServerService {

    @GET
    @Path("/servers/reload")
    @Produces("text/plain")
    @Consumes("application/json")
    public String reloadServers() {
    	catalog.reload();
		return "Servers & environments definition file reloaded";
    }

    @GET
    @Path("/servers")
    @Produces("application/json")
    public List<ServerVO> getServers() {
    	List<ServerDef> serverConfigList = catalog.getServers();
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
    	ServerDef serverConfig = getServerDefinition(serverId);
    	if (serverConfig == null) return null;
    	Server server = new ServerImpl(serverConfig);
    	String result = server.start();
		return result;
    }

    @GET
    @Path("/servers/{serverId}/stop")
    @Produces("text/plain")
    @Consumes("application/json")
    public String stopServer(@PathParam("serverId") String serverId) {
    	ServerDef serverConfig = getServerDefinition(serverId);
    	if (serverConfig == null) return null;
    	Server server = new ServerImpl(serverConfig);
    	String result = server.stop();
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
    @Path("/environments")
    @Produces("application/json")
    public List<EnvironmentVO> getEnvironments() {
    	List<EnvironmentDef> environmentConfigList = catalog.getEnvironments();
    	List<EnvironmentVO> result = environmentBuilder.build(environmentConfigList);
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

	private ServerDef getServerDefinition(String serverId) {
		if (serverId == null) return null;
    	ServerDef serverDefinition = catalog.getServerByID(serverId);
		return serverDefinition;
	}

	private EnvironmentDef getEnvironmentDefinition(String environmentId) {
		if (environmentId == null) return null;
    	EnvironmentDef environmentDefinition = catalog.getEnvironmentByID(environmentId);
		return environmentDefinition;
	}

    private Catalog catalog;
	private ServerBuilder serverBuilder;
	private EnvironmentBuilder environmentBuilder;

}
