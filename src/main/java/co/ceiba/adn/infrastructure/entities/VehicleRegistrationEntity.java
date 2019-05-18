package co.ceiba.adn.infrastructure.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicleRegistration")
public class VehicleRegistrationEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	
	@Column(name = "check_in_time")	
	LocalDateTime checkInTimeStamp;	
	
	@Column(name = "check_out_time")
	LocalDateTime checkOutTimeStamp;
	
	@Column(name = "vehicle_plate")
	String vehiclePlate;
	
	@Column(name = "status")
	int status;
	
	@Column(name = "total_value")
	double totalValue;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vehicle_type")
	VehicleEntity vehicleType;
	
	public VehicleRegistrationEntity() {}

	public VehicleRegistrationEntity(LocalDateTime checkInTimeStamp, LocalDateTime checkOutTimeStamp,
			String vehiclePlate, int status, VehicleEntity vehicleType) {
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
	
	

	public void setCheckOutTimeStamp(LocalDateTime checkOutTimeStamp) {
		this.checkOutTimeStamp = checkOutTimeStamp;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public int getStatus() {
		return status;
	}
	
	

	public void setStatus(int status) {
		this.status = status;
	}

	public VehicleEntity getVehicleType() {
		return vehicleType;
	}	

	public void setVehicleType(VehicleEntity vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	
}
