package co.ceiba.adn.command.domain.businessrules;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.command.domain.dao.VehicleRegitrationRepository;
import co.ceiba.adn.command.domain.exception.ConfigurationException;
import co.ceiba.adn.command.domain.model.VehicleRegistration;
import co.ceiba.adn.consult.domain.dao.VehicleTypeRepository;
import co.ceiba.adn.consult.domain.model.VehicleType;

@Component
public class CheckInBusinessRules {
	
	@Autowired
	private Environment systemConfigurations;
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	@Autowired
	private VehicleRegitrationRepository registrationRepository;
	
	public boolean applyBusinessRules(VehicleRegistration vehicleRegistration){
		return checkVehicleType(vehicleRegistration) && checkVehiclePlate(vehicleRegistration); 
	}
	
	public boolean checkVehicleType(VehicleRegistration vehicleRegistration) {
		return vehicleTypeRepository.list().contains(vehicleRegistration.getVehicleType());
	}
	
	public boolean checkVehiclePlate(VehicleRegistration vehicleRegistration) {
		String letter = systemConfigurations.getProperty("config.letter");		
		int dayOfWeek = Instant.ofEpochMilli(vehicleRegistration.getCheckInTimeStamp()).atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek().getValue();		
		List<String> daysAllowed = Arrays.asList(systemConfigurations.getProperty("config.days").split(","));
		if(!vehicleRegistration.getVehiclePlate().startsWith(letter)) {
			return true;
		}
		return vehicleRegistration.getVehiclePlate().startsWith(letter) && daysAllowed.contains(String.valueOf(dayOfWeek)); 
	}
	
	public boolean checkAvailableSpace(VehicleRegistration vehicleRegistration) throws ConfigurationException{
		long occupied = getOccupiedPlaces(vehicleRegistration);		
		return getMaxCars() != occupied || getMaxBikes() != occupied;
	}
	
	public int getMaxCars() throws ConfigurationException {
		try {
			return Integer.parseInt(systemConfigurations.getProperty("config.max-cars"));
		}catch(Exception ex) {
			throw new ConfigurationException("Configuracion no disponible en el archivo application.properties", ex);
		}		
	}
	
	public int getMaxBikes() throws ConfigurationException {
		try {
			return Integer.parseInt(systemConfigurations.getProperty("config.max-bikes"));
		}catch(Exception ex) {
			throw new ConfigurationException("Configuracion no disponible en el archivo application.properties", ex);
		}		
	}
	
	public long getOccupiedPlaces(VehicleRegistration vehicleRegistration) {
		VehicleType vehicleType = vehicleRegistration.getVehicleType();
		return registrationRepository.listParked().stream().filter(type -> type.getVehicleType().equals(vehicleType)).count();
	}
}
