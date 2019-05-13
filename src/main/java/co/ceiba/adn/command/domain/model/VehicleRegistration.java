package co.ceiba.adn.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.ceiba.adn.consult.domain.model.VehicleType;

@Entity
@Table(name = "vehicleRegistration")
public class VehicleRegistration {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	long id;
	
	@Column(name = "check_in_time")	
	long checkInTimeStamp;	
	
	@Column(name = "check_out_time")
	long checkOutTimeStamp;
	
	@Column(name = "vehicle_plate")
	String vehiclePlate;
	
	@Column(name = "brand")
	String brand;
	
	@Column(name = "model")
	String model;
	
	@Column(name = "color")
	String color;	
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vehicle_type")
	VehicleType vehicleType;
	
	
	
	public VehicleRegistration(long checkInTimeStamp, long checkOutTimeStamp, String vehiclePlate, String brand,
			String model, String color, VehicleType vehicleType) {		
		this.checkInTimeStamp = checkInTimeStamp;
		this.checkOutTimeStamp = checkOutTimeStamp;
		this.vehiclePlate = vehiclePlate;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.vehicleType = vehicleType;
	}

	public long getId() {
		return id;
	}

	public long getCheckInTimeStamp() {
		return checkInTimeStamp;
	}

	public long getCheckOutTimeStamp() {
		return checkOutTimeStamp;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
}