package co.ceiba.adn.domain.businessrules;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.exception.ConfigurationException;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.RegistrationStatusEnum;
import co.ceiba.adn.domain.model.Vehicle;
import co.ceiba.adn.domain.model.VehicleRegistration;

@Component
public class CheckInBusinessRules {
	
	@Autowired
	private Environment systemConfigurations;
	@Autowired
	private ParkingConsult parkingConsult;
	
	public void checkVehicleType(VehicleRegistration vehicleRegistration) {
		if(!parkingConsult.list().contains(vehicleRegistration.getVehicleType())) {
			throw new VehicleRegistrationException("Tipo de Vehiculo no permitido");
		}
	}
	
	public void checkVehiclePlate(VehicleRegistration vehicleRegistration) {
		String letter = systemConfigurations.getProperty("config.letter");		
		int dayOfWeek = vehicleRegistration.getCheckInTimeStamp().getDayOfWeek().getValue();		
		List<String> daysAllowed = Arrays.asList(systemConfigurations.getProperty("config.days").split(","));
		if(vehicleRegistration.getVehiclePlate().startsWith(letter) && !daysAllowed.contains(String.valueOf(dayOfWeek))) {
			throw new VehicleRegistrationException("NO tiene permitido el ingreso.");
		}		 
	}
	
	public void checkAvailableSpace(VehicleRegistration vehicleRegistration){
		long occupied = getOccupiedPlaces(vehicleRegistration);		
		
	}
	
	public int getMaxCars() {
		if(systemConfigurations.getProperty("config.max-cars") == null) {
			throw new ConfigurationException("Configuracion no disponible");
		}
		return Integer.parseInt(systemConfigurations.getProperty("config.max-cars"));
	}
	
	public int getMaxBikes() {
		if(systemConfigurations.getProperty("config.max-bikes") == null) {
			throw new ConfigurationException("Configuracion no disponible");
		}
		return Integer.parseInt(systemConfigurations.getProperty("config.max-bikes"));		
	}
	
	public long getOccupiedPlaces(VehicleRegistration vehicleRegistration) {
		Vehicle vehicleType = vehicleRegistration.getVehicleType();
		return parkingConsult.listParked(RegistrationStatusEnum.PARKED.ordinal()).stream().filter(type -> type.getVehicleType().equals(vehicleType)).count();
	}
}
