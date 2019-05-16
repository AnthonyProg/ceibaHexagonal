package co.ceiba.adn.domain.businessrules;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

@Component
public class CheckOutBusinessRules {

	@Autowired
	private ParkingConsult parkingConsult;	
	@Autowired
	private Environment systemConfigurations;
	private double hourValueCar;
	private double hourValueBike;
	private double dayValueCar;
	private double dayValueBike;
		
	public void init() {
		try {
			hourValueCar = Double.parseDouble(systemConfigurations.getProperty("config.hour-value-car"));
			hourValueBike = Double.parseDouble(systemConfigurations.getProperty("config.hour-value-bike"));
			dayValueCar = Double.parseDouble(systemConfigurations.getProperty("dayValueCar"));
			dayValueBike = Double.parseDouble(systemConfigurations.getProperty("dayValueBike"));
		}catch(Exception ex) {
			throw new VehicleRegistrationException("Error inicializando propiedades requeridas", ex);
		}

	}
	
	public VehicleRegistration checkIfRegistrationExists(long id){
		return parkingConsult.findRegistration(id);
	}
}
