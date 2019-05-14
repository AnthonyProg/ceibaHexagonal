package co.ceiba.adn.domain.dao;

import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

public interface ParkingRegitration {

	/**
	 * Permite guardar el registro de entrada al parqueadero* 
	 * @return void
	 * @throws VehicleRegistrationException
	 */
	VehicleRegistration register(VehicleRegistration vehicleRegistration) throws VehicleRegistrationException;

}
