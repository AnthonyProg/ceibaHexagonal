package co.ceiba.adn.infrastructure.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicletype")
public class VehicleEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "vehicle_type")
	private String type;
	
	@Column(name = "brand")
	String brand;
	
	@Column(name = "model")
	String model;
	
	@Column(name = "cubic_capacity")
	String cubicCapacity;
	
	public VehicleEntity() {}
	
	public VehicleEntity(String type) {
		this.type = type;
	}

	public VehicleEntity(String type, String brand, String model, String cubicCapacity) {
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.cubicCapacity = cubicCapacity;
	}

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getCubicCapacity() {
		return cubicCapacity;
	}	
}
