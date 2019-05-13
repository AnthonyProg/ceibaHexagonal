package co.ceiba.adn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.command.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.command.domain.model.VehicleRegistration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckInBusinessRulesTest {
	
	@Autowired
	CheckInBusinessRules businessRules;
	
	@Test
	public void siElRegistroEsCorrectoRetornaVerdadero() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaCorrecto().build();
		assertTrue(businessRules.applyBusinessRules(regitroVehiculo));
	}
	
	@Test
	public void siElRegistroEsInCorrectoRetornaFalso() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().conDiaCorrecto().build();
		assertFalse(businessRules.applyBusinessRules(regitroVehiculo));
	}
	
	@Test
	public void siTipoVehiculoEsIncorrectoEntoncesRetornaFalso() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().conTipoDeVehiculoErrado().build();
		assertFalse(businessRules.checkVehicleType(regitroVehiculo));
	}
	
	@Test
	public void siTipoVehiculoEsCorrectoEntoncesRetornaVerdadero() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().conTipoDeVehiculoCorrecto().build();
		assertTrue(businessRules.checkVehicleType(regitroVehiculo));
	}
	
	@Test
	public void siPlacaEmpiezaPorLaLetraConfiguradaYEsElDiaCorrectoEntoncesRetornaVerdadero() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaCorrecto().build();
		assertTrue(businessRules.checkVahiclePlate(registroVehiculo));
	}
	
	@Test
	public void siPlacaNoEmpiezaPorLaLetraConfiguradaRetornaVerdadero() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().build();
		assertTrue(businessRules.checkVahiclePlate(registroVehiculo));
	}
	
	@Test
	public void siPlacaEmpiezaPorLaLetraConfiguradaYNOEsElDiaCorrectoEntoncesRetornaFalso() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaCorrecta().conDiaIncorrecto().build();
		assertFalse(businessRules.checkVahiclePlate(registroVehiculo));
	}
	
	@Test
	public void siPlacaNOEmpiezaPorLaLetraConfiguradaYNOEsElDiaCorrectoEntoncesRetornaFalso() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().conDiaIncorrecto().build();
		assertFalse(businessRules.checkVahiclePlate(registroVehiculo));
	}
	
	
	
}
