package co.ceiba.adn.domain.businessrules;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.RegistrationStatusEnum;
import co.ceiba.adn.domain.model.Vehicle;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleTypesEnum;

@Component
public class CheckInBusinessRules {
	
	@Autowired
	private Environment systemConfigurations;
	@Autowired
	private ParkingConsult parkingConsult;
	
	public void checkVehicleType(VehicleRegistration vehicleRegistration) {
		Optional<Vehicle> result = parkingConsult.list().stream().filter(s -> s.getDomainType()
				.equals(vehicleRegistration.getDomainVehicleType().getDomainType())).findFirst();
		if(!result.isPresent()) {
			throw new VehicleRegistrationException("tipo de vehiculo no permitido");
		}	
	}
	
	public void checkVehiclePlate(VehicleRegistration vehicleRegistration) {
		String letter = systemConfigurations.getProperty("config.letter");		
		int dayOfWeek = vehicleRegistration.getCheckIn().getDayOfWeek().getValue();		
		List<String> daysAllowed = Arrays.asList(systemConfigurations.getProperty("config.days").split(","));
		if(vehicleRegistration.getDomainVehiclePlate().startsWith(letter) && !daysAllowed.contains(String.valueOf(dayOfWeek))) {
			throw new VehicleRegistrationException("NO tiene permitido el ingreso.");
		}		 
	}
	
	public void checkAvailableSpace(VehicleRegistration vehicleRegistration){
		long occupied = getOccupiedPlaces(vehicleRegistration);
		int maxCars = Integer.parseInt(systemConfigurations.getProperty("config.max-cars"));
		int maxBikes = Integer.parseInt(systemConfigurations.getProperty("config.max-bikes"));
		if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal() 
				&& occupied >= maxCars) {
			throw new VehicleRegistrationException("Maximo de carros alcanzado");
		}
		if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal()
				&& occupied >= maxBikes) {
			throw new VehicleRegistrationException("Maximo de motos alcanzado");
		}		
	}
	
	public long getOccupiedPlaces(VehicleRegistration vehicleRegistration) {
		Vehicle vehicleType = vehicleRegistration.getDomainVehicleType();
		return parkingConsult.listParked(RegistrationStatusEnum.PARKED.ordinal()).stream().filter(type -> type.getDomainVehicleType().getDomainType().equals(vehicleType.getDomainType())).count();
	}
}
