package co.ceiba.adn.command.application.manager;

import org.springframework.stereotype.Component;

import co.ceiba.adn.command.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.command.domain.dao.VehicleRegitrationRepository;
import co.ceiba.adn.command.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.command.domain.model.VehicleRegistration;

@Component
public class ParkingRegisterManager {
	
	CheckInBusinessRules checkInBusinessRules;	
	VehicleRegitrationRepository vehicleRegistrationRepository;
	
	public VehicleRegistration checkIn(VehicleRegistration vehicleRegistration) throws VehicleRegistrationException {
		checkInBusinessRules.applyBusinessRules(vehicleRegistration);
		return vehicleRegistrationRepository.save(vehicleRegistration);
	}
}
