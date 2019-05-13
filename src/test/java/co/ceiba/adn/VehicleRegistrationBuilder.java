package co.ceiba.adn;

import co.ceiba.adn.command.domain.model.VehicleRegistration;
import co.ceiba.adn.consult.domain.model.VehicleType;

public class VehicleRegistrationBuilder {
	
	VehicleType tipoVehiculo = new VehicleType();
	long tiempoIngreso;
	long tiempoSalida;
	String placa = "";
	String modelo = "Cualquiera";
	String color = "Amarillo";
	String marca = "Toyota";
		
	public VehicleRegistrationBuilder conTipoDeVehiculoErrado() {
		VehicleType vehicleType = new VehicleType("AVION");
		this.tipoVehiculo = vehicleType;
		return this;
	}
	
	public VehicleRegistrationBuilder conTipoDeVehiculoCorrecto() {
		VehicleType vehicleType = new VehicleType("CARRO");
		this.tipoVehiculo = vehicleType;
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
		return new VehicleRegistration(tiempoIngreso, tiempoSalida, placa, marca,  modelo, color, tipoVehiculo);
	}
}
