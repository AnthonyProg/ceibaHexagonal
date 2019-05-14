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
public class VehicleTypeEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "vehicle_type")
	private String type;
	
	public VehicleTypeEntity() {}
		
	public VehicleTypeEntity(String type) {		
		this.type = type;
	}
	
	public VehicleTypeEntity(long id , String type) {		
		this.id = id;
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
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
		VehicleTypeEntity other = (VehicleTypeEntity) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type)) {
			return false;
		}			
		return true;
	}

	
}
