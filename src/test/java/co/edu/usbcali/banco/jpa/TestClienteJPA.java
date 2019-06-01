package co.edu.usbcali.banco.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;

class TestClienteJPA {
	
	long clienId = 142020L;

	@Test
	@DisplayName("CrearCliente")
	void aTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
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
		
		entityManager.getTransaction().begin();
			entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		//assertNotNull(null, "Es nulo");
		//fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("ModificarCliente")
	void bTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
		Cliente cliente = entityManager.find(Cliente.class, clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
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
		
		entityManager.getTransaction().begin();
			entityManager.merge(cliente);
		entityManager.getTransaction().commit();
	}
	
	@Test
	@DisplayName("BorrarCliente")
	void cTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
		Cliente cliente = entityManager.find(Cliente.class, clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		entityManager.getTransaction().begin();
			entityManager.remove(cliente);
		entityManager.getTransaction().commit();
	}
	
	/*private final static Logger log = LoggerFactory.getLogger(TestClienteJPA.class);
	@Test
	@DisplayName("ConsultarTodos")
	void dTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
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
