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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type)) {
			return false;
		}			
		return true;
	}
}
