package co.ceiba.adn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.domain.exception.ConfigurationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckInBusinessRulesTest {
	
	@Autowired
	CheckInBusinessRules businessRules;

	
	@Test
	public void siTipoVehiculoEsIncorrectoEntoncesRetornaFalso() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().conTipoDeVehiculoErrado().build();
		assertFalse(businessRules.checkVehicleType(regitroVehiculo));
	}
	
	@Test
	public void siTipoVehiculoEsCorrectoEntoncesRetornaVerdadero() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().carro().build();
		assertTrue(businessRules.checkVehicleType(regitroVehiculo));
	}
	
	@Test
	public void siPlacaEmpiezaPorLaLetraConfiguradaYEsElDiaCorrectoEntoncesRetornaVerdadero() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaCorrecto().build();
		assertTrue(businessRules.checkVehiclePlate(registroVehiculo));
	}
	
	@Test
	public void siPlacaNoEmpiezaPorLaLetraConfiguradaRetornaVerdadero() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().build();
		assertTrue(businessRules.checkVehiclePlate(registroVehiculo));
	}
	
	@Test
	public void siPlacaEmpiezaPorLaLetraConfiguradaYNOEsElDiaCorrectoEntoncesRetornaFalso() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaIncorrecto().build();
		assertFalse(businessRules.checkVehiclePlate(registroVehiculo));
	}
	
	@Test
	public void siPlacaNOEmpiezaPorLaLetraConfiguradaYEsElDiaCorrectoEntoncesRetornaFalso() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().conDiaCorrecto().build();
		assertTrue(businessRules.checkVehiclePlate(registroVehiculo));
	}
	
	@Test
	public void debeRetornarValorCarros() throws ConfigurationException {
		assertTrue(businessRules.getMaxCars("20") > 0);
	}
	
	@Test
	public void debeRetornarValorMotos() throws ConfigurationException {
		assertTrue(businessRules.getMaxBikes("10") > 0);		
	}
	
	@Test(expected = ConfigurationException.class)
	public void debeRetornarExcepcion() throws ConfigurationException {
		businessRules.getMaxCars(null);
	}
	
	@Test(expected = ConfigurationException.class)
	public void debeRetornarExcepcions() throws ConfigurationException {
		businessRules.getMaxBikes(null);		
	}	
}
