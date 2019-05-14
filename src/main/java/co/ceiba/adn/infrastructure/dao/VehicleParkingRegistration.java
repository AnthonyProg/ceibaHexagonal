package co.ceiba.adn.infrastructure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingRegitration;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

@Component
public class VehicleParkingRegistration implements ParkingRegitration {
	
	private VehicleRegistrationRepositoryJPA vehiculeRegistrationRepository;
	
	private Mapper mapper;
	
	@Autowired
	public VehicleParkingRegistration(VehicleRegistrationRepositoryJPA vehiculeRegistrationRepository) {
		this.vehiculeRegistrationRepository = vehiculeRegistrationRepository;
		this.mapper = new Mapper();
	}

	@Override
	public VehicleRegistration register(VehicleRegistration vehicleRegistration) {
		VehicleRegistrationEntity entity = mapper.convertToEntityRegistration(vehicleRegistration);
		return mapper.convertToDomainRegistration(vehiculeRegistrationRepository.save(entity));		 
	}

}
