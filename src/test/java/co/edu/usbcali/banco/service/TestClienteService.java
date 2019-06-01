package co.edu.usbcali.banco.service;

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

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestClienteService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	long clienId = 142020L;
	
	@DisplayName("CrearCliente")
	@Test
	void aTest()throws Exception {
		assertNotNull(clienteService);
		assertNotNull(tipoDocumentoService);
		
		Cliente cliente = clienteService.findById(clienId);
		assertNull(cliente, "El cliente no es nulo");
		
		cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setClieId(clienId);
		cliente.setDireccion("Avenida siempre viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero Jay Thompson");
		cliente.setTelefono("123456");
		
		TipoDocumento tipoDocumento = tipoDocumentoService.findById(1L);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		cliente.setTipoDocumento(tipoDocumento);
		
		clienteService.save(cliente);
	}
	
	@DisplayName("ModificarCliente")
	@Test
	void bTest() throws Exception {
		assertNotNull(clienteService);
		assertNotNull(tipoDocumentoService);
		
		Cliente cliente = clienteService.findById(clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		cliente.setActivo("N");
		cliente.setClieId(clienId);
		cliente.setDireccion("Avenida siempre viva 123 456");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero Jay Simpson");
		cliente.setTelefono("123456");
		
		TipoDocumento tipoDocumento = tipoDocumentoService.findById(2L);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		cliente.setTipoDocumento(tipoDocumento);
		
		clienteService.update(cliente);
	}
	
	@DisplayName("BorrarCliente")
	@Test
	void cTest()throws Exception {
		assertNotNull(clienteService);
		
		Cliente cliente = clienteService.findById(clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		clienteService.delete(cliente);
	}
	
	private final static Logger log = LoggerFactory.getLogger(TestClienteService.class);
	@DisplayName("ConsultarTodos")
	@Test
	void dTest() {
		assertNotNull(clienteService);
		
		List<Cliente> losClientes = clienteService.findAll();
		
		/*for (Cliente cliente : losClientes) {
			log.info("Id:"+cliente.getClieId());
			log.info("Nombre:"+cliente.getNombre());
		}*/
		
		losClientes.forEach(cliente->{
			log.info("Id:"+cliente.getClieId());
			log.info("Nombre:"+cliente.getNombre());
		});
	}

}
