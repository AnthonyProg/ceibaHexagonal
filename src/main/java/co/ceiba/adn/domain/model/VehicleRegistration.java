package co.ceiba.adn.domain.model;

import java.time.LocalDateTime;

public class VehicleRegistration {

	private long id;
	private LocalDateTime checkInTimeStamp;
	private LocalDateTime checkOutTimeStamp;
	private String vehiclePlate;
	private int status;
	private Vehicle vehicleType;
	
	public VehicleRegistration(long id, LocalDateTime checkInTimeStamp, LocalDateTime checkOutTimeStamp,
			String vehiclePlate, int status, Vehicle vehicleType) {		
		this.id = id;
		this.checkInTimeStamp = checkInTimeStamp;
		this.checkOutTimeStamp = checkOutTimeStamp;
		this.vehiclePlate = vehiclePlate;
		this.status = status;
		this.vehicleType = vehicleType;
	}
	public long getId() {
		return id;
	}
	public LocalDateTime getCheckInTimeStamp() {
		return checkInTimeStamp;
	}
	public LocalDateTime getCheckOutTimeStamp() {
		return checkOutTimeStamp;
	}
	public String getVehiclePlate() {
		return vehiclePlate;
	}
	public int getStatus() {
		return status;
	}
	public Vehicle getVehicleType() {
		return vehicleType;
	}	
}
