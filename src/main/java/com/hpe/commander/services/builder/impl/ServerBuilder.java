package com.hpe.commander.services.builder.impl;

import com.hpe.commander.model.ServerDef;
import com.hpe.commander.services.builder.AbstractBuilder;
import com.hpe.commander.services.vo.ServerVO;

public class ServerBuilder extends AbstractBuilder<ServerDef, ServerVO> implements ObjectBuilder<ServerDef, ServerVO> {

	/* (non-Javadoc)
	 * @see com.hpe.commander.services.builder.impl.ObjectBuilder#build(java.lang.Object)
	 */
	public ServerVO build(ServerDef server) {
		ServerVO result = new ServerVO(server.getId(),
									   server.getDescription(),
									   server.getHostConfig().getAddress(),
									   server.getHostConfig().getUsername(),
									   server.getHostConfig().getPassword(),
									   server.getStartScript(),
									   server.getStopScript());
		return result;
	}

}
