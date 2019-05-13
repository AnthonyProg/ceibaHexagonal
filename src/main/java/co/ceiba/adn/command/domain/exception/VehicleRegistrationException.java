package co.ceiba.adn.command.domain.exception;

public class VehicleRegistrationException extends Exception {

	private static final long serialVersionUID = 1L;

	public VehicleRegistrationException(String message, Throwable error) {
		super(message, error);
	}
}
