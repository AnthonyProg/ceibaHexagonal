package co.ceiba.adn.consult.domain.dao;

import java.util.List;

import co.ceiba.adn.consult.domain.model.VehicleType;


public interface VehicleTypeRepository {
	
	/**
	 * Permite listar los tipos de vehiculos
	 * @return los tipos de vehiculos
	 */
	List<VehicleType> list();

}
