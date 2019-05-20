package co.ceiba.adn.application.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.domain.businessrules.CheckOutBusinessRules;
import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.dao.ParkingRegitration;
import co.ceiba.adn.domain.model.RegistrationStatusEnum;
import co.ceiba.adn.domain.model.VehicleRegistration;

@Component
public class ParkingRegisterService {
	
	private CheckInBusinessRules checkInBusinessRules;
	private CheckOutBusinessRules checkOutBusinessRules;
	private ParkingRegitration parkingRegistration;
	private ParkingConsult parkingConsult;
	
	@Autowired
	public ParkingRegisterService(CheckInBusinessRules checkInBusinessRules, CheckOutBusinessRules checkOutBusinessRules,ParkingRegitration parkingRegistration,
			ParkingConsult parkingConsult) {
		this.checkInBusinessRules = checkInBusinessRules;
		this.checkOutBusinessRules = checkOutBusinessRules;
		this.parkingRegistration = parkingRegistration;
		this.parkingConsult = parkingConsult;
	}
	
	public void checkIn(VehicleRegistration vehicleRegistration) {
		checkInBusinessRules.checkVehicleType(vehicleRegistration);
		checkInBusinessRules.checkVehiclePlate(vehicleRegistration);
		checkInBusinessRules.checkAvailableSpace(vehicleRegistration, checkInBusinessRules.getOccupiedPlaces(vehicleRegistration));
		parkingRegistration.register(vehicleRegistration);
	}
	
	public String checkOut(long id, LocalDateTime out) {		
		VehicleRegistration registration = checkOutBusinessRules.checkIfRegistrationExists(id);
		registration.setCheckOut(out);
		checkOutBusinessRules.calculateValueToPay(registration, out);
		parkingRegistration.update(registration);
		return String.valueOf(registration.getDomainValue());
	}
	
	public List<VehicleRegistration> listParked(){
		return parkingConsult.listParked(RegistrationStatusEnum.PARKED.ordinal());
	}
}
