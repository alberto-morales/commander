package eu.albertomorales.commander.model;

public interface HostConfig {

	/**
	 * @return server's address
	 */
	public abstract String getAddress();

	/**
	 * @return server's administrative username
	 */
	public abstract String getUsername();


	/**
	 * @return server's administrative password
	 */
	public abstract String getPassword();

	/**
	 * @return server's SSH port
	 */
	public abstract Integer getSSHPort();

}
