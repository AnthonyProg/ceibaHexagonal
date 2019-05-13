package co.ceiba.adn.consult.application.manager;

import org.springframework.stereotype.Component;

import co.ceiba.adn.consult.domain.dao.VehicleTypeRepository;
import co.ceiba.adn.consult.domain.model.VehicleType;


@Component
public class ConsultVehicleTypesManager {
	
	
	private VehicleTypeRepository vehiculeTypesRepository;
	
	public ConsultVehicleTypesManager(VehicleTypeRepository vehiculeTypesRepository) {
		this.vehiculeTypesRepository = vehiculeTypesRepository;
	}
	
	public Iterable<VehicleType> loadAll(){
		return vehiculeTypesRepository.list();
	}
}
