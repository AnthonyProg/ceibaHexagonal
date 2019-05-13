package co.ceiba.adn.consult.domain.model;

public enum VehicleTypeEnum {	
	CAR,
	BIKE;
	
	@Override
	public String toString() {
	   switch(this) {
	     case CAR: return "CARRO";
	     case BIKE: return "MOTO";
	     default: throw new IllegalArgumentException();
	   }
	}
}
