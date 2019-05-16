package co.ceiba.adn.application.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.domain.businessrules.CheckOutBusinessRules;
import co.ceiba.adn.domain.dao.ParkingRegitration;
import co.ceiba.adn.domain.model.VehicleRegistration;

@Component
public class ParkingRegisterService {
	
	private CheckInBusinessRules checkInBusinessRules;
	private CheckOutBusinessRules checkOutBusinessRules;
	private ParkingRegitration parkingRegistration;
	
	public void checkIn(VehicleRegistration vehicleRegistration) {
		checkInBusinessRules.checkVehicleType(vehicleRegistration);
		checkInBusinessRules.checkVehiclePlate(vehicleRegistration);
		checkInBusinessRules.checkAvailableSpace(vehicleRegistration, checkInBusinessRules.getOccupiedPlaces(vehicleRegistration));
		parkingRegistration.register(vehicleRegistration);
	}
	
	public VehicleRegistration checkOut(long id, LocalDateTime out) {		
		VehicleRegistration registration = checkOutBusinessRules.checkIfRegistrationExists(id);
		checkOutBusinessRules.calculateValueToPay(registration, out);
		parkingRegistration.actualizar(registration);
		return registration;
	}
}
