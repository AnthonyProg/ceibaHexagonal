package co.ceiba.adn.consult.infrastructure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ceiba.adn.consult.domain.dao.VehicleTypeRepository;
import co.ceiba.adn.consult.domain.model.VehicleType;

@Component
public class VehicleTypeRepositoryImp implements VehicleTypeRepository {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<VehicleType> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VehicleType> criteria = builder.createQuery(VehicleType.class);
		Root<VehicleType> root = criteria.from(VehicleType.class);
		criteria.select(root);
		return entityManager.createQuery(criteria).getResultList();		
	}

}
