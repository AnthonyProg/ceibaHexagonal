package co.ceiba.adn.command.application.manager;

import org.springframework.stereotype.Component;

import co.ceiba.adn.command.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.command.domain.businessrules.CheckOutBusinessRules;
import co.ceiba.adn.command.domain.dao.VehicleRegitrationRepository;
import co.ceiba.adn.command.domain.model.Invoice;
import co.ceiba.adn.command.domain.model.VehicleRegistration;

@Component
public class ParkingRegisterManager {
	
	CheckInBusinessRules checkInBusinessRules;
	CheckOutBusinessRules checkOutBusinessRules;
	VehicleRegitrationRepository vehicleRegistrationRepository;
	
	public VehicleRegistration checkIn(VehicleRegistration vehicleRegistration) throws Exception {
		checkInBusinessRules.applyBusinessRules(vehicleRegistration);
		return vehicleRegistrationRepository.save(vehicleRegistration);
	}
	
	public Invoice checkOut(Long registrationId) {
		return null;
	}
	
}
