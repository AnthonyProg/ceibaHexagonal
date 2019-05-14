package co.ceiba.adn;

import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.domain.model.VehicleType;

public class VehicleRegistrationBuilder {
	
	VehicleType tipoVehiculo = new VehicleType();
	long tiempoIngreso;
	long tiempoSalida;
	String placa = "";
	String modelo = "Cualquiera";
	String color = "Amarillo";
	String marca = "Toyota";
		
	public VehicleRegistrationBuilder conTipoDeVehiculoErrado() {		
		this.tipoVehiculo = new VehicleType("AVION");
		return this;
	}
	
	public VehicleRegistrationBuilder moto() {		
		this.tipoVehiculo = new VehicleType("MOTO");;
		return this;
	}
	
	public VehicleRegistrationBuilder carro() {		
		this.tipoVehiculo = new VehicleType("CARRO");
		return this;
	}
	
	public VehicleRegistrationBuilder conPlacaErrada() {		
		this.placa = "BBBBBB";
		return this;
	}
	
	public VehicleRegistrationBuilder conPlacaCorrecta() {		
		this.placa = "AAAAAA";
		return this;
	}
	
	public VehicleRegistrationBuilder conDiaIncorrecto() {		
		this.tiempoIngreso = 1557530951000L;
		return this;
	}
	
	public VehicleRegistrationBuilder conDiaCorrecto() {		
		this.tiempoIngreso = 1557703751000L;
		return this;
	}	
	
	
	public VehicleRegistration build() {
		return new VehicleRegistration(0L, tiempoIngreso, tiempoSalida, placa, marca,  modelo, color, this.tipoVehiculo);
	}
}
