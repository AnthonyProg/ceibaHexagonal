package co.ceiba.adn.infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.Vehicle;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

@Component
public class VehicleParkingConsult implements ParkingConsult {
	
	private VehicleRegistrationRepositoryJPA vehicleRegistrationRepository;
	
	private VehicleTypeRepositoryJPA vehicleTypeRepository;
	
	@Autowired
	public VehicleParkingConsult(VehicleRegistrationRepositoryJPA vehicleRegistrationRepository, VehicleTypeRepositoryJPA vehicleTypeRepository) {
		this.vehicleRegistrationRepository = vehicleRegistrationRepository;
		this.vehicleTypeRepository = vehicleTypeRepository;
	}
	
	@Override
	public List<Vehicle> list() {		
		return Mapper.converToDomainVehicleType(vehicleTypeRepository.findAll());
	}

	@Override
	public List<VehicleRegistration> listParked(int status) {		
		return Mapper.converToDomainRegistrationType(vehicleRegistrationRepository.findByStatus(status));
	}

	@Override
	public VehicleRegistration findRegistration(long id) {
		VehicleRegistrationEntity vehicleRegistration = vehicleRegistrationRepository.findById(id);
		if(vehicleRegistration == null) {
			throw new VehicleRegistrationException("Registro no encontrado");
		}
		return Mapper.convertToDomainRegistration(vehicleRegistration);
	}

}
