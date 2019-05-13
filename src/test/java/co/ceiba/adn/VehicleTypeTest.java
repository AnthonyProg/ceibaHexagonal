package co.ceiba.adn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void debeRetornarElHashCode() {
		VehicleType vehicleType = new VehicleType("MOTO");		
		assertTrue(vehicleType.hashCode() > 0);
	}	

}
