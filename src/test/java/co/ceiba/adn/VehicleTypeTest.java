package co.ceiba.adn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.model.VehicleRegistration;
import co.ceiba.adn.infrastructure.entities.VehicleTypeEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleTypeTest {
	
	@Test
	public void siTipoDeVehiculoEsIgualEntoncesRetornaVerdadero() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity("MOTO");
		VehicleTypeEntity vehicleTypeEquals = new VehicleTypeEntity("MOTO");
		assertTrue(vehicleType.equals(vehicleTypeEquals));
	}
	
	@Test
	public void siTipoDeVehiculoNOEsIgualEntoncesRetornaFalso() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity("MOTO");
		VehicleTypeEntity vehicleTypeEquals = new VehicleTypeEntity("AVION");
		assertFalse(vehicleType.equals(vehicleTypeEquals));
	}
	
	@Test
	public void siSonElMismoObjetoRetornaVerdadero() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity("MOTO");
		assertTrue(vehicleType.equals(vehicleType));
	}
	
	@Test
	public void siEsNuloRetornaFalso() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity("MOTO");
		assertFalse(vehicleType.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void siElObjetoEsDeOtraClaseRetornaFalso() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity("MOTO");
		VehicleRegistration vehicleEquals = new VehicleRegistrationBuilder().build();
		assertFalse(vehicleType.equals(vehicleEquals));
	}
	
	@Test
	public void siElTypoEsNuloRetornaFalso() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity(null);
		VehicleTypeEntity vehicleTypeEquals = new VehicleTypeEntity("AVION");
		assertFalse(vehicleType.equals(vehicleTypeEquals));
	}
	
	
	@Test
	public void debeRetornarElHashCode() {
		VehicleTypeEntity vehicleType = new VehicleTypeEntity("MOTO");		
		assertTrue(vehicleType.hashCode() > 0);
	}
	

}
