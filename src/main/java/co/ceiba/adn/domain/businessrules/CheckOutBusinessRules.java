package co.ceiba.adn.domain.businessrules;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleTypesEnum;

@Component
public class CheckOutBusinessRules {

	
	private ParkingConsult parkingConsult;	
	private Environment systemConfigurations;
	private double hourValueCar;
	private double hourValueBike;
	private double dayValueCar;
	private double dayValueBike;
	private double maxHours;
	private double maxCubicCapacity;
	private double capacityFee;
	
	@Autowired
	public CheckOutBusinessRules(ParkingConsult parkingConsult, Environment config) {
		this.parkingConsult = parkingConsult;
		this.systemConfigurations = config;
		this.hourValueCar = Double.parseDouble(systemConfigurations.getProperty("config.hour-value-car"));
		this.hourValueBike = Double.parseDouble(systemConfigurations.getProperty("config.hour-value-bike"));
		this.dayValueCar = Double.parseDouble(systemConfigurations.getProperty("config.day-value-car"));
		this.dayValueBike = Double.parseDouble(systemConfigurations.getProperty("config.day-value-bike"));
		this.maxHours = Double.parseDouble(systemConfigurations.getProperty("config.maxHours"));
		this.maxCubicCapacity = Double.parseDouble(systemConfigurations.getProperty("config.maxCapacity"));
		this.capacityFee = Double.parseDouble(systemConfigurations.getProperty("config.extraCapacityFee"));		
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
		total += calculateExtraFee(total, vehicleRegistration);
		vehicleRegistration.setDomainValue(total);
	}
	
	private double calculateExtraFee(double value, VehicleRegistration vehicleRegistration) {
		int capacity = vehicleRegistration.getDomainVehicleType().getDomainCubicCapacity();
		if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.BIKE.ordinal()
				&& capacity > maxCubicCapacity) {
			return value + capacityFee;			
		}
		return 0;		
	}
}
