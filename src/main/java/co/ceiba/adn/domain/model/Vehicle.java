package co.ceiba.adn.domain.model;

public class Vehicle {
	
	private long id;
	private String type;	
	private String brand;
	private String model;	
	private String cubicCapacity;
	
	public Vehicle() {}
	
	public Vehicle(String vehicleType) {
		this.type = vehicleType;
	}	
	
	public Vehicle(long id, String type, String brand, String model, String cubicCapacity) {
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.cubicCapacity = cubicCapacity;
	}

	public long getId() {
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
