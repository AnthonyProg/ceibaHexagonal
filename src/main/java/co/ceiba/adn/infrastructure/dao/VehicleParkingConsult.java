package co.ceiba.adn.infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleType;

@Component
public class VehicleParkingConsult implements ParkingConsult {
	
	private VehicleRegistrationRepositoryJPA vehicleRegistrationRepository;
	
	private VehicleTypeRepositoryJPA vehicleTypeRepository;
	
	private Mapper mapper;
	
	@Autowired
	public VehicleParkingConsult(VehicleRegistrationRepositoryJPA vehicleRegistrationRepository, VehicleTypeRepositoryJPA vehicleTypeRepository) {
		this.vehicleRegistrationRepository = vehicleRegistrationRepository;
		this.vehicleTypeRepository = vehicleTypeRepository;
		this.mapper = new Mapper();
	}
	
	@Override
	public List<VehicleType> list() {		
		return mapper.converToDomainVehicleType(vehicleTypeRepository.findAll());
	}

	@Override
	public List<VehicleRegistration> listParked(long timeStamp) {		
		return mapper.converToDomainRegistrationType(vehicleRegistrationRepository.findByCheckOutTimeStamp(timeStamp));
	}
	


}
