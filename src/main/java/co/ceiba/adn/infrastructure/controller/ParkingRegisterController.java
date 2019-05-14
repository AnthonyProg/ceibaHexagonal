package co.ceiba.adn.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.application.services.ParkingRegisterService;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RestController
public class ParkingRegisterController {
	
	@Autowired
	ParkingRegisterService parkingRegisterManager;
	
	@PostMapping(value="/checkin")
    @ResponseBody
    public VehicleRegistration checkInVehicle(@RequestBody VehicleRegistration vehicleRegistration) throws VehicleRegistrationException {
        return parkingRegisterManager.checkIn(vehicleRegistration);
    }
}
