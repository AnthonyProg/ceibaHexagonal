package co.ceiba.adn.domain.model;

public class VehicleType {
	
	long id;
	String type;
	
	public VehicleType(String vehicleType) {
		this.type = vehicleType;
	}
	
	public VehicleType(long id, String vehicleType) {
		this.id = id;
		this.type = vehicleType;
	}

	public VehicleType() {}
	
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
		VehicleType other = (VehicleType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type)) {
			return false;
		}			
		return true;
	}



	public long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	
}
