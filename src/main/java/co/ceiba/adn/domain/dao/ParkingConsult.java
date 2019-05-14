package co.ceiba.adn.domain.dao;

import java.util.List;

import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleType;


public interface ParkingConsult {
	
	/**
	 * Permite listar los tipos de vehiculos
	 * @return los tipos de vehiculos
	 */
	List<VehicleType> list();
	
	/**
	 * Permite listar todos los registros del parqueadero que no tengan registro de
	 * salida (aquellos que se encuentran parqueados aun)
	 * 
	 * @return los registros del parqueadero
	 */
	List<VehicleRegistration> listParked(long timeStamp);

}
