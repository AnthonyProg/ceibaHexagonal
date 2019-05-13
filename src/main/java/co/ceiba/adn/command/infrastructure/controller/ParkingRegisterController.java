package co.ceiba.adn.command.infrastructure.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.command.application.manager.ParkingRegisterManager;
import co.ceiba.adn.command.domain.model.Invoice;
import co.ceiba.adn.command.domain.model.VehicleRegistration;

@RestController
public class ParkingRegisterController {
	
	@Autowired
	ParkingRegisterManager parkingRegisterManager;
	
	@PostMapping(value="/checkin")
    @ResponseBody
    public VehicleRegistration checkInVehicle(@RequestBody VehicleRegistration vehicleRegistration) throws Exception {
        return parkingRegisterManager.checkIn(vehicleRegistration);
    }
	
	@PostMapping(value="/checkout")
    @ResponseBody
    public Invoice checkOutVehicle(@RequestBody Map<String, Long> map) {
        return parkingRegisterManager.checkOut(map.get("registrationId"));
    }

}