package co.ceiba.adn.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.application.services.ParkingRegisterService;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RestController
public class ParkingConsultController {
	
	@Autowired
	ParkingRegisterService parkingRegisterService;
	
	@PostMapping(value="/parked")
    @ResponseBody
    public List<VehicleRegistration> listParked() {
        return parkingRegisterService.listParked();
    }
	
}
