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

import co.edu.usbcali.banco.domain.TipoDocumento;

class TestTipoDocumentoJPA {

	Long tdocId = 4L;

	@Test
	@DisplayName("CrearTipoDocumento")
	void aTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, tdocId);
		assertNull(tipoDocumento, "El tipo de documento no es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Pasaporte");
		tipoDocumento.setActivo("S");
		tipoDocumento.setTdocId(tdocId);
		
		entityManager.getTransaction().begin();
			entityManager.persist(tipoDocumento);
		entityManager.getTransaction().commit();
	}
	
	@Test
	@DisplayName("ModificarTipoDocumento")
	void bTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Pasaporte otro");
		tipoDocumento.setActivo("N");
		tipoDocumento.setTdocId(tdocId);
		
		entityManager.getTransaction().begin();
			entityManager.merge(tipoDocumento);
		entityManager.getTransaction().commit();
	}
	
	@Test
	@DisplayName("BorrarTipoDocumento")
	void cTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		entityManager.getTransaction().begin();
			entityManager.remove(tipoDocumento);
		entityManager.getTransaction().commit();
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestClienteJPA.class);
	@Test
	@DisplayName("ConsultarTodos")
	void dTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-logic");
		assertNotNull(entityManagerFactory, "El entity manager factory es nulo");
		
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		assertNotNull(entityManager, "El entity manager es nulo");
		
		String JPQL = "SELECT tido FROM TipoDocumento tido";
		List<TipoDocumento> losTipoDocumentos = entityManager.createQuery(JPQL).getResultList();
		//List<Cliente> losClientes = entityManager.createNativeQuery(JPQL).getResultList();
		
		for (TipoDocumento tipoDocumentos : losTipoDocumentos) {
			log.info("Id:"+tipoDocumentos.getTdocId());
			log.info("Nombre:"+tipoDocumentos.getNombre());
		}
		
		losTipoDocumentos.forEach(tipoDocumentos->{
			log.info("Id:"+tipoDocumentos.getTdocId());
			log.info("Nombre:"+tipoDocumentos.getNombre());
		});
	}

}
