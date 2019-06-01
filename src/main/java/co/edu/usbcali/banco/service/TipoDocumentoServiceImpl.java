package co.edu.usbcali.banco.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.repository.TipoDocumentoRepository;

@Service
@Scope("singleton")
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private Validator validator;
	
	public void validar(TipoDocumento tipoDocumento) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoDocumento>> constraintViolations = validator.validate(tipoDocumento);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoDocumento> constraintViolation : constraintViolations) {
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
	public void save(TipoDocumento tipoDocumento) throws Exception {
		if(tipoDocumento == null) {
			throw new Exception("El tipo de documento es nulo");
		}
		validar(tipoDocumento);
		
		TipoDocumento entity = tipoDocumentoRepository.findById(tipoDocumento.getTdocId());
		if(entity != null) {
			throw new Exception("No se puede crear porque ya existe el tipo de documento.");
		}
		
		tipoDocumentoRepository.save(tipoDocumento);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoDocumento tipoDocumento) throws Exception {
		if(tipoDocumento == null) {
			throw new Exception("El tipo de documento es nulo");
		}
		validar(tipoDocumento);
		
		TipoDocumento entity = tipoDocumentoRepository.findById(tipoDocumento.getTdocId());
		if(entity == null) {
			throw new Exception("No se puede modificar porque no existe el cliente.");
		}
		
		tipoDocumentoRepository.update(tipoDocumento);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoDocumento tipoDocumento) throws Exception {
		if(tipoDocumento == null) {
			throw new Exception("El tipo de documento es nulo");
		}
		TipoDocumento entity=tipoDocumentoRepository.findById(tipoDocumento.getTdocId());
		tipoDocumentoRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoDocumento findById(Long id) {
		return tipoDocumentoRepository.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoDocumento> findAll() {
		return tipoDocumentoRepository.findAll();
	}
	
}
