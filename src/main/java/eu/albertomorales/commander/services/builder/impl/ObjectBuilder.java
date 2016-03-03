package eu.albertomorales.commander.services.builder.impl;

import java.util.List;

public interface ObjectBuilder<E, V> {

	/**
	 * Converts a list of entities to a list of VO's
	 *
	 * @param entitiesList to be converted
	 *
	 * @return List of VO's as a representation of a entities list
	 */
	public abstract List<V> build(List<E> entitiesList);

	/**
	 * Converts a entity to a VO
	 *
	 * @param entity to be converted
	 *
	 * @return VO as a representation of a entity
	 */
	public abstract V build(E entity);

}
