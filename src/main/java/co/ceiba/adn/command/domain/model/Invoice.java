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

@Entity
@Table(name = "vehicletype")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vehicle_r_id")
	VehicleRegistration vehicleRegistration;
	
	double amount;

	public long getId() {
		return id;
	}

	public VehicleRegistration getVehicleRegistration() {
		return vehicleRegistration;
	}

	public double getAmount() {
		return amount;
	}
	
	
	

}
