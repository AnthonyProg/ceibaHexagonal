package co.ceiba.adn.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.application.services.ConsultVehicleTypesService;
import co.ceiba.adn.domain.model.Vehicle;

@RestController
public class ConsultVehicleTypesController {
	
    @Autowired
    private ConsultVehicleTypesService vehiculesTypesManager;

    @RequestMapping(value="/types")
    @ResponseBody
    public Iterable<Vehicle> loadVehicleTypes() {
        return vehiculesTypesManager.loadAll();
    }

}
