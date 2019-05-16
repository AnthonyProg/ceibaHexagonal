package co.ceiba.adn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.businessrules.CheckOutBusinessRules;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckOutBusinessRulesTest {
	
	@Autowired
	private CheckOutBusinessRules businessRules;
	
	@Test(expected = VehicleRegistrationException.class)
	public void ifRegistrationDoesNotExistThenReturnsException() {
		businessRules.checkIfRegistrationExists(0);
	}
	
	@Test
	public void ifRegistrationExistThenReturnsTheRegistrationObject() {
		VehicleRegistration registration = businessRules.checkIfRegistrationExists(1);
		assertNotNull(registration);
		assertEquals(0 , registration.getDomainStatus());
	}

}
