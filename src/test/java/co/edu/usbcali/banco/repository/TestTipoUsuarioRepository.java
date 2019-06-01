package co.edu.usbcali.banco.repository;

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

import co.edu.usbcali.banco.domain.TipoUsuario;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTipoUsuarioRepository {
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	Long tiusId = 6L;

	@DisplayName("CrearTipoUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(tipoUsuarioRepository);
		
		TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(tiusId);
		assertNull(tipoUsuario, "El tipo de documento no es nulo");
		
		tipoUsuario = new TipoUsuario();
		tipoUsuario.setNombre("Pasaporte");
		tipoUsuario.setActivo("S");
		tipoUsuario.setTiusId(tiusId);
		
		tipoUsuarioRepository.save(tipoUsuario);
	}
	
	@DisplayName("ModificarTipoUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(tipoUsuarioRepository);
		
		TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(tiusId);
		assertNotNull(tipoUsuario, "El tipo de documento es nulo");
		
		tipoUsuario = new TipoUsuario();
		tipoUsuario.setNombre("Pasaporte otro");
		tipoUsuario.setActivo("N");
		tipoUsuario.setTiusId(tiusId);
		
		tipoUsuarioRepository.update(tipoUsuario);
	}
	
	@DisplayName("BorrarTipoUsuario")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(tipoUsuarioRepository);
		
		TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(tiusId);
		assertNotNull(tipoUsuario, "El tipo de documento es nulo");
		
		tipoUsuarioRepository.delete(tipoUsuario);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestTipoUsuarioRepository.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(tipoUsuarioRepository);
		
		List<TipoUsuario> lostipoUsuarios = tipoUsuarioRepository.findAll();
		
		for (TipoUsuario tipoUsuario : lostipoUsuarios) {
			log.info("Id:"+tipoUsuario.getTiusId());
			log.info("Nombre:"+tipoUsuario.getNombre());
		}
		
		lostipoUsuarios.forEach(tipoUsuario->{
			log.info("Id:"+tipoUsuario.getTiusId());
			log.info("Nombre:"+tipoUsuario.getNombre());
		});
	}
	
}
