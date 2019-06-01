package co.edu.usbcali.banco.spring;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
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
import co.edu.usbcali.banco.domain.Usuario;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestUsuarioSpring {

	@PersistenceContext
	EntityManager entityManager;
	
	String usuUsuario = "usuario_pruebas";
	BigDecimal identificacion = new BigDecimal("12371");
	
	@DisplayName("CrearUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(entityManager);
		
		Usuario usuario = entityManager.find(Usuario.class, usuUsuario);
		assertNull(usuario, "El usuario no es nulo");
		
		usuario = new Usuario();
		usuario.setActivo("S");
		usuario.setUsuUsuario(usuUsuario);
		usuario.setClave("Wer234wR");
		usuario.setNombre("Usuario de pruebas 500");
		usuario.setIdentificacion(identificacion);
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, 2L);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		usuario.setTipoUsuario(tipoUsuario);
		
		entityManager.persist(usuario);
	}
	
	@DisplayName("ModificarUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(entityManager);
		
		Usuario usuario = entityManager.find(Usuario.class, usuUsuario);
		assertNotNull(usuario, "El usuario es nulo");
		
		usuario = new Usuario();
		usuario.setActivo("N");
		usuario.setUsuUsuario(usuUsuario);
		usuario.setClave("Wer234");
		usuario.setNombre("Usuario de pruebas");
		usuario.setIdentificacion(identificacion);

		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, 2L);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		usuario.setTipoUsuario(tipoUsuario);
		
		entityManager.merge(usuario);
	}
	
	@DisplayName("BorrarCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(entityManager);
		
		Usuario usuario = entityManager.find(Usuario.class, usuUsuario);
		assertNotNull(usuario, "El usaurio es nulo");
		
		entityManager.remove(usuario);
	}
	
	/*private final static Logger log = LoggerFactory.getLogger(TestClienteSpring.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(entityManager);
		
		String JPQL = "SELECT usu FROM Usuario usu";
		List<Usuario> losUsuarios = entityManager.createQuery(JPQL).getResultList();
		
		for (Usuario usuario : losUsuarios) {
			log.info("Usuario:"+usuario.getUsuUsuario());
			log.info("Nombre:"+usuario.getNombre());
		}
		
		losUsuarios.forEach(usuario->{
			log.info("Usuario:"+usuario.getUsuUsuario());
			log.info("Nombre:"+usuario.getNombre());
		});
	}*/

}
