package eu.albertomorales.commander.model;

public interface Server extends Startable, Deployable {

	/**
	 * @return server Description
	 */
	public abstract String getDescription();

}
