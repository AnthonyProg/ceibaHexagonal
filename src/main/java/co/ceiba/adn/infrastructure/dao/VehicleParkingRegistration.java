package co.ceiba.adn.infrastructure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingRegitration;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.RegistrationStatusEnum;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.infrastructure.entities.VehicleEntity;
import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

@Component
public class VehicleParkingRegistration implements ParkingRegitration {
	
	private VehicleRegistrationRepositoryJPA vehiculeRegistrationRepository;
	private VehicleTypeRepositoryJPA vehicleTypeRepository;
	
	@Autowired
	public VehicleParkingRegistration(VehicleRegistrationRepositoryJPA vehiculeRegistrationRepository, VehicleTypeRepositoryJPA vehicleTypeRepository) {
		this.vehiculeRegistrationRepository = vehiculeRegistrationRepository;
		this.vehicleTypeRepository = vehicleTypeRepository;
	}

	@Override
	public void register(VehicleRegistration vehicleRegistration) {
		VehicleRegistrationEntity entity = Mapper.convertToEntityRegistration(vehicleRegistration);
		VehicleEntity vehicle = vehicleTypeRepository.findById(vehicleRegistration.getDomainVehicleType().getDomainTypeId())
				.orElseThrow(() -> new VehicleRegistrationException("Tipo de Vehiculo no encontrado"));
		entity.setVehicleType(vehicle);
		vehiculeRegistrationRepository.save(entity);		 
	}

	@Override
	public void update(VehicleRegistration vehicleRegistration) {
		VehicleRegistrationEntity entity = vehiculeRegistrationRepository.findById(vehicleRegistration.getDomainId());
		entity.setTotalValue(vehicleRegistration.getDomainValue());
		entity.setCheckOutTimeStamp(vehicleRegistration.getCheckOut());
		entity.setStatus(RegistrationStatusEnum.NOT_PARKED.ordinal());
		vehiculeRegistrationRepository.save(entity);
	}

}
