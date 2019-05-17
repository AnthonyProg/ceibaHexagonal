package co.ceiba.adn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import co.ceiba.adn.domain.model.Vehicle;
import co.ceiba.adn.domain.model.VehicleRegistration;

public class VehicleRegistrationBuilder {
	
	Vehicle tipoVehiculo = new Vehicle();
	LocalDateTime tiempoIngreso = LocalDateTime.now();
	LocalDateTime tiempoSalida;
	String placa = "";
	int status = 1;
		
	public VehicleRegistrationBuilder conTipoDeVehiculoErrado() {		
		this.tipoVehiculo = new Vehicle(10,"AVION");
		return this;
	}
	
	public VehicleRegistrationBuilder moto() {		
		this.tipoVehiculo = new Vehicle(1,"MOTO");		
		return this;
	}
	
	public VehicleRegistrationBuilder carro() {		
		this.tipoVehiculo = new Vehicle(0,"CARRO");
		return this;
	}
	
	public VehicleRegistrationBuilder motoMal() {		
		this.tipoVehiculo = new Vehicle(3,"MOTO");		
		return this;
	}
	
	public VehicleRegistrationBuilder carroMal() {		
		this.tipoVehiculo = new Vehicle(4,"CARRO");
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
	
	public VehicleRegistrationBuilder setDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		this.tiempoIngreso = dateTime;
		return this;
	}
	
	public VehicleRegistrationBuilder setDateSalida(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		this.tiempoSalida = dateTime;
		return this;
	}
	
	public VehicleRegistration build() {
		return new VehicleRegistration(0L, tiempoIngreso, tiempoSalida, placa , status , tipoVehiculo);
	}
}
