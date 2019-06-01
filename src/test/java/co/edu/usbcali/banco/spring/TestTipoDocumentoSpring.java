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

import co.edu.usbcali.banco.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestTipoDocumentoSpring {
	
	@PersistenceContext
	EntityManager entityManager;
	
	Long tdocId = 4L;

	@DisplayName("CrearTipoDocumento")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(entityManager);
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, tdocId);
		assertNull(tipoDocumento, "El tipo de documento no es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Pasaporte");
		tipoDocumento.setActivo("S");
		tipoDocumento.setTdocId(tdocId);
		
		entityManager.persist(tipoDocumento);
	}
	
	@DisplayName("ModificarTipoDocumento")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(entityManager);
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Pasaporte otro");
		tipoDocumento.setActivo("N");
		tipoDocumento.setTdocId(tdocId);
		
		entityManager.merge(tipoDocumento);
	}
	
	@DisplayName("BorrarTipoDocumento")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(entityManager);
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		entityManager.remove(tipoDocumento);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestClienteSpring.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(entityManager);
		
		String JPQL = "SELECT tido FROM TipoDocumento tido";
		List<TipoDocumento> losTipoDocumentos = entityManager.createQuery(JPQL).getResultList();
		
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
