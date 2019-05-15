package co.ceiba.adn.infrastructure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingRegitration;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

@Component
public class VehicleParkingRegistration implements ParkingRegitration {
	
	private VehicleRegistrationRepositoryJPA vehiculeRegistrationRepository;
	
	@Autowired
	public VehicleParkingRegistration(VehicleRegistrationRepositoryJPA vehiculeRegistrationRepository) {
		this.vehiculeRegistrationRepository = vehiculeRegistrationRepository;
	}

	@Override
	public void register(VehicleRegistration vehicleRegistration) {
		VehicleRegistrationEntity entity = Mapper.convertToEntityRegistration(vehicleRegistration);
		vehiculeRegistrationRepository.save(entity);		 
	}

}
