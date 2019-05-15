package co.ceiba.adn;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleRegitrationRepositoryIntTest {
	
	@Autowired
	ParkingConsult parkingConsult;
	
    @Test
    public void debeRetornarLosVehiculosParqueados() {
        List<VehicleRegistration> vehiculosParqueados = parkingConsult.listParked(1);
        assertFalse(vehiculosParqueados.isEmpty());
    }

}
