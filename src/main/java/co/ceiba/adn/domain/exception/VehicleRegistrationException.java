package co.ceiba.adn.domain.exception;

public class VehicleRegistrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehicleRegistrationException(String message, Throwable error) {
		super(message, error);
	}
}
