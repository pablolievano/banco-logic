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

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestClienteSpring {
	
	@PersistenceContext
	EntityManager entityManager;
	
	long clienId = 142020L;
	
	@DisplayName("CrearCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(entityManager);
		
		Cliente cliente = entityManager.find(Cliente.class, clienId);
		assertNull(cliente, "El cliente no es nulo");
		
		cliente = new Cliente();
		cliente.setActivo("N");
		cliente.setClieId(clienId);
		cliente.setDireccion("Avenida siempre viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero Jay Thompson");
		cliente.setTelefono("123456");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, 1L);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.persist(cliente);
	}
	
	@DisplayName("ModificarCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(entityManager);
		
		Cliente cliente = entityManager.find(Cliente.class, clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		cliente.setActivo("S");
		cliente.setClieId(clienId);
		cliente.setDireccion("Avenida siempre viva 123 456");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero Jay Simpson");
		cliente.setTelefono("123456");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, 2L);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.merge(cliente);
	}
	
	@DisplayName("BorrarCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(entityManager);
		
		Cliente cliente = entityManager.find(Cliente.class, clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		entityManager.remove(cliente);
	}
	
	/*private final static Logger log = LoggerFactory.getLogger(TestClienteSpring.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(entityManager);
		
		String JPQL = "SELECT cli FROM Cliente cli";
		List<Cliente> losClientes = entityManager.createQuery(JPQL).getResultList();
		//List<Cliente> losClientes = entityManager.createNativeQuery(JPQL).getResultList();
		
		for (Cliente cliente : losClientes) {
			log.info("Id:"+cliente.getClieId());
			log.info("Nombre:"+cliente.getNombre());
			//System.out.println(cliente.getNombre());
		}
		
		losClientes.forEach(cliente->{
			log.info("Id:"+cliente.getClieId());
			log.info("Nombre:"+cliente.getNombre());
			//System.out.println(cliente.getNombre());
		});
	}*/

}
