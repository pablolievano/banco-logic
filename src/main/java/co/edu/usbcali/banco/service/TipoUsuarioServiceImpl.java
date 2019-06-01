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

import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.domain.TipoUsuario;
import co.edu.usbcali.banco.repository.TipoUsuarioRepository;

@Service
@Scope("singleton")
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	private Validator validator;
	
	public void validar(TipoUsuario tipoUsuario) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoUsuario>> constraintViolations = validator.validate(tipoUsuario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoUsuario> constraintViolation : constraintViolations) {
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
	public void save(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario == null) {
			throw new Exception("El tipo de documento es nulo");
		}
		validar(tipoUsuario);
		
		TipoUsuario entity = tipoUsuarioRepository.findById(tipoUsuario.getTiusId());
		if(entity != null) {
			throw new Exception("No se puede crear porque ya existe el tipo de documento.");
		}
		
		tipoUsuarioRepository.save(tipoUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario == null) {
			throw new Exception("El tipo de documento es nulo");
		}
		validar(tipoUsuario);
		
		TipoUsuario entity = tipoUsuarioRepository.findById(tipoUsuario.getTiusId());
		if(entity == null) {
			throw new Exception("No se puede modificar porque no existe el cliente.");
		}
		
		tipoUsuarioRepository.update(tipoUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario == null) {
			throw new Exception("El tipo de documento es nulo");
		}
		TipoUsuario entity=tipoUsuarioRepository.findById(tipoUsuario.getTiusId());
		tipoUsuarioRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoUsuario findById(Long id) {
		return tipoUsuarioRepository.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll();
	}

}
