package co.ceiba.adn.application.services;

import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.VehicleType;


@Component
public class ConsultVehicleTypesService {
	
	
	private ParkingConsult parkingConsult;
	
	public ConsultVehicleTypesService(ParkingConsult parkingConsult) {
		this.parkingConsult = parkingConsult;
	}
	
	public Iterable<VehicleType> loadAll(){
		return parkingConsult.list();
	}
}
