package eu.albertomorales.commander.services.builder.impl;

import eu.albertomorales.commander.model.CommandRunner;
import eu.albertomorales.commander.model.ServerDef;
import eu.albertomorales.commander.model.impl.CommandRunnerImpl;
import eu.albertomorales.commander.services.vo.ServerVO;

public class ServerBuilderEnhanced extends ServerBuilder {

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.services.builder.impl.ObjectBuilder#build(java.lang.Object)
	 */
	@Override
	public ServerVO build(ServerDef serverDef) {
		ServerVO result = super.build(serverDef);
		String aliveScript = serverDef.getAliveScript();
		if (aliveScript != null && !"".equals(aliveScript)) {
			String aliveStatus = commandRunner.run(aliveScript,
					 		     serverDef.getHostConfig());
			result.setAlive(aliveStatus);
		}
		String versionScript = serverDef.getVersionScript();
		if (versionScript != null && !"".equals(versionScript)) {
			String version = commandRunner.run(versionScript,
					   serverDef.getHostConfig());
			result.setVersion(version);
		}
		return result;
	}

	private CommandRunner commandRunner = new CommandRunnerImpl();

}
