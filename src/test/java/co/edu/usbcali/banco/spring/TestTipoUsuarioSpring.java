package co.edu.usbcali.banco.spring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.TipoUsuario;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestTipoUsuarioSpring {
	
	@PersistenceContext
	EntityManager entityManager;
	
	Long tiusId = 4L;
	
	@DisplayName("CrearTipoUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(entityManager);
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, tiusId);
		assertNull(tipoUsuario, "El tipo de usuario no es nulo");
		
		tipoUsuario = new TipoUsuario();
		tipoUsuario.setNombre("Portero");
		tipoUsuario.setActivo("S");
		tipoUsuario.setTiusId(tiusId);
		
		entityManager.persist(tipoUsuario);
	}
	
	@DisplayName("ModificarTipoUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(entityManager);
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, tiusId);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		tipoUsuario = new TipoUsuario();
		tipoUsuario.setNombre("Portero dos");
		tipoUsuario.setActivo("N");
		tipoUsuario.setTiusId(tiusId);
		
		entityManager.merge(tipoUsuario);
	}
	
	@DisplayName("BorrarTipoUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(entityManager);
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, tiusId);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		entityManager.remove(tipoUsuario);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestClienteSpring.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(entityManager);
		
		String JPQL = "SELECT tius FROM TipoUsuario tius";
		List<TipoUsuario> losTipoUsuarios = entityManager.createQuery(JPQL).getResultList();
		
		for (TipoUsuario tipoUsuario : losTipoUsuarios) {
			log.info("Id:"+tipoUsuario.getTiusId());
			log.info("Nombre:"+tipoUsuario.getNombre());
		}
		
		losTipoUsuarios.forEach(tipoUsuario->{
			log.info("Id:"+tipoUsuario.getTiusId());
			log.info("Nombre:"+tipoUsuario.getNombre());
		});
	}

}
