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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.domain.TipoUsuario;
import co.edu.usbcali.banco.repository.TipoDocumentoRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTipoUsuarioService {
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	Long tiuId = 4L;
	
	@DisplayName("CrearTipoDocumento")
	@Test
	void aTest()throws Exception {
		assertNotNull(tipoUsuarioService);
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(tiuId);
		assertNull(tipoUsuario, "El tipo de usuario es nulo");
		
		tipoUsuario = new TipoUsuario();
		tipoUsuario.setActivo("S");
		tipoUsuario.setTiusId(tiuId);
		tipoUsuario.setNombre("Tipo de usuario de prueba");
		
		tipoUsuarioService.save(tipoUsuario);
	}
	
	@DisplayName("ModificarTipoDocumento")
	@Test
	void bTest() throws Exception {
		assertNotNull(tipoUsuarioService);
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(tiuId);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		tipoUsuario.setActivo("N");
		tipoUsuario.setTiusId(tiuId);
		tipoUsuario.setNombre("Tipo de prueba");
		
		tipoUsuarioService.update(tipoUsuario);
	}
	
	@DisplayName("BorrarTipoDocumento")
	@Test
	void cTest()throws Exception {
		assertNotNull(tipoUsuarioService);
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(tiuId);
		assertNotNull(tipoUsuario, "El Tipo de usuario es nulo");
		
		tipoUsuarioService.delete(tipoUsuario);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestTipoUsuarioService.class);
	@DisplayName("ConsultarTodos")
	@Test
	void dTest() {
		assertNotNull(tipoUsuarioService);
		
		List<TipoUsuario> losTipoUsuarios = tipoUsuarioService.findAll();
		
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
