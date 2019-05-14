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
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
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
	public void siPlacaEmpiezaPorLaLetraConfiguradaYEsElDiaCorrectoEntoncesContinua() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaCorrecto().build();
		businessRules.checkVehiclePlate(registroVehiculo);
	}
	

	@Test(expected = VehicleRegistrationException.class)
	public void siPlacaEmpiezaPorLaLetraConfiguradaYNOEsElDiaCorrectoEntoncesRetornaError() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaIncorrecto().build();
		businessRules.checkVehiclePlate(registroVehiculo);
	}
	
	@Test
	public void siPlacaNOEmpiezaPorLaLetraConfiguradaEntoncesContinua() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().build();
		businessRules.checkVehiclePlate(registroVehiculo);
	}
	
	@Test
	public void debeRetornarValorCarros() {
		assertTrue(businessRules.getMaxCars("20") > 0);
	}
	
	@Test
	public void debeRetornarValorMotos() {
		assertTrue(businessRules.getMaxBikes("10") > 0);		
	}
	
	@Test(expected = ConfigurationException.class)
	public void debeRetornarExcepcion() {
		businessRules.getMaxCars(null);
	}
	
	@Test(expected = ConfigurationException.class)
	public void debeRetornarExcepcions() {
		businessRules.getMaxBikes(null);		
	}	
}
