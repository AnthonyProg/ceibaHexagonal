package co.ceiba.adn.domain.dao;

import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

public interface ParkingRegitration {

	/**
	 * Permite guardar el registro de entrada al parqueadero
	 * @return void
	 * @throws VehicleRegistrationException
	 */
	void register(VehicleRegistration vehicleRegistration);
	
	/**
	 * Permite actualizar el registro de entrada al parqueadero 
	 * @return void
	 * @throws VehicleRegistrationException
	 */
	void actualizar(VehicleRegistration vehicleRegistration);

}
