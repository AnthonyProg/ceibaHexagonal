package co.ceiba.adn.infrastructure.dao;

import java.util.List;
import java.util.stream.Collectors;

import co.ceiba.adn.domain.model.Vehicle;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.infrastructure.entities.VehicleEntity;
import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

public final class Mapper {
	
	
	private Mapper() {}
	
	public static List<Vehicle> converToDomainVehicleType(List<VehicleEntity> vehicleTypeEntities){		
		return vehicleTypeEntities.stream().map(Mapper::convertToDomainType).collect(Collectors.toList());
	}
	
	public static List<VehicleRegistration> converToDomainRegistrationType(List<VehicleRegistrationEntity> registrationEntities){		
		return registrationEntities.stream().map(Mapper::convertToDomainRegistration).collect(Collectors.toList());
	}
	
	public static VehicleRegistrationEntity convertToEntityRegistration(VehicleRegistration vehicleRegistration) {
		return new VehicleRegistrationEntity(vehicleRegistration.getCheckIn(), vehicleRegistration.getCheckOut()
				, vehicleRegistration.getDomainVehiclePlate(), vehicleRegistration.getDomainStatus(), convertToEntityType(vehicleRegistration.getDomainVehicleType()));
	}
	
	public static VehicleRegistration convertToDomainRegistration(VehicleRegistrationEntity vehicleRegistration) {		
		return new VehicleRegistration(vehicleRegistration.getId(), vehicleRegistration.getCheckInTimeStamp(), vehicleRegistration.getCheckOutTimeStamp()
				, vehicleRegistration.getVehiclePlate(), vehicleRegistration.getStatus(), convertToDomainType(vehicleRegistration.getVehicleType()));
	}
	
	public static VehicleEntity convertToEntityType(Vehicle vehicleType) {		
		return new VehicleEntity(vehicleType.getDomainType(), vehicleType.getDomainBrand(), vehicleType.getDomainModel(), vehicleType.getDomainCubicCapacity());
	}
	
	public static Vehicle convertToDomainType(VehicleEntity entity) {		
		return new Vehicle(entity.getId(), entity.getType(), entity.getBrand(), entity.getModel(), entity.getCubicCapacity());
	}

}
