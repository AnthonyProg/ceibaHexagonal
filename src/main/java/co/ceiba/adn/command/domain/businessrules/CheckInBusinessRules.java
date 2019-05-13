package co.ceiba.adn.command.domain.businessrules;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.command.domain.dao.VehicleRegitrationRepository;
import co.ceiba.adn.command.domain.model.VehicleRegistration;
import co.ceiba.adn.consult.domain.dao.VehicleTypeRepository;
import co.ceiba.adn.consult.domain.model.VehicleTypeEnum;

@Component
public class CheckInBusinessRules {
	
	@Autowired
	private Environment systemConfigurations;
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	@Autowired 	
	private VehicleRegitrationRepository registrationRepository;
	
	
	public void applyBusinessRules(VehicleRegistration vehicleRegistration) throws Exception{
		if(!checkVehicleType(vehicleRegistration) || !checkAvailableSpace(vehicleRegistration) || !checkVahiclePlate(vehicleRegistration)) {
			throw new Exception("Error validando reglas del negocio");
		}

	}
	
	public boolean checkVehicleType(VehicleRegistration vehicleRegistration) {
		return vehicleTypeRepository.list().contains(vehicleRegistration.getVehicleType());
	}
	
	public boolean checkAvailableSpace(VehicleRegistration vehicleRegistration) throws Exception {
		int maxCars = Integer.parseInt(systemConfigurations.getProperty("congig.max-cars"));
		int maxBikes = Integer.parseInt(systemConfigurations.getProperty("congig.max-bikes"));		
		long parkedCars = registrationRepository.listParked().stream().filter(type -> type.getVehicleType().getType().equals(VehicleTypeEnum.CAR.toString())).count();
		long parkedBikes = registrationRepository.listParked().stream().filter(type -> type.getVehicleType().getType().equals(VehicleTypeEnum.BIKE.toString())).count();
		if(vehicleRegistration.getVehicleType().getType().equals(VehicleTypeEnum.CAR.toString()) && parkedCars >= maxCars) {
			throw new Exception("No hay espacio para parquear mas Carros");			
		}else if(vehicleRegistration.getVehicleType().getType().equals(VehicleTypeEnum.BIKE.toString()) && parkedBikes >= maxBikes ) {
			throw new Exception("No hay espacio para parquear mas motos");				
		}
		return true;
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
