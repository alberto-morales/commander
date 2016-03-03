package eu.albertomorales.commander.services.builder;

import java.util.ArrayList;
import java.util.List;

import eu.albertomorales.commander.services.builder.impl.ObjectBuilder;

public abstract class AbstractBuilder<E, V> implements ObjectBuilder<E, V> {

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.services.builder.impl.ObjectBuilder#build(java.util.List)
	 */
	public List<V> build(List<E> entitiesList) {
		List<V> voList = new ArrayList<V>();
		for (E currentEntity : entitiesList) {
			V currentVO = build(currentEntity);
			voList.add(currentVO);
		}
		return voList;
	}

}
