package co.ceiba.adn.integration;


import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.dao.ParkingConsult;
import co.ceiba.adn.domain.model.Vehicle;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleTypeRepositoryIntegrationTest {

    @Autowired
    private ParkingConsult vehicleRepository;

    @Test
    public void debeRetornarLosTiposDeVehiculos() {
        List<Vehicle> vehiculeTypes = vehicleRepository.list();
        assertFalse(vehiculeTypes.isEmpty());
    }
}