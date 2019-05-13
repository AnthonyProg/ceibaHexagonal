package co.ceiba.adn;


import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.consult.domain.dao.VehicleTypeRepository;
import co.ceiba.adn.consult.domain.model.VehicleType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleTypeRepositoryIntegrationTest {

    @Autowired
    private VehicleTypeRepository vehicleRepository;

    @Test
    public void debeRetornarLosTiposDeVehiculos() {
        List<VehicleType> vehiculeTypes = vehicleRepository.list();
        assertFalse(vehiculeTypes.isEmpty());
    }
}