package co.ceiba.adn.infrastructure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

@Repository
public interface VehicleRegistrationRepositoryJPA extends JpaRepository<VehicleRegistrationEntity, Long> {
	    
	public List<VehicleRegistrationEntity> findByStatus(int status);
		
}
