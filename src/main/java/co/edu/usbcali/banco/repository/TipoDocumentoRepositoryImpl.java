package co.edu.usbcali.banco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.domain.TipoDocumento;

@Repository
@Scope("singleton")
public class TipoDocumentoRepositoryImpl implements TipoDocumentoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TipoDocumento tipoDocumento) {
		entityManager.persist(tipoDocumento);
	}

	@Override
	public void update(TipoDocumento tipoDocumento) {
		entityManager.merge(tipoDocumento);
	}

	@Override
	public void delete(TipoDocumento tipoDocumento) {
		entityManager.remove(tipoDocumento);
	}

	@Override
	public TipoDocumento findById(Long id) {
		return entityManager.find(TipoDocumento.class, id);
	}

	@Override
	public List<TipoDocumento> findAll() {
		return entityManager.createNamedQuery("TipoDocumento.findAll").getResultList();
	}

}
