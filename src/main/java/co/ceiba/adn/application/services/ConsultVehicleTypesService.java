package co.ceiba.adn.application.services;

import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.Vehicle;


@Component
public class ConsultVehicleTypesService {
	
	
	private ParkingConsult parkingConsult;
	
	public ConsultVehicleTypesService(ParkingConsult parkingConsult) {
		this.parkingConsult = parkingConsult;
	}
	
	public Iterable<Vehicle> loadAll(){
		return parkingConsult.list();
	}
}
