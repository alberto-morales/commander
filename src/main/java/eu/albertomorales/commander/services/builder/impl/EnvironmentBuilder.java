package eu.albertomorales.commander.services.builder.impl;

import eu.albertomorales.commander.model.EnvironmentDef;
import eu.albertomorales.commander.services.builder.AbstractBuilder;
import eu.albertomorales.commander.services.vo.EnvironmentVO;

public class EnvironmentBuilder extends AbstractBuilder<EnvironmentDef, EnvironmentVO> implements ObjectBuilder<EnvironmentDef, EnvironmentVO> {

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.services.builder.impl.ObjectBuilder#build(java.lang.Object)
	 */
	public EnvironmentVO build(EnvironmentDef environment) {
		EnvironmentVO result
				= new EnvironmentVO(environment.getId(),
									environment.getDescription(),
									environment.getHomeURL());
		result.setServers(environment.getServerList());
		return result;
	}

}
