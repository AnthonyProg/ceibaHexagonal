package co.ceiba.adn.application.services;

import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.domain.dao.ParkingRegitration;
import co.ceiba.adn.domain.model.VehicleRegistration;

@Component
public class ParkingRegisterService {
	
	CheckInBusinessRules checkInBusinessRules;	
	ParkingRegitration parkingRegistration;
	
	public void checkIn(VehicleRegistration vehicleRegistration) {
		checkInBusinessRules.checkVehicleType(vehicleRegistration);
		checkInBusinessRules.checkVehiclePlate(vehicleRegistration);
		checkInBusinessRules.checkAvailableSpace(vehicleRegistration);
		parkingRegistration.register(vehicleRegistration);
	}
}
