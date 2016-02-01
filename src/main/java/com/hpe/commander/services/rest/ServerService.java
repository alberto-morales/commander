package com.hpe.commander.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.hpe.commander.services.vo.ServerVO;
import com.hpe.commander.model.Server;
import com.hpe.commander.model.ServerDef;
import com.hpe.commander.model.Catalog;
import com.hpe.commander.model.impl.ServerImpl;
import com.hpe.commander.services.builder.impl.ServerBuilder;

public class ServerService {

    @GET
    @Path("/servers/reload")
    @Produces("text/plain")
    @Consumes("application/json")
    public String reloadServers() {
    	catalog.reload();
		return "Servers definition file reloaded";
    }

    @GET
    @Path("/servers/{serverId}/")
    @Produces("application/json")
    @Consumes("application/json")
    public ServerVO getServer(@PathParam("serverId") String serverId) {
    	ServerDef serverConfig = getServerConfig(serverId);
    	if (serverConfig == null) return null;
    	ServerVO result = builder.build(serverConfig);
		return result;
    }

    @GET
    @Path("/servers/{serverId}/start")
    @Produces("application/json")
    @Consumes("application/json")
    public ServerVO startServer(@PathParam("serverId") String serverId) {
    	ServerDef serverConfig = getServerConfig(serverId);
    	if (serverConfig == null) return null;
    	Server server = new ServerImpl(serverConfig);
    	server.start();
    	ServerVO result = builder.build(serverConfig);
		return result;
    }

    @GET
    @Path("/servers/{serverId}/stop")
    @Produces("application/json")
    @Consumes("application/json")
    public ServerVO stopServer(@PathParam("serverId") String serverId) {
    	ServerDef serverConfig = getServerConfig(serverId);
    	if (serverConfig == null) return null;
    	Server server = new ServerImpl(serverConfig);
    	server.stop();
    	ServerVO result = builder.build(serverConfig);
		return result;
    }

	private ServerDef getServerConfig(String serverId) {
		if (serverId == null) return null;
    	ServerDef serverConfig = catalog.getByID(serverId);
		return serverConfig;
	}

    @GET
    @Path("/servers")
    @Produces("application/json")
    public List<ServerVO> getAll() {
    	List<ServerDef> serverConfigList = catalog.getAll();
    	List<ServerVO> result = builder.build(serverConfigList);
		return result;
	}

    public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public void setBuilder(ServerBuilder builder) {
		this.builder = builder;
	}

    private Catalog catalog;
	private ServerBuilder builder;

}
