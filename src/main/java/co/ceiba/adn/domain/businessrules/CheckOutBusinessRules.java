package co.ceiba.adn.domain.businessrules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.VehicleRegistration;

@Component
public class CheckOutBusinessRules {

	@Autowired
	private ParkingConsult parkingConsult;
	
	public VehicleRegistration checkIfRegistrationExists(long id){
		return parkingConsult.findRegistration(id);
	}

}
