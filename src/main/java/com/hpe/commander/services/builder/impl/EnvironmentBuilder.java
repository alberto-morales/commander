package com.hpe.commander.services.builder.impl;

import com.hpe.commander.model.EnvironmentDef;
import com.hpe.commander.services.builder.AbstractBuilder;
import com.hpe.commander.services.vo.EnvironmentVO;

public class EnvironmentBuilder extends AbstractBuilder<EnvironmentDef, EnvironmentVO> implements ObjectBuilder<EnvironmentDef, EnvironmentVO> {

	/* (non-Javadoc)
	 * @see com.hpe.commander.services.builder.impl.ObjectBuilder#build(java.lang.Object)
	 */
	public EnvironmentVO build(EnvironmentDef environment) {
		EnvironmentVO result
				= new EnvironmentVO(environment.getId(),
									environment.getDescription());
		result.setServers(environment.getServerList());
		return result;
	}

}
