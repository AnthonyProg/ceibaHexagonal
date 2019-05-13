package co.ceiba.adn.command.domain.dao;

import java.util.List;

import co.ceiba.adn.command.domain.model.VehicleRegistration;

public interface VehicleRegitrationRepository {
	
	/**
	 * Permite listar todos los registros del parqueadero
	 * que no tengan registro de salida (aquellos que se encuentran parqueados aun)
	 * @return los registros del parqueadero
	 */
	List<VehicleRegistration> listParked();
	
	/**
	 * Permite guardar el registro de entrada al parqueadero	 
	 * @return void
	 */
	VehicleRegistration save(VehicleRegistration vehicleRegistration) throws Exception;

}
