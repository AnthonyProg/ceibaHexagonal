package co.ceiba.adn.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.application.services.ParkingRegisterService;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RestController
public class ParkingCheckOutController {
	
	@Autowired
	ParkingRegisterService parkingRegisterManager;
	
	@PostMapping(value="/checkout")
    @ResponseBody
    public String checkOutVehicle(@RequestBody VehicleRegistration vehicleRegistration) {
        return parkingRegisterManager.checkOut( vehicleRegistration.getDomainId(), vehicleRegistration.getCheckOut());
    }

}
