package co.ceiba.adn.domain.businessrules;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.exception.ConfigurationException;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleType;

@Component
public class CheckInBusinessRules {
	
	@Autowired
	private Environment systemConfigurations;
	@Autowired
	private ParkingConsult parkingConsult;
	
	public boolean checkVehicleType(VehicleRegistration vehicleRegistration) {
		return parkingConsult.list().contains(vehicleRegistration.getVehicleType());
	}
	
	public void checkVehiclePlate(VehicleRegistration vehicleRegistration) {
		String letter = systemConfigurations.getProperty("config.letter");		
		int dayOfWeek = Instant.ofEpochMilli(vehicleRegistration.getCheckInTimeStamp()).atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek().getValue();		
		List<String> daysAllowed = Arrays.asList(systemConfigurations.getProperty("config.days").split(","));
		if(vehicleRegistration.getVehiclePlate().startsWith(letter) && !daysAllowed.contains(String.valueOf(dayOfWeek))) {
			throw new VehicleRegistrationException("NO tiene permitido el ingreso.");
		}		 
	}
	
	public boolean checkAvailableSpace(VehicleRegistration vehicleRegistration){
		long occupied = getOccupiedPlaces(vehicleRegistration);		
		return getMaxCars(systemConfigurations.getProperty("config.max-cars")) != occupied || getMaxBikes(systemConfigurations.getProperty("config.max-bikes")) != occupied;
	}
	
	public int getMaxCars(String value) {
		try {
			return Integer.parseInt(value);
		}catch(Exception ex) {
			throw new ConfigurationException("Configuracion no disponible", ex);
		}		
	}
	
	public int getMaxBikes(String value) {
		try {
			return Integer.parseInt(value);
		}catch(Exception ex) {
			throw new ConfigurationException("Configuracion no disponible", ex);
		}		
	}
	
	public long getOccupiedPlaces(VehicleRegistration vehicleRegistration) {
		VehicleType vehicleType = vehicleRegistration.getVehicleType();
		return parkingConsult.listParked(0L).stream().filter(type -> type.getVehicleType().equals(vehicleType)).count();
	}
}
