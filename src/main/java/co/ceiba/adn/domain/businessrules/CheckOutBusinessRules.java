package co.ceiba.adn.domain.businessrules;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleTypesEnum;

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
	private double maxHours;
		
	public void init() {
		try {
			hourValueCar = Double.parseDouble(systemConfigurations.getProperty("config.hour-value-car"));
			hourValueBike = Double.parseDouble(systemConfigurations.getProperty("config.hour-value-bike"));
			dayValueCar = Double.parseDouble(systemConfigurations.getProperty("dayValueCar"));
			dayValueBike = Double.parseDouble(systemConfigurations.getProperty("dayValueBike"));
			maxHours = Double.parseDouble(systemConfigurations.getProperty("config.maxHours"));
		}catch(Exception ex) {
			throw new VehicleRegistrationException("Error inicializando propiedades requeridas", ex);
		}
	}
	
	public VehicleRegistration checkIfRegistrationExists(long id){
		return parkingConsult.findRegistration(id);
	}
	
	public void calculateValueToPay(VehicleRegistration vehicleRegistration, LocalDateTime out) {
		LocalDateTime checkInTime = vehicleRegistration.getCheckIn();
		long hoursThatPassed = ChronoUnit.HOURS.between(checkInTime, out);
		long daysThatPaseed = ChronoUnit.DAYS.between(checkInTime, out);
		double total = 0;
		if(hoursThatPassed < maxHours) {
			if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal()) {
				total = hourValueCar * hoursThatPassed;
			}else if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.BIKE.ordinal()) {
				total = hourValueBike * hoursThatPassed;
			}
		}else if(daysThatPaseed == 0) {
			if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal()) {
				total = dayValueCar;
			}else if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.BIKE.ordinal()) {
				total = dayValueBike;
			}
		}else {
			if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal()) {
				total = (dayValueCar * daysThatPaseed) + (hourValueCar * hoursThatPassed);
			}else if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.BIKE.ordinal()) {
				total = (dayValueBike * daysThatPaseed) + (hourValueBike * hoursThatPassed);
			}
		}
		vehicleRegistration.setDomainValue(total);
	}
}
