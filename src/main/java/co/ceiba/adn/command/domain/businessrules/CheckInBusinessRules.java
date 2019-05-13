package co.ceiba.adn.command.domain.businessrules;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.command.domain.model.VehicleRegistration;
import co.ceiba.adn.consult.domain.dao.VehicleTypeRepository;

@Component
public class CheckInBusinessRules {
	
	@Autowired
	private Environment systemConfigurations;
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	public boolean applyBusinessRules(VehicleRegistration vehicleRegistration) throws Exception{
		return checkVehicleType(vehicleRegistration) && checkVahiclePlate(vehicleRegistration); 
	}
	
	public boolean checkVehicleType(VehicleRegistration vehicleRegistration) {
		return vehicleTypeRepository.list().contains(vehicleRegistration.getVehicleType());
	}
	
	public boolean checkVahiclePlate(VehicleRegistration vehicleRegistration) {
		String letter = systemConfigurations.getProperty("config.letter");		
		int dayOfWeek = Instant.ofEpochMilli(vehicleRegistration.getCheckInTimeStamp()).atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek().getValue();		
		List<String> daysAllowed = Arrays.asList(systemConfigurations.getProperty("config.days").split(","));
		if(!vehicleRegistration.getVehiclePlate().startsWith(letter)) {
			return true;
		}
		return vehicleRegistration.getVehiclePlate().startsWith(letter) && daysAllowed.contains(String.valueOf(dayOfWeek)); 
	}	
}
