package com.hpe.commander.services.builder.impl;

import com.hpe.commander.model.ServerConfig;
import com.hpe.commander.services.builder.AbstractBuilder;
import com.hpe.commander.services.vo.ServerVO;

public class ServerBuilder extends AbstractBuilder<ServerConfig, ServerVO> implements ObjectBuilder<ServerConfig, ServerVO> {

	/* (non-Javadoc)
	 * @see com.hpe.commander.services.builder.impl.ObjectBuilder#build(java.lang.Object)
	 */
	public ServerVO build(ServerConfig server) {
		ServerVO result = new ServerVO(server.getId(), server.getDescription(), server.getAddress(),
									   server.getUsername(), server.getPassword(),
									   server.getStartScript(), server.getStopScript());
		return result;
	}

}
