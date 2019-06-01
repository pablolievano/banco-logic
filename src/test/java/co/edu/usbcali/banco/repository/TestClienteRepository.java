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

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestClienteRepository {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	long clienId = 142020L;
	
	@DisplayName("CrearCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void aTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		Cliente cliente = clienteRepository.findById(clienId);
		assertNull(cliente, "El cliente no es nulo");
		
		cliente = new Cliente();
		cliente.setActivo("N");
		cliente.setClieId(clienId);
		cliente.setDireccion("Avenida siempre viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero Jay Thompson");
		cliente.setTelefono("123456");
		
		TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(1L);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		cliente.setTipoDocumento(tipoDocumento);
		
		clienteRepository.save(cliente);
	}
	
	@DisplayName("ModificarCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void bTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		Cliente cliente = clienteRepository.findById(clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		cliente.setActivo("S");
		cliente.setClieId(clienId);
		cliente.setDireccion("Avenida siempre viva 123 456");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero Jay Simpson");
		cliente.setTelefono("123456");
		
		TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(2L);
		assertNotNull(tipoDocumento, "El tipo de documento es nulo");
		
		cliente.setTipoDocumento(tipoDocumento);
		
		clienteRepository.update(cliente);
	}
	
	@DisplayName("BorrarCliente")
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void cTest() {
		assertNotNull(clienteRepository);
		
		Cliente cliente = clienteRepository.findById(clienId);
		assertNotNull(cliente, "El cliente es nulo");
		
		clienteRepository.delete(cliente);
	}
	
	/*private final static Logger log = LoggerFactory.getLogger(TestClienteRepository.class);
	@DisplayName("ConsultarTodos")
	@Test
	@Transactional(readOnly=true)
	void dTest() {
		assertNotNull(clienteRepository);
		
		List<Cliente> losClientes = clienteRepository.findAll();
		
		for (Cliente cliente : losClientes) {
			log.info("Id:"+cliente.getClieId());
			log.info("Nombre:"+cliente.getNombre());
		}
		
		losClientes.forEach(cliente->{
			log.info("Id:"+cliente.getClieId());
			log.info("Nombre:"+cliente.getNombre());
		});
	}*/

}
