package co.ceiba.adn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.consult.domain.model.VehicleTypeEnum;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleTypeEnumTest {
	
	@Test
	public void debeRetornarCarro() {
		assertEquals("CARRO", VehicleTypeEnum.CAR.toString());
	}
	
	@Test
	public void debeRetornarMoto() {
		assertEquals("MOTO", VehicleTypeEnum.BIKE.toString());
	}
}
