package co.edu.usbcali.banco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.domain.Cliente;

@Repository
@Scope("singleton")
public class ClienteRepositoryImpl implements ClienteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Override
	public void update(Cliente cliente) {
		entityManager.merge(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		entityManager.remove(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> findAll() {
		return entityManager.createQuery("FROM Cliente cli").getResultList();
	}

}
