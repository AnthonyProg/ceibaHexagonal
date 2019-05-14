package co.ceiba.adn.domain.exception;

public class ConfigurationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ConfigurationException(String message, Throwable exception) {
		super(message, exception);
	}

}