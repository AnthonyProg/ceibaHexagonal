package co.ceiba.adn.command.domain.exception;

public class ConfigurationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ConfigurationException(String message, Throwable exception) {
		super(message, exception);
	}

}
