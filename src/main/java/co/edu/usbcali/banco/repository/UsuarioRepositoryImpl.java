package co.edu.usbcali.banco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.domain.Usuario;

@Repository
@Scope("singleton")
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		entityManager.remove(usuario);
	}

	@Override
	public Usuario findById(String usuUsuario) {
		return entityManager.find(Usuario.class, usuUsuario);
	}

	@Override
	public List<Usuario> findAll() {
		return entityManager.createQuery("FROM Usuario usu").getResultList();
	}

}
