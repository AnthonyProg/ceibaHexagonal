package co.ceiba.adn.domain.dao;

import java.util.List;

import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.Vehicle;


public interface ParkingConsult {
	
	/**
	 * Permite listar los tipos de vehiculos
	 * @return los tipos de vehiculos
	 */
	List<Vehicle> list();
	
	/**
	 * Permite listar todos los registros del parqueadero que no tengan registro de
	 * salida (aquellos que se encuentran parqueados aun)
	 * 
	 * @return los registros del parqueadero
	 */
	List<VehicleRegistration> listParked(int status);
	
	/**
	 * Permite encontrar un registro de un vehiculo parqueado	 
	 * 
	 * @return el registro del parqueadero
	 */
	VehicleRegistration findRegistration(long id);

}
