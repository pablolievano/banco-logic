package co.edu.usbcali.banco.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestTipoDocumentoRepository {
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	Long tdocId = 4L;

	@DisplayName("CrearTipoDocumento")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(tipoDocumentoRepository);
		
		TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tdocId);
		assertNull(tipoDocumento, "El tipo de documento no es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Pasaporte");
		tipoDocumento.setActivo("S");
		tipoDocumento.setTdocId(tdocId);
		
		tipoDocumentoRepository.save(tipoDocumento);
	}
	
	@DisplayName("ModificarTipoDocumento")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(tipoDocumentoRepository);
		
		TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Pasaporte otro");
		tipoDocumento.setActivo("N");
		tipoDocumento.setTdocId(tdocId);
		
		tipoDocumentoRepository.update(tipoDocumento);
	}
	
	@DisplayName("BorrarTipoDocumento")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(tipoDocumentoRepository);
		
		TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		tipoDocumentoRepository.delete(tipoDocumento);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestTipoDocumentoRepository.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(tipoDocumentoRepository);
		
		List<TipoDocumento> losTipoDocumentos = tipoDocumentoRepository.findAll();
		
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
