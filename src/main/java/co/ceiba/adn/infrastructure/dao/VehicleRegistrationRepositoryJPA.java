package co.ceiba.adn.infrastructure.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.adn.infrastructure.entities.VehicleRegistrationEntity;

@Repository
public interface VehicleRegistrationRepositoryJPA extends CrudRepository<VehicleRegistrationEntity, Long> {
	    
	public List<VehicleRegistrationEntity> findByStatus(int status);
	
	public VehicleRegistrationEntity findById(long id);
		
}
