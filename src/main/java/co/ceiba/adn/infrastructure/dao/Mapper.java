package co.ceiba.adn.infrastructure.dao;

import java.util.ArrayList;
import java.util.List;

import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleType;
import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;
import co.ceiba.adn.infrastructure.entities.VehicleTypeEntity;

public class Mapper {
	
	public List<VehicleType> converToDomainVehicleType(List<VehicleTypeEntity> vehicleTypeEntities){		
		List<VehicleType> returnedList = new ArrayList<>();
		for(VehicleTypeEntity entity : vehicleTypeEntities) {
			VehicleType vehicleType = new VehicleType(entity.getId(), entity.getType());			
			returnedList.add(vehicleType);
		}
		return returnedList;
	}
	
	public List<VehicleRegistration> converToDomainRegistrationType(List<VehicleRegistrationEntity> registrationEntities){		
		List<VehicleRegistration> returnedList = new ArrayList<>();
		for(VehicleRegistrationEntity entity : registrationEntities) {
			VehicleRegistration vehicleRegistration = 
					new VehicleRegistration(entity.getId(), entity.getCheckInTimeStamp(), entity.getCheckOutTimeStamp(),entity.getVehiclePlate(), entity.getBrand(), entity.getModel(), entity.getColor(), convertToDomainType(entity.getVehicleType()));
			returnedList.add(vehicleRegistration);
		}
		return returnedList;
	}
	
	public VehicleRegistrationEntity convertToEntityRegistration(VehicleRegistration vehicleRegistration) {
		return new VehicleRegistrationEntity(vehicleRegistration.getCheckInTimeStamp(), vehicleRegistration.getCheckOutTimeStamp()
				, vehicleRegistration.getVehiclePlate(), vehicleRegistration.getBrand(), vehicleRegistration.getModel(), vehicleRegistration.getColor(), convertToEntityType(vehicleRegistration.getVehicleType()));
	}
	
	public VehicleRegistration convertToDomainRegistration(VehicleRegistrationEntity vehicleRegistration) {		
		return new VehicleRegistration(vehicleRegistration.getId(), vehicleRegistration.getCheckInTimeStamp(), vehicleRegistration.getCheckOutTimeStamp()
				, vehicleRegistration.getVehiclePlate(), vehicleRegistration.getBrand(), vehicleRegistration.getModel(), vehicleRegistration.getColor(), convertToDomainType(vehicleRegistration.getVehicleType()));
	}
	
	public VehicleTypeEntity convertToEntityType(VehicleType vehicleType) {		
		return new VehicleTypeEntity(vehicleType.getId(), vehicleType.getType());
	}
	
	public VehicleType convertToDomainType(VehicleTypeEntity entity) {		
		return new VehicleType(entity.getId(), entity.getType());
	}

}
