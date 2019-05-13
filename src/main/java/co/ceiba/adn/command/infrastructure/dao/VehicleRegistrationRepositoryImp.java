package co.ceiba.adn.command.infrastructure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.command.domain.dao.VehicleRegitrationRepository;
import co.ceiba.adn.command.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.command.domain.model.VehicleRegistration;

@Component
public class VehicleRegistrationRepositoryImp implements VehicleRegitrationRepository {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<VehicleRegistration> listParked() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VehicleRegistration> criteria = builder.createQuery(VehicleRegistration.class);
		Root<VehicleRegistration> root = criteria.from(VehicleRegistration.class);
		criteria.select(root).where(builder.equal(root.get("checkOutTimeStamp"), 0L));
		return entityManager.createQuery(criteria).getResultList();		
	}

	@Override
	public VehicleRegistration save(VehicleRegistration vehicleRegistration) throws VehicleRegistrationException {
        try(Session session = entityManager.unwrap(Session.class)){
        	session.persist(vehicleRegistration);
        	return vehicleRegistration;        	
        }catch (Exception ex){
            throw new VehicleRegistrationException("Error guardando el registro de entrada del vehiculo", ex);
        }
	}

}
