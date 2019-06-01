package co.edu.usbcali.banco.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
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

import co.edu.usbcali.banco.domain.TipoUsuario;
import co.edu.usbcali.banco.domain.Usuario;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestUsuarioService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	String usuUsuario = "usuario_prueba";
	BigDecimal identificacion = new BigDecimal("123456789");
	
	@DisplayName("CrearUsuario")
	@Test
	void aTest()throws Exception {
		assertNotNull(usuarioService);
		assertNotNull(tipoUsuarioService);
		
		Usuario usuario = usuarioService.findById(usuUsuario);
		assertNull(usuario, "El usuario no es nulo");
		
		usuario = new Usuario();
		usuario.setActivo("S");
		usuario.setUsuUsuario(usuUsuario);
		usuario.setClave("Clavesita123");
		usuario.setIdentificacion(identificacion);
		usuario.setNombre("Homero Jay Thompson");
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(1L);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		usuario.setTipoUsuario(tipoUsuario);
		
		usuarioService.save(usuario);
	}
	
	@DisplayName("ModificarUsuario")
	@Test
	void bTest() throws Exception {
		assertNotNull(usuarioService);
		assertNotNull(tipoUsuarioService);
		
		Usuario usuario = usuarioService.findById(usuUsuario);
		assertNotNull(usuario, "El usuario es nulo");
		
		usuario.setActivo("N");
		usuario.setUsuUsuario(usuUsuario);
		usuario.setClave("Clavesita1234");
		usuario.setIdentificacion(identificacion);
		usuario.setNombre("Homero Jay SImpson");
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(2L);
		assertNotNull(tipoUsuario, "El tipo de usuario es nulo");
		
		usuario.setTipoUsuario(tipoUsuario);
		
		usuarioService.update(usuario);
	}
	
	@DisplayName("BorrarUsuario")
	@Test
	void cTest()throws Exception {
		assertNotNull(usuarioService);
		
		Usuario usuario = usuarioService.findById(usuUsuario);
		assertNotNull(usuario, "El cliente es nulo");
		
		usuarioService.delete(usuario);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestUsuarioService.class);
	@DisplayName("ConsultarTodos")
	@Test
	void dTest() {
		assertNotNull(usuarioService);
		
		List<Usuario> losUsuarios = usuarioService.findAll();
		
		/*for (Usuario usuario : losUsuarios) {
			log.info("Usuario:"+usuario.getUsuUsuario());
			log.info("Nombre:"+usuario.getNombre());
		}*/
		
		losUsuarios.forEach(usuario->{
			log.info("Usuario:"+usuario.getUsuUsuario());
			log.info("Nombre:"+usuario.getNombre());
		});
	}
	
}
