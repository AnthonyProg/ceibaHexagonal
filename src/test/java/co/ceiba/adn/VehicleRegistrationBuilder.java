package co.ceiba.adn;

import co.ceiba.adn.domain.model.VehicleRegistration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import co.ceiba.adn.domain.model.Vehicle;

public class VehicleRegistrationBuilder {
	
	Vehicle tipoVehiculo = new Vehicle();
	LocalDateTime tiempoIngreso = LocalDateTime.now();
	LocalDateTime tiempoSalida;
	String placa = "";
	int status = 1;
		
	public VehicleRegistrationBuilder conTipoDeVehiculoErrado() {		
		this.tipoVehiculo = new Vehicle("AVION");
		return this;
	}
	
	public VehicleRegistrationBuilder moto() {		
		this.tipoVehiculo = new Vehicle("MOTO");
		return this;
	}
	
	public VehicleRegistrationBuilder carro() {		
		this.tipoVehiculo = new Vehicle("CARRO");
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
		this.tiempoIngreso = LocalDateTime.now();
		return this;
	}
	
	public VehicleRegistrationBuilder conDiaCorrecto() {		
		this.tiempoIngreso = LocalDateTime.now().minus(2, ChronoUnit.DAYS);
		return this;
	}	
	
	
	public VehicleRegistration build() {
		return new VehicleRegistration(0L, tiempoIngreso, tiempoSalida, placa , status , tipoVehiculo);
	}
}
