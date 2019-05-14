package co.ceiba.adn.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.adn.infrastructure.entities.VehicleTypeEntity;

@Repository
public interface VehicleTypeRepositoryJPA extends JpaRepository<VehicleTypeEntity, Long> {

}
