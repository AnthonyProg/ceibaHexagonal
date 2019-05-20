package co.ceiba.adn.domain.model;

import java.time.LocalDateTime;

public class VehicleRegistration {
	
	private long domainId;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private String domainVehiclePlate;
	private int domainStatus;
	private double domainValue;
	private Vehicle domainVehicleType;
	
	public VehicleRegistration() {
		
	}
	
	public VehicleRegistration(long domainId, LocalDateTime checkIn, LocalDateTime checkOut, String domainVehiclePlate,
			int domainStatus, Vehicle domainVehicleType) {
		this.domainId = domainId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.domainVehiclePlate = domainVehiclePlate;
		this.domainStatus = domainStatus;
		this.domainVehicleType = domainVehicleType;
	}

	public long getDomainId() {
		return domainId;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public String getDomainVehiclePlate() {
		return domainVehiclePlate;
	}

	public int getDomainStatus() {
		return domainStatus;
	}

	public Vehicle getDomainVehicleType() {
		return domainVehicleType;
	}

	public double getDomainValue() {
		return domainValue;
	}

	public void setDomainValue(double domainValue) {
		this.domainValue = domainValue;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}
	
	
	
	
}
