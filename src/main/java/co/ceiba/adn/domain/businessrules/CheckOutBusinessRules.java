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
	private static int fullDayHours = 24;
	
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
			total = calculateLessThanMaxHours(vehicleRegistration, hoursThatPassed);
		}else {
			total = calculateMoreThanMaxHours(vehicleRegistration, hoursThatPassed, daysThatPaseed);
		}
		total += calculateExtraFee(total, vehicleRegistration);
		vehicleRegistration.setDomainValue(total);
	}
	
	private double calculateLessThanMaxHours(VehicleRegistration vehicleRegistration, long hoursThatPassed) {
		if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal()) {
			return hoursThatPassed == 0 ? hourValueCar : hourValueCar * hoursThatPassed;
		}else if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.BIKE.ordinal()) {
			return hoursThatPassed == 0 ? hourValueBike : hourValueBike * hoursThatPassed;
		}
		return 0;
	}
	
	private double calculateMoreThanMaxHours(VehicleRegistration vehicleRegistration, long hoursThatPassed, long daysThatPaseed) {
		if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.CAR.ordinal()) {
			return daysThatPaseed == 0 ? dayValueCar : (dayValueCar * daysThatPaseed) + (hourValueCar * ( hoursThatPassed - (fullDayHours * daysThatPaseed)));
		}else if(vehicleRegistration.getDomainVehicleType().getDomainTypeId() == VehicleTypesEnum.BIKE.ordinal()) {
			return daysThatPaseed == 0 ? dayValueBike : (dayValueBike * daysThatPaseed) + (hourValueBike * (hoursThatPassed - (fullDayHours * daysThatPaseed)));
		}
		return 0;
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
