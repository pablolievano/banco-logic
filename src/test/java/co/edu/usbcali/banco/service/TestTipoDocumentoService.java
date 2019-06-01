package co.edu.usbcali.banco.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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

import co.edu.usbcali.banco.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTipoDocumentoService {
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	Long tdocId = 4L;
	
	@DisplayName("CrearTipoDocumento")
	@Test
	void aTest()throws Exception {
		assertNotNull(tipoDocumentoService);
		
		TipoDocumento tipoDocumento = tipoDocumentoService.findById(tdocId);
		assertNull(tipoDocumento, "El tipo de documento es nulo");
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setActivo("S");
		tipoDocumento.setTdocId(tdocId);
		tipoDocumento.setNombre("Tipo de documento de prueba");
		
		tipoDocumentoService.save(tipoDocumento);
	}
	
	@DisplayName("ModificarTipoDocumento")
	@Test
	void bTest() throws Exception {
		assertNotNull(tipoDocumentoService);
		
		TipoDocumento tipoDocumento = tipoDocumentoService.findById(tdocId);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		tipoDocumento.setActivo("N");
		tipoDocumento.setTdocId(tdocId);
		tipoDocumento.setNombre("Tipo de prueba");
		
		tipoDocumentoService.update(tipoDocumento);
	}
	
	@DisplayName("BorrarTipoDocumento")
	@Test
	void cTest()throws Exception {
		assertNotNull(tipoDocumentoService);
		
		TipoDocumento tipoDocumento = tipoDocumentoService.findById(tdocId);
		assertNotNull(tipoDocumento, "El Tipo de documento es nulo");
		
		tipoDocumentoService.delete(tipoDocumento);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestTipoDocumentoService.class);
	@DisplayName("ConsultarTodos")
	@Test
	void dTest() {
		assertNotNull(tipoDocumentoService);
		
		List<TipoDocumento> losTipoDocumentos = tipoDocumentoService.findAll();
		
		for (TipoDocumento tipoDocumento : losTipoDocumentos) {
			log.info("Id:"+tipoDocumento.getTdocId());
			log.info("Nombre:"+tipoDocumento.getNombre());
		}
		
		losTipoDocumentos.forEach(tipoDocumento->{
			log.info("Id:"+tipoDocumento.getTdocId());
			log.info("Nombre:"+tipoDocumento.getNombre());
		});
	}
	
}
