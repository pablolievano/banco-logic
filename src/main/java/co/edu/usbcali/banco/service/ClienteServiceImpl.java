package co.edu.usbcali.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.repository.ClienteRepository;
import co.edu.usbcali.banco.repository.TipoDocumentoRepository;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
@Scope("singleton")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private Validator validator;

	public void validar(Cliente cliente) throws Exception {
	    try {
	        Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Cliente> constraintViolation : constraintViolations) {
	                strMessage.append(constraintViolation.getPropertyPath()
	                                                     .toString());
	                strMessage.append(" - ");
	                strMessage.append(constraintViolation.getMessage());
	                strMessage.append(". \n");
	            }

	            throw new Exception(strMessage.toString());
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("El cliente es nulo");
		}
		validar(cliente);
		
		Cliente entity = clienteRepository.findById(cliente.getClieId());
		if(entity != null) {
			throw new Exception("No se puede crear porque ya existe el cliente.");
		}
		
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("El cliente es nulo");
		}
		validar(cliente);
		
		Cliente entity = clienteRepository.findById(cliente.getClieId());
		if(entity == null) {
			throw new Exception("No se puede modificar porque no existe el cliente.");
		}
		
		clienteRepository.update(cliente);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("El cliente es nulo");
		}
		Cliente entity=clienteRepository.findById(cliente.getClieId());
		clienteRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

}
