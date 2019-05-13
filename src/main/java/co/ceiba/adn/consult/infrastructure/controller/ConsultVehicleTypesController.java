package co.ceiba.adn.consult.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.adn.consult.application.manager.ConsultVehicleTypesManager;
import co.ceiba.adn.consult.domain.model.VehicleType;

@RestController
public class ConsultVehicleTypesController {
	
    @Autowired
    private ConsultVehicleTypesManager vehiculesTypesManager;

    @RequestMapping(value="/types")
    @ResponseBody
    public Iterable<VehicleType> loadVehicleTypes() {
        return vehiculesTypesManager.loadAll();
    }

}
