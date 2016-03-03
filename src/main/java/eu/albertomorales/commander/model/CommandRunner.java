package eu.albertomorales.commander.model;

public interface CommandRunner {

	/**
	 * Run a system command
	 *
	 * @param command to be executed
	 * @param hostConfig
	 *
	 * @return command execution output
	 */
	public String run(String command, HostConfig hostConfig);

}
