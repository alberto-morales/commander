package eu.albertomorales.commander.services.builder.impl;

import eu.albertomorales.commander.model.ServerDef;
import eu.albertomorales.commander.services.builder.AbstractBuilder;
import eu.albertomorales.commander.services.vo.ServerVO;

public class ServerBuilder extends AbstractBuilder<ServerDef, ServerVO> implements ObjectBuilder<ServerDef, ServerVO> {

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.services.builder.impl.ObjectBuilder#build(java.lang.Object)
	 */
	@Override
	public ServerVO build(ServerDef server) {
		ServerVO result = new ServerVO(server.getId(),
									   server.getDescription(),
									   server.getHostConfig().getAddress(),
									   server.getHostConfig().getUsername(),
									   server.getHostConfig().getPassword(),
									   server.getStartScript(),
									   server.getStopScript(),
									   server.getHomeURL()
									   );
		return result;
	}

}
