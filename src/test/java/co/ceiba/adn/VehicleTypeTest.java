package co.ceiba.adn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.command.domain.model.VehicleRegistration;
import co.ceiba.adn.consult.domain.model.VehicleType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleTypeTest {
	
	@Test
	public void siTipoDeVehiculoEsIgualEntoncesRetornaVerdadero() {
		VehicleType vehicleType = new VehicleType("MOTO");
		VehicleType vehicleTypeEquals = new VehicleType("MOTO");
		assertTrue(vehicleType.equals(vehicleTypeEquals));
	}
	
	@Test
	public void siTipoDeVehiculoNOEsIgualEntoncesRetornaFalso() {
		VehicleType vehicleType = new VehicleType("MOTO");
		VehicleType vehicleTypeEquals = new VehicleType("AVION");
		assertFalse(vehicleType.equals(vehicleTypeEquals));
	}
	
	@Test
	public void siSonElMismoObjetoRetornaVerdadero() {
		VehicleType vehicleType = new VehicleType("MOTO");
		assertTrue(vehicleType.equals(vehicleType));
	}
	
	@Test
	public void siEsNuloRetornaFalso() {
		VehicleType vehicleType = new VehicleType("MOTO");
		assertFalse(vehicleType.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void siElObjetoEsDeOtraClaseRetornaFalso() {
		VehicleType vehicleType = new VehicleType("MOTO");
		VehicleRegistration vehicleEquals = new VehicleRegistrationBuilder().build();
		assertFalse(vehicleType.equals(vehicleEquals));
	}
	
	@Test
	public void siElTypoEsNuloRetornaFalso() {
		VehicleType vehicleType = new VehicleType(null);
		VehicleType vehicleTypeEquals = new VehicleType("AVION");
		assertFalse(vehicleType.equals(vehicleTypeEquals));
	}
	
	
	@Test
	public void debeRetornarElHashCode() {
		VehicleType vehicleType = new VehicleType("MOTO");		
		assertTrue(vehicleType.hashCode() > 0);
	}
	

}
