package co.ceiba.adn.domain.model;

public class VehicleRegistration {

	private long id;
	private long checkInTimeStamp;
	private long checkOutTimeStamp;
	private String vehiclePlate;
	private String brand;
	private String model;
	private String color;
	private VehicleType vehicleType;

	public VehicleRegistration(long id, long checkInTimeStamp, long checkOutTimeStamp, String vehiclePlate, String brand,
			String model, String color, VehicleType vehicleType) {
		this.id = id;
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
