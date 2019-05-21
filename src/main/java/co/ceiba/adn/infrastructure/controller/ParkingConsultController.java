package co.ceiba.adn.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.application.services.ParkingRegisterService;
import co.ceiba.adn.domain.model.VehicleRegistration;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ParkingConsultController {
	
	@Autowired
	ParkingRegisterService parkingRegisterService;
	
	@GetMapping(value="/parked")
    @ResponseBody
    public List<VehicleRegistration> listParked() {
        return parkingRegisterService.listParked();
    }
	
}
