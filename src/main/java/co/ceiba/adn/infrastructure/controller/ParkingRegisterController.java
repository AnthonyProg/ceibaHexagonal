package co.ceiba.adn.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.application.services.ParkingRegisterService;
import co.ceiba.adn.domain.model.VehicleRegistration;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ParkingRegisterController {
	
	@Autowired
	ParkingRegisterService parkingRegisterService;
	
	@PostMapping(value="/checkin")
    @ResponseBody
    public void checkInVehicle(@RequestBody VehicleRegistration vehicleRegistration) {
		parkingRegisterService.checkIn(vehicleRegistration);
    }
}
