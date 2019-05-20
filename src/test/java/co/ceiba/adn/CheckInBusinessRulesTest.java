package co.ceiba.adn;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.businessrules.CheckInBusinessRules;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckInBusinessRulesTest {
	
	@Autowired
	private CheckInBusinessRules businessRules;
	

	@Test
	public void debeRetornarElTotalDeCarrosParqueados() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().carro().build();
		assertTrue(businessRules.getOccupiedPlaces(regitroVehiculo) > 0);
	}
	
	@Test
	public void debeRetornarElTotalDeMotosParqueadas() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().moto().build();
		assertTrue(businessRules.getOccupiedPlaces(regitroVehiculo) > 0);
	}
	
	@Test(expected = VehicleRegistrationException.class)
	public void debeRetornarErrorSiNoHayMasEspacioParaMoto() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().moto().build();
		businessRules.checkAvailableSpace(regitroVehiculo, 10);
	}
	
	@Test(expected = VehicleRegistrationException.class)
	public void debeRetornarErrorSiNoHayMasEspacioParaCarro() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().carro().build();
		businessRules.checkAvailableSpace(regitroVehiculo, 20);
	}
	
	@Test
	public void siHayEspacioParaMotosContinua() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().motoMal().build();
		businessRules.checkAvailableSpace(regitroVehiculo, 5L);
	}
	
	@Test
	public void siHayEspacioParaCarrosContinua() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().carroMal().build();
		businessRules.checkAvailableSpace(regitroVehiculo, 8L);
	}
	
	
	@Test(expected = VehicleRegistrationException.class)
	public void siTipoVehiculoEsIncorrectoEntoncesRetornaError() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().conTipoDeVehiculoErrado().build();
		businessRules.checkVehicleType(regitroVehiculo);
	}
	
	@Test
	public void siTipoVehiculoEsCorrectoEntoncesNoRetornaError() {
		VehicleRegistration regitroVehiculo = new VehicleRegistrationBuilder().carro().build();
		businessRules.checkVehicleType(regitroVehiculo);
	}
	
	@Test
	public void siPlacaEmpiezaPorLaLetraConfiguradaYEsElDiaCorrectoEntoncesContinua() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().setDate("2019-05-13 12:30").build();
		businessRules.checkVehiclePlate(registroVehiculo);
	}
	
	@Test
	public void siPlacaNOEmpiezaPorLaLetraConfiguradaYNOEsElDiaCorrectoEntoncesContinua() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().setDate("2019-05-15 12:30").build();
		businessRules.checkVehiclePlate(registroVehiculo);
	}
	
	@Test
	public void siPlacaNOEmpiezaPorLaLetraConfiguradaEntoncesContinua() {
		VehicleRegistration registroVehiculo = new VehicleRegistrationBuilder().conPlacaErrada().build();
		businessRules.checkVehiclePlate(registroVehiculo);
	}
}
